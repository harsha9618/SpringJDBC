package com.hr.sg.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gr.sg.dao.EmployeeDao;

@Configuration // Source of bean definations
public class SpringJDBCConfig {
	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Internally registering a class
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false"); // URL to Connect DB
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(mysqlDataSource());

	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterjdbcTemplate() {
		return new NamedParameterJdbcTemplate(mysqlDataSource());

	}

	@Bean
	public EmployeeDao empDao() {
		return new EmployeeDao();

	}

}
