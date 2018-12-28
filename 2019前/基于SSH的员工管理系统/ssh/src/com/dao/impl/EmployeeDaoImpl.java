package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.dao.EmployeeDao;
import com.domain.Employee;
/*
 * 员工类dao层的实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Override
	/*
	 * 根据用户名和密码查询用户的方法
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list= this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(list.size() >0){
			return list.get(0);
		}
		
		return null;
	}

	
}
