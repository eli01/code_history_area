/**
 * ����һ�������ݿ���в�������
 */
package StudentsManager2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
	//����������ݿ���Ҫ�ı����ͺ���
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman";
	String user="sa";
	String passwd="truman";
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public ResultSet queryExecute(String sql)//sql��䲻��������Ƶ����
	{
		try{
			//1.��������
			Class.forName(driver);
			//2.�õ�����
			ct=DriverManager.getConnection(url,user,passwd);
			//3.����ps
			ps=ct.prepareStatement(sql);
			//System.out.println("�Ƿ񴴽�����43");
			
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//�ر���Դ
		}
		return rs;
	}
	
	//��ѯ���ݿ�Ĳ���
	public ResultSet queryExecute(String sql,String[] paras)//���в�����Ƶ����
	{
		try{
			//1.��������
			Class.forName(driver);
			//2.�õ�����
			ct=DriverManager.getConnection(url,user,passwd);
			//3.����ps
			ps=ct.prepareStatement(sql);
			//System.out.println("�Ƿ񴴽�����43");
			//��ps���ʺŸ�ֵ
			for(int i=0;i<paras.length;i++)//һ��ʼдi=1������δΪ1���ò���ֵ��������������ڣ��Ǹ����ƣ���̼��֣�
			{
				ps.setString(i+1, paras[i]);
				 //System.out.println(paras[i]);
			}
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//�ر���Դ
		}
		return rs;
	}
	
	//�ر����ݿ���Դ
	public void close()
	{
		try {
			
			if(ps!=null)
			{
				ps.close();
			}
			if(ct!=null)
			{
				ct.close();
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// System.out.println("StuModel 72");
	
			e.printStackTrace();
		}
	}
	
	//����ɾ�ķ���һ��
	public boolean updExecute(String sql,String []paras)
	{
		boolean b=true;
		try{
			//1.��������
			Class.forName(driver);
			//2.�õ�����
			ct=DriverManager.getConnection(url,user,passwd);
			//3.����ps
			ps=ct.prepareStatement(sql);
			//System.out.println("�Ƿ񴴽�����43");
			//��ps���ʺŸ�ֵ
			for(int i=0;i<paras.length;i++)//һ��ʼдi=1������δΪ1���ò���ֵ��������������ڣ��Ǹ����ƣ���̼��֣�
			{
				ps.setString(i+1, paras[i]);
				 //System.out.println(paras[i]);
			}
			
			//4.ִ�в���
			//ps.executeUpdate();
			if(ps.executeUpdate()!= 1)
				{
				    //System.out.println("StuModel 50");
					b=false;
				}
		}catch(Exception e){
			 //System.out.println("StuModel 54");
			b=false;
			e.printStackTrace();
			
		}finally{
			this.close();
		}
		return b;
	}
}
