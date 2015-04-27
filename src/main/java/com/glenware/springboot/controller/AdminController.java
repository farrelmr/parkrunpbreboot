package com.glenware.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.glenware.springboot.form.ParkrunCourse;
import com.glenware.springboot.repository.ParkrunCourseRepository;

@Controller
public class AdminController {
	
	@Autowired
	ParkrunCourseRepository parkrunCourseRepository;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAddParkrunCourse(Model model) {
		model.addAttribute("parkrunCourseIterable", parkrunCourseRepository.findAll());
		model.addAttribute("parkrunCourse", new ParkrunCourse());
		return "messages/admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView postAddParkrunCourse(
			@Valid ParkrunCourse parkrunCourse, BindingResult result, Model model) {
		if (result.hasErrors()) 
		{
			return new ModelAndView("messages/admin", "formErrors", result.getAllErrors());
		}
		else 
		{
			parkrunCourse.setAverageTime(getTimeSeconds(parkrunCourse.getMm(), parkrunCourse.getSs()));
		    parkrunCourse = parkrunCourseRepository.save(parkrunCourse);
			model.addAttribute("parkrunCourseIterable", parkrunCourseRepository.findAll());
		    System.out.println("postAddParkrunCourse success " + parkrunCourse.getCourseId());
		    return new ModelAndView("messages/admin");
		}
	}
	
	private static Long getTimeSeconds(String mm, String ss) {
		Long mmLong = Long.valueOf(mm);
		Long ssLong = Long.valueOf(ss);
		return (mmLong * 60) + ssLong;
	}
}