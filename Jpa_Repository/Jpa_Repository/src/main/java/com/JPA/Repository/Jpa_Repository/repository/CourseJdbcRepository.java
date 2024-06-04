package com.JPA.Repository.Jpa_Repository.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.JPA.Repository.Jpa_Repository.repository.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplete;
	
	private static String INSERT_QUERY = 
			"""
			insert into Course (id, name, author)
			values(?, ?,?);
			
			""";
	private static String DELETE_QUERY = 
			"""
			delete from Course where id=?
			
			""";
	
	private static String SELECT_QUERY = 
			"""
			select * from Course where id=?
			
			""";
	 
	public void insert(Course course) {
		springJdbcTemplete.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteById(long id) {
		springJdbcTemplete.update(DELETE_QUERY,id);
	}
	
	public Course getById(long id) {
		return springJdbcTemplete.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
	}
	
}
