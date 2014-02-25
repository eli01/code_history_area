package com.nemo.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.nemo.basic.BasicService;
import com.nemo.domain.Department;
import com.nemo.service.interfaces.DepartmentServiceInterface;
@Transactional
public class DepartmentService extends BasicService implements DepartmentServiceInterface {

	@Override
	public void addDepartment(Department dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department getDepartmentById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}



}
