package com.nemo.service.interfaces;

import java.util.List;

import com.nemo.basic.BasicServiceInterface;
import com.nemo.domain.Employee;

public interface EmployeeServiceInterface extends BasicServiceInterface{
	public List showEmployList(int pageSize,int pageNow);
	/*验证用户的方法*/
	public Employee checkEmployee(Employee e);
	/*获得页数*/
	public int getPageCount(int pageSize);
}
