package com.hongfox.junit;

import org.junit.Test;

import com.hongfox.domain.Employee;
import com.hongfox.services.NameListServices;
import com.hongfox.services.TeamException;

public class testNameListServices {
	NameListServices namelistservices = new NameListServices();
	
	@Test
	public void testGetAllEmployees() {
		Employee[] employees = namelistservices.getAllEmployees();
		for (int i = 0;i < employees.length ; i++) {
			System.out.println(employees[i]);
		}
		
	}
	
	@Test
	public void testGetEmployee() {
		NameListServices namelistservices = new NameListServices();
		int id = 15;
		try {
			Employee employee = namelistservices.getEmployee(id);
			System.out.println(employee);
		}catch(TeamException e) {
			e.printStackTrace();
		}
	}
	
}
