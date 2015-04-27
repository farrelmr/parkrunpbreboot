package com.glenware.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.glenware.springboot.form.ParkrunCourse;

public interface ParkrunCourseRepository extends CrudRepository<ParkrunCourse, Long> {
}