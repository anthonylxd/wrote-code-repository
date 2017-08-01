package com.dao;

import java.util.List;

import com.domain.Department;

/*
 * 部门管理的Dao层的接口
 */
public interface DepartmentDao {

	List<Department> findByPage(int begin, int pageSize);

	int findCount();

	void save(Department department);

	Department findById(Integer did);

}
