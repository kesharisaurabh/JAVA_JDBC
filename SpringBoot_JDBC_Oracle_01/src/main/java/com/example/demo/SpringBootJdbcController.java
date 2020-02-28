package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootJdbcController 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@RequestMapping("/insert") 
	public String index()
	{
		jdbcTemplate.execute("insert into ASTUDENT values('Nagesh','Near Devi Mandir',25)");
		return "data Inserted Succesfully";
	}
}
