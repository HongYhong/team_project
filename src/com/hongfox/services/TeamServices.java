package com.hongfox.services;

import com.hongfox.domain.Architect;
import com.hongfox.domain.Designer;
import com.hongfox.domain.Employee;
import com.hongfox.domain.Programmer;

public class TeamServices {
	private static int counter = 1;
	final int MAX_MEMBER = 5;
	final int MAX_ARCHITECT = 1;
	final int MAX_DESIGNER = 2;
	final int MAX_PROGRAMMER = 3;

	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 
	 * @Description 获取团队信息。
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月13日下午4:14:50
	 *
	 *
	 * @return
	 *
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < total; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/**
	 * 
	 * @Description 最多一名架构师，两名设计师，三名程序员
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月10日下午5:55:33
	 *
	 *
	 * @param p
	 * @throws TeamException
	 *
	 */
	public void addMember(Employee e) throws TeamException {

		if (total >= MAX_MEMBER) {
			throw new TeamException("超出队伍人数阈值。");
		}
		if (!(e instanceof Programmer)) {
			throw new TeamException("添加对象非开发人员。");
		}
		boolean isExist = existence(e);
		if (isExist) {
			throw new TeamException("当前人员已经存在队伍中！");
		}

		Programmer p = (Programmer) e;

		// 状态为busy或者vocation
		if (p.getStatus().getName().equals("BUSY") || p.getStatus().getName().equals("VOCATION"))
			throw new TeamException("该成员非空闲状态。");

		// 最多一名架构师,两名设计师，三名程序员
		int architectCount = 0;
		int designerCount = 0;
		int programmerCount = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect)
				architectCount++;
			else if (team[i] instanceof Designer)
				designerCount++;
			else if (team[i] instanceof Programmer)
				programmerCount++;
		}
		if (p instanceof Architect) {
			if (architectCount >= MAX_ARCHITECT)
				throw new TeamException("最多一名架构师！");
		} else if (p instanceof Designer) {
			if (designerCount >= MAX_DESIGNER)
				throw new TeamException("最多两名设计师！");
		} else if (p instanceof Programmer) {
			if (programmerCount >= MAX_PROGRAMMER)
				throw new TeamException("最多三名程序员！");
		}

		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		team[total++] = p;
	}

	private boolean existence(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		for (int i = 0; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				for (int j = i; j < total; j++) {
					team[j] = team[j + 1];
				}
				team[--total] = null; 
				break;
			}
		}
		throw new TeamException("找不到指定的用户。");
	}



}
