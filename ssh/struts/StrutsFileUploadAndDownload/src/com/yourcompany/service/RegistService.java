package com.yourcompany.service;

import java.util.ArrayList;

import com.yourcompany.domin.RegisterInfo;
import com.yourcompany.utils.SqlHelper;

public class RegistService {
	/*�÷�����action���õ���SqlHelper������ע���û�������ͷ������ͷ������Ψһ��ʶ�������ݿ�*/
	public boolean registerAdd(RegisterInfo ri){
		boolean b=false;
		String sql="insert into registerInfo values(?,?,?)";
		String[] paras={ri.getName(),ri.getPhoto(),ri.getPhotouuid()};
		try {
			SqlHelper.executeUpdate(sql, paras);
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ��쳣��");
		}
		return b;	
	}
	/*�÷�����ɵ����ݿ�ȡ������*/
	public ArrayList getRegList(){
		String sql="select * from registerInfo";
		ArrayList al=SqlHelper.executeQuery(sql, null);
		ArrayList<RegisterInfo> alReg=new ArrayList<RegisterInfo>(); 
		/*�Ի�õ�al���ж��η�װ*/
		for(int i=0;i<al.size();i++){
			Object[] ob=(Object[])al.get(i);//ȡ��Ҫ��װ�Ķ�������
			RegisterInfo ri=new RegisterInfo();//����һ���µ�domin����
			ri.setName(ob[0].toString());
			ri.setPhoto(ob[1].toString());
			ri.setPhotouuid(ob[2].toString());
			
			alReg.add(ri);//��ӵ��µ�ArrayList
		}
		return alReg;
	}
	
	/*ͨ���û�������RegisterInfo����*/
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
