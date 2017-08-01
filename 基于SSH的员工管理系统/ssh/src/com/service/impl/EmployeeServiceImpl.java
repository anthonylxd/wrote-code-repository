package com.service.impl;

import com.dao.EmployeeDao;
import com.domain.Employee;
import com.service.EmployeeService;
/*
 * 员工管理的业务实现类
 */
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	//业务层的登录方法
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
}
