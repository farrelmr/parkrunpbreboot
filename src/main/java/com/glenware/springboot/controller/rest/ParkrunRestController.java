package com.glenware.springboot.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.glenware.springboot.form.ParkrunCourse;
import com.glenware.springboot.repository.ParkrunCourseRepository;

@RestController
@RequestMapping("/rest")
public class ParkrunRestController {
	
	@Autowired
	ParkrunCourseRepository parkrunCourseRepository;
	
	@RequestMapping("listcourses")
	@ResponseBody
	public List<ParkrunCourse> listCourses() {
		Iterable<ParkrunCourse> parkrunCourseIterable = parkrunCourseRepository.findAll();
		List<ParkrunCourse> parkRunCourseList = new ArrayList<ParkrunCourse>();
		for (ParkrunCourse parkrunCourse : parkrunCourseIterable ) {
			parkRunCourseList.add(parkrunCourse);
		}
		return parkRunCourseList; 
	}
	
	@RequestMapping("prcourse/{id}")
	@ResponseBody
	public ParkrunCourse getById(@PathVariable Long id) {
		return parkrunCourseRepository.findOne(id);
	}
	
}