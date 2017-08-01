package com.action;

import com.domain.Employee;
import com.opensymphony.xwork2.ActionContext;
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
		//调用业务层类
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			//登录成功
			this.addActionError("用户名或密码错误！");
			return INPUT;
		}else{
			//登录失败
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}



}
