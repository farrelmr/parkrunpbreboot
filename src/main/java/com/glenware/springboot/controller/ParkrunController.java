package com.glenware.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.glenware.springboot.form.ParkrunCourse;
import com.glenware.springboot.form.ParkrunPredict;
import com.glenware.springboot.form.validator.ParkrunValidator;
import com.glenware.springboot.repository.ParkrunCourseRepository;

@Controller
public class ParkrunController {
	
	@Autowired
	ParkrunCourseRepository parkrunCourseRepository;
	
	@Autowired
    private ParkrunValidator parkrunValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(parkrunValidator);
	}

	@ModelAttribute("parkrunCourseIterable")
	public Iterable<ParkrunCourse> parkrunCourseIterable() {
		return parkrunCourseRepository.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String parkrunPredict(Model model) {
		model.addAttribute("parkrunPredict", new ParkrunPredict());
		model.addAttribute("hasResults", false);
		return "messages/home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView parkrunPredictSubmit(
		 @Valid ParkrunPredict parkrunPredict, BindingResult result, Model model) {
		if (result.hasErrors()) 
		{
			return new ModelAndView("messages/home", "formErrors", result.getAllErrors());
		}
		else 
		{	
			ParkrunCourse selectedParkrunCourse = parkrunCourseRepository.findOne( parkrunPredict.getCourseId().longValue() );
			
			@SuppressWarnings("unchecked")
			Iterable<ParkrunCourse> parkrunCourseIterable = (Iterable<ParkrunCourse>) model.asMap().get("parkrunCourseIterable");
			for (ParkrunCourse parkrunCourse : parkrunCourseIterable ) 
			{
				long predictedTime = ( parkrunCourse.getAverageTime() * parkrunPredict.getTotalSeconds() ) / selectedParkrunCourse.getAverageTime();
				parkrunCourse.setPredictedTime(predictedTime);
			}
			
			model.addAttribute("hasResults", true);
			model.addAttribute("mm", parkrunPredict.getMm());
			model.addAttribute("ss", parkrunPredict.getSs());
		}
		return new ModelAndView("messages/home");
	}
	
}
