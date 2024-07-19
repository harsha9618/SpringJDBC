package com.hr.sg.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gr.sg.dao.EmployeeDao;
import com.hr.sg.config.SpringJDBCConfig;
import com.hr.sg.pojo.Employee;

public class SpringJdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);

		EmployeeDao empDao = context.getBean("empDao", EmployeeDao.class);
		// empDao.createTable();
		/*
		 * int result = empDao.insertTable(new Employee(113, "Mumbai",
		 * "BOMBEY@gmail.com")); System.out.println(result);
		 */

		Employee emp = empDao.getEmployeeById(112);
		System.out.println(emp);

		// System.out.println(empDao.getEmployeeNameById(113));

		List<Employee> emps = empDao.getEmployee();
		System.out.println(emps);

		 System.out.println(empDao.getEmployeeNames());
		 empDao.update(new Employee(111, "BLR", "blr@gmail.com"));

		System.out.println(empDao.getEmployeeNames());
		// empDao.delete(113);

		System.out.println(empDao.getEmployeeMap());

	}

}
