/*
 * ��ʾjdbc-odbc�����ӷ�ʽ�������ݿ�
 * 1.��������Դ
 * 2.�ڳ�������������Դ
 */
 package com.test1;

import java.sql.*;


public class Test1 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		Statement sm=null;
		try{
			//1.��������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2.�õ����ӣ�ָ�����ӵ��Ǹ�����Դ���û���������
			//���ѡ�����windows.nt��֤������Ҫ��sa��,"truman"
			ct=DriverManager.getConnection("jdbc:odbc:mytest","sa","truman");
			//3.����Statement����preparedStatement[����]
			//Statement�ô���Ҫ�Ƿ���sql���
			sm=ct.createStatement();
			//4.ִ�У�crud���������ݿ⣬�������ݿ⣬ɾ�����ݣ�
			//int i=sm.executeUpdate("insert into dept values('50','������','����')");//���һ�����ݵ�dept��
			//int i=sm.executeUpdate("delete from dept where deptno='50'");
//			int i=sm.executeUpdate("update dept set loc='����' where deptno=40");
//			if(i==1)
//			{
//				System.out.println("ɾ��������ɣ�");
//			}else{
//				System.out.println("ɾ��error");
//			}
			//��ѯ����ʾ���еĲ��ź�
			//ResultSet�����
			ResultSet rs=sm.executeQuery("select *from dept");
			//��Ϊrsָ��������ǰһ��
			//ѭ��ȡ��
			while(rs.next())
			{
				int deptno=rs.getInt(1);
				String dname=rs.getString(2);
				String loc=rs.getString(3);
				System.out.println(deptno+" "+dname+" "+loc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//�ر���Դ
			//˭�ȴ򿪣�˭��ر�
			try{
				//Ϊ�˳������׳
				if(sm!=null)
				{
					sm.close();
				}
				if(ct!=null)
				{
					ct.close();
				}						
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
