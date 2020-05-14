package com.hongfox.services;
import com.hongfox.domain.*;
import static com.hongfox.services.Data.*;
import static com.hongfox.services.TeamException.*;

public class NameListServices {
	Employee[] employees;
	
	private Equitment createEquitment(int i) {
		int equitmenttype;
		equitmenttype = Integer.parseInt(EQUITMENT[i][0]);
		
		switch(equitmenttype ) {
		case PC:
			return new PC(EQUITMENT[i][1], EQUITMENT[i][2]);

		case NOTEBOOK:
			return new NoteBook(EQUITMENT[i][1], Integer.parseInt(EQUITMENT[i][2]));

		case PRINTER:
			return new Printer(EQUITMENT[i][1], EQUITMENT[i][2]);

		default:
			return null;
		}
	}
	
	public NameListServices() {
		employees = new Employee[EMPLOYEES.length];
		Equitment equitment = null;
		double bonus;
		double stock;
	

		
		for (int i = 0; i < EMPLOYEES.length;i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			int age = Integer.parseInt(EMPLOYEES[i][2]);
			String name = EMPLOYEES[i][3];
			int salary = Integer.parseInt(EMPLOYEES[i][4]);
			
			
			
			Status status = Status.FREE;
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equitment = createEquitment(i);
				employees[i] = new Programmer(id, name, age, salary, equitment, status);
				break;
			case DESIGNER:
				equitment = createEquitment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equitment, status,bonus);
				break;
			case ARCHITECT:
				equitment = createEquitment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Double.parseDouble(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equitment, status, bonus, stock);
				break;
			}
		}
	}
	
	/**
	 * 
	 * @Description 返回包含所有员工的数组。
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月13日下午10:47:58
	 *
	 *
	 * @return
	 *
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	public Employee getEmployee (int id) throws TeamException {
		if (id < 1 || id > 12) {
			throw new TeamException("找不到指定用户！");
		}
		return employees[id-1];
	}
	
	
}
