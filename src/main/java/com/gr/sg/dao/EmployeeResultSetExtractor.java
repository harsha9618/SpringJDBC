package com.gr.sg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.hr.sg.pojo.Employee;

public class EmployeeResultSetExtractor implements ResultSetExtractor<List<Employee>>{

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Employee> emps= new ArrayList<>();
		while(rs.next()) {
			Employee emp=new Employee(rs.getInt("eid"),rs.getString("ename"),rs.getString("email"));
			emps.add(emp);
		}
		return emps;
	}

}
