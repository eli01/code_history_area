package com.nemo.service.interfaces;

import com.nemo.basic.BasicServiceInterface;
import com.nemo.domain.Department;

public interface DepartmentServiceInterface extends BasicServiceInterface{
	/*���沿�ŵķ���*/
	public void addDepartment(Department dept);
	/*ͨ��id�Ż��Department*/
	public Department getDepartmentById(java.io.Serializable id);
}
