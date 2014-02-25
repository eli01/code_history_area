package com.nemo.web.action;
import com.nemo.domain.Department;
import com.nemo.domain.Employee;
import com.nemo.service.interfaces.DepartmentServiceInterface;
import com.nemo.service.interfaces.EmployeeServiceInterface;
import com.nemo.web.form.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class EmployeeAction extends DispatchAction {
	@Resource
	private DepartmentServiceInterface departmentService;
	@Resource
	private EmployeeServiceInterface  employeeService;
		
	public void setEmployeeService(EmployeeServiceInterface employeeService) {
		this.employeeService = employeeService;
	}
	public void setDepartmentService(DepartmentServiceInterface departmentService) {
		this.departmentService = departmentService;
	}
	
	//跳转到雇员的界面
	public ActionForward goUpdEmpUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//获取雇员的id
		String id=request.getParameter("id");
		
		//获取雇员
		Employee e=(Employee) employeeService.findById(Employee.class, Integer.parseInt(id));
	
		//显示雇员信息，在下一个页面
		request.setAttribute("emp", e);
		
		return mapping.findForward("goUpdEmpUi");
		
	}
	
	//删除雇员
	public ActionForward delEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		//获取雇员的id
		String id=request.getParameter("id");
		System.out.println("删除雇员id = "+id);
		
		try {
			employeeService.delById(Employee.class, Integer.parseInt(id));
		} catch (Exception e) {
			return mapping.findForward("opererr");
			// TODO: handle exception
		}		
		//打通线路
		return mapping.findForward("operok");
	}
	
	
	/*响应跳转到显示页面请求*/
	public ActionForward goListEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}		
		// TODO Auto-generated method stub
		request.setAttribute("emplist", employeeService.showEmployList(3,pageNow));
		//测试
		int pageCount=employeeService.getPageCount(3);
		request.setAttribute("pageCount", pageCount);
		//打通线路
		return mapping.findForward("goListEmp");
	}
	
	/*响应添加雇员请求*/
	public ActionForward addEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm employeeForm=(EmployeeForm)form;
		/*创建一个domain对象*/
		Employee employee=new Employee();
		employee.setEmail(employeeForm.getEmail());
		employee.setGrade(Integer.parseInt(employeeForm.getGrade()));
		employee.setHiredate(new java.util.Date());
		employee.setName(employeeForm.getName());
		employee.setPwd(employeeForm.getPwd());
		employee.setSalary(Float.parseFloat(employeeForm.getSalary()));
		
		//该雇员是哪个部门!
		employee.setDept((Department)departmentService.findById(Department.class,(Integer.parseInt(employeeForm.getDepartmentId()))));
		//保存
		try {
			employeeService.add(employee);
		} catch (Exception e) {
			return mapping.findForward("opererr");
		}

		return mapping.findForward("operok");
	}
	
	/*响应跳转到添加界面请求*/
	public ActionForward addEmpUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("goAddEmpUi");
	}
	
	/*更新雇员*/
	public ActionForward updEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		//获取表单
		EmployeeForm ef=(EmployeeForm)form;		
		//ef->doamin
		Employee employee=new Employee();
		employee.setId(Integer.parseInt(ef.getId()));
		employee.setEmail(ef.getEmail());
		employee.setGrade(Integer.parseInt(ef.getGrade()));
		employee.setName(ef.getName());
		employee.setPwd(ef.getPwd());
		employee.setSalary(Float.parseFloat(ef.getSalary()));
		employee.setDept((Department)departmentService.findById(Department.class, Integer.parseInt(ef.getDepartmentId())));
		
		try {
			employeeService.update(employee);
		} catch (Exception e) {
			return mapping.findForward("opererr");
		}
		
		return mapping.findForward("operok");
		
	}
}
