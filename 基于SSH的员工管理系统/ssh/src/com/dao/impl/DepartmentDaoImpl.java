package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.dao.DepartmentDao;
import com.domain.Department;
/*
 * 部门管理的DAO层的实现类
 */


public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);	
		return list;
	}

	//分页查询部门
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//DAO中保存部门的方法
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	//DAO层根据ID查询部门方法
	@Override
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}
	
	

}
