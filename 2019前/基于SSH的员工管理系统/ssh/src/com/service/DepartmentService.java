package com.service;

import com.domain.Department;
import com.domain.PageBean;

/*
 * 部门管理业务层接口
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

}
