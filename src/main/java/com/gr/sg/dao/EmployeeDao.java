package com.gr.sg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.sg.pojo.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void createTable() {
		String query = "create table employee(eid int ,ename varchar(20),email varchar(50))";
		jdbcTemplate.execute(query);
		System.out.println("Table Created");
	}

	public int insertTable(Employee emp) {
		String query = "insert into employee(eid,ename,email) values(?,?,?)";
		return jdbcTemplate.update(query, emp.getEid(), emp.getEname(), emp.getEmail());

	}

	
	public Employee getEmployeeById(int eid) {
		String sql = "Select * from employee where eid=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { eid }, (rs, rno) -> {
			Employee emp = new Employee(rs.getInt("eid"), rs.getString("ename"), rs.getString("email"));
			return emp;
		});
	}

	public String getEmployeeNameById(int eid) {
		String sql = "Select ename from employee where eid=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { eid }, String.class);

		// new EmployeeRowMapper()
	}

	public List<Employee> getEmployee() {
		String sql = "select * from employee";
		return jdbcTemplate.query(sql, new EmployeeResultSetExtractor());

	}

	/*
	 * public List<String> getEmployeeNames() { String sql =
	 * "select ename from employee"; return jdbcTemplate.queryForList(sql,
	 * String.class);
	 * 
	 * }
	 */

	public Map<String, Object> getEmployeeNames() {
		String sql = "select ename,email from employee where eid=111";
		return jdbcTemplate.queryForMap(sql);

	}

	public void update(Employee emp) {
		String sql = "update employee Set ename=?,email=? where eid=?";
		jdbcTemplate.update(sql, emp.getEmail(), emp.getEname(), emp.getEid());
	}

	public void delete(int eid) {
		String sql = "delete from employee where eid=?";
		jdbcTemplate.update(sql, eid);
	}

	public Map<String, Object> getEmployeeMap() {
		String sql = "select eid,email,ename from employee where eid=:eid1";
		Map<String, Object> params = new HashMap<>();
		params.put("eid1", 113);
		
		return namedParameterJdbcTemplate.queryForMap(sql, params);

	}

}
