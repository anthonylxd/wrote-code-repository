package com.service.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.dao.DepartmentDao;
import com.domain.Department;
import com.domain.PageBean;
import com.service.DepartmentService;

/*
 * 部门管理的业务层的实现类
 */

@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	//注入部门管理的DAO
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	//分页查询部分的方法
	public PageBean<Department> findByPage(Integer currPage){
		PageBean<Department> pageBean = new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	//业务层保存部门的方法
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	//业务层根据部门ID查询部门的方法
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}
}
