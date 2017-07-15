package com.action;

import com.domain.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.EmployeeService;

/*
 * 员工管理Action
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动使用对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	//注入业务层的类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	/*
	 * 登录执行的方法
	 */
	public String login() {
		
		return NONE;
	}



}
