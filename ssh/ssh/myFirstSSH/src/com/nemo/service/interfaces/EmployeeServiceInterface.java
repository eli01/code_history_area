package com.nemo.service.interfaces;

import java.util.List;

import com.nemo.basic.BasicServiceInterface;
import com.nemo.domain.Employee;

public interface EmployeeServiceInterface extends BasicServiceInterface{
	public List showEmployList(int pageSize,int pageNow);
	/*��֤�û��ķ���*/
	public Employee checkEmployee(Employee e);
	/*���ҳ��*/
	public int getPageCount(int pageSize);
}
