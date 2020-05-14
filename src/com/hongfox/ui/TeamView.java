package com.hongfox.ui;

import com.hongfox.domain.Employee;
import com.hongfox.services.NameListServices;
import com.hongfox.services.TeamException;
import com.hongfox.services.TeamServices;
import com.hongfox.utility.TSUtility;

public class TeamView {

	private NameListServices nameSvc = new NameListServices();
	private TeamServices teamSvc = new TeamServices();

	public static void main(String[] args) {
		TeamView teamview = new TeamView();
		teamview.enterMainMenu();
	}

	public void enterMainMenu() {
		int isExit = 0;
		for (;;) {
			if (isExit == 1) {
				break;
			}
			System.out.println("-------------------------------------团队调度系统----------------------------------");
			System.out.println("id\t姓名\t姓名\t工资\t职位\t状态\t奖金\t股份\t设备");

			listAllMember();
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("1.团队列表 2.添加团队成员 3.删除团队成员 4.退出 请选择(1-4):");
			char menu = TSUtility.readMenuSelection();
			switch (menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("是否确认退出？(Y/N):");
				char YorN = TSUtility.readConfirmSelection();
				if (YorN == 'Y') {
					isExit = 1;
				}
				if (YorN == 'N') {
					isExit = 0;
				}
			}
		}
	}

	private void listAllMember() {
		Employee[] employees = nameSvc.getAllEmployees();
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
	}

	private void getTeam() {
		Employee[] team = teamSvc.getTeam();
		System.out.println("-------------------------------------团队成员----------------------------------");
		System.out.println("id\t姓名\t姓名\t工资\t职位\t状态\t奖金\t股份\t设备");
		for (int i = 0; i < teamSvc.getTotal(); i++) {
			System.out.println(team[i]);
		}
		System.out.println("------------------------------------------------------------------------------\n");
	}

	private void addMember() {
		for (;;) {
			try {
				getTeam();
				System.out.println("-------------------------------------添加成员----------------------------------");
				System.out.println("请输入要添加的成员ID：(输入-1退出)");
				int id = TSUtility.readInt();
				if (id == -1) {
					break;
				}
				teamSvc.addMember(nameSvc.getEmployee(id));
				System.out.println("添加成功！");
				TSUtility.readReturn();
			} catch (TeamException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}

	}

	private void deleteMember() {
		for (;;) {
			try {
				getTeam();
				System.out.println("-------------------------------------删除成员----------------------------------");
				System.out.println("请输入要删除的成员的团队ID：（输入-1退出）");
				int memberId = TSUtility.readInt();
				if (memberId == -1) {
					break;
				}
				teamSvc.removeMember(memberId);
			}catch(TeamException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
	}
}
