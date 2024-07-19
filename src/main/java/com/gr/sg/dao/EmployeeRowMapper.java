package com.gr.sg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.sg.pojo.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Employee emp=new Employee(rs.getInt("eid"),rs.getString("ename"),rs.getString("email"));
		return emp;
	}

}
