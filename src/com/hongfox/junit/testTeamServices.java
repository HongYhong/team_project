package com.hongfox.junit;

import org.junit.Test;

import com.hongfox.domain.Employee;
import com.hongfox.services.NameListServices;
import com.hongfox.services.TeamException;
import com.hongfox.services.TeamServices;

public class testTeamServices {
	@Test
	public void testAddMember() {
		try {
			TeamServices teamservices = new TeamServices();
			NameListServices namelisListServices = new NameListServices();
			Employee[] employees = namelisListServices.getAllEmployees();
			Employee[] team = teamservices.getTeam();
			// 非开发人员错误
			// teamservices.addMember(employees[0]);
			// 添加超过三个程序员
//			teamservices.addMember(employees[1]);
//			teamservices.addMember(employees[4]);
//			teamservices.addMember(employees[5]);
//			teamservices.addMember(employees[8]);
			// 添加超过两个设计师
//			teamservices.addMember(employees[6]);
			teamservices.addMember(employees[7]);
			teamservices.addMember(employees[9]);
			// 添加超过一个架构师
			teamservices.addMember(employees[2]);
			teamservices.addMember(employees[10]);

		} catch (TeamException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testRemovemember() {
		TeamServices teamservices = new TeamServices();
		NameListServices namelisListServices = new NameListServices();
		Employee[] employees = namelisListServices.getAllEmployees();
		Employee[] team = teamservices.getTeam();
		try {
			teamservices.addMember(employees[6]);
			teamservices.addMember(employees[10]);
			teamservices.removeMember(2);
			teamservices.removeMember(3);
		} catch (TeamException e) {
			e.printStackTrace();
		}
	}
}
