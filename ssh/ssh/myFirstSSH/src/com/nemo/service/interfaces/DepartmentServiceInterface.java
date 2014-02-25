package com.nemo.service.interfaces;

import com.nemo.basic.BasicServiceInterface;
import com.nemo.domain.Department;

public interface DepartmentServiceInterface extends BasicServiceInterface{
	/*保存部门的方法*/
	public void addDepartment(Department dept);
	/*通过id号获得Department*/
	public Department getDepartmentById(java.io.Serializable id);
}
