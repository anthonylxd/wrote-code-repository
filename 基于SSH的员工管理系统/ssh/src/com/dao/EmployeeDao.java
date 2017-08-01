package com.dao;

import com.domain.Employee;

/*
 * 员工管理dao层的接口
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

}
