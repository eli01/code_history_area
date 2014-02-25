package com.yourcompany.service;

import java.util.ArrayList;

import com.yourcompany.domin.RegisterInfo;
import com.yourcompany.utils.SqlHelper;

public class RegistService {
	/*该方法被action调用调用SqlHelper完成添加注册用户姓名、头像名、头像名的唯一标识数到数据库*/
	public boolean registerAdd(RegisterInfo ri){
		boolean b=false;
		String sql="insert into registerInfo values(?,?,?)";
		String[] paras={ri.getName(),ri.getPhoto(),ri.getPhotouuid()};
		try {
			SqlHelper.executeUpdate(sql, paras);
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接数据库异常！");
		}
		return b;	
	}
	/*该方法完成到数据库取出数据*/
	public ArrayList getRegList(){
		String sql="select * from registerInfo";
		ArrayList al=SqlHelper.executeQuery(sql, null);
		ArrayList<RegisterInfo> alReg=new ArrayList<RegisterInfo>(); 
		/*对获得的al进行二次封装*/
		for(int i=0;i<al.size();i++){
			Object[] ob=(Object[])al.get(i);//取出要封装的对象数组
			RegisterInfo ri=new RegisterInfo();//创建一个新的domin对象
			ri.setName(ob[0].toString());
			ri.setPhoto(ob[1].toString());
			ri.setPhotouuid(ob[2].toString());
			
			alReg.add(ri);//添加到新的ArrayList
		}
		return alReg;
	}
	
	/*通过用户名返回RegisterInfo对象*/
	public RegisterInfo getRI(String username){
		String sql="select * from registerInfo where name=?";
		System.out.println(sql);
		ArrayList al=SqlHelper.executeQuery(sql, new String[]{username});
		System.out.println("al.size()"+al.size());
		 RegisterInfo ri=new  RegisterInfo();
		 Object[] ob=(Object[])al.get(0);
		 
		 ri.setName(ob[0].toString());
		 ri.setPhoto(ob[1].toString());
		 ri.setPhotouuid(ob[2].toString());
		 return ri;
	}
	
}
