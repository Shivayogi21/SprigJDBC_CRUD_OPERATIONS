package com.JPA.Repository.Jpa_Repository.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.JPA.Repository.Jpa_Repository.repository.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository jdbcRepository;
	
	@Override
	public void run(String... args) throws Exception {
		jdbcRepository.insert(new Course(1,"learn SpringBoot","in 28 min"));
		jdbcRepository.insert(new Course(2,"learn Springjdbc","in 28 min"));
		jdbcRepository.insert(new Course(3,"learn Springhibernate","in 28 min"));
	    
		jdbcRepository.deleteById(1);
		
		System.out.println(jdbcRepository.getById(2));
	}


	
}
