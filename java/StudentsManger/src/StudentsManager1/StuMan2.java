/**
 * �����ݿ���ȡ��ѧ����Ϣ
 */
package StudentsManager1;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.sql.*;
public class StuMan2 extends JFrame{

	//rowData�������������
	//columnNames�������
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuMan2 sm2=new StuMan2();
	}
	//���캯��
		public StuMan2()
		{
			columnNames=new Vector();//��������
			columnNames.add("ѧ��");
			columnNames.add("����");
			columnNames.add("�Ա�");
			columnNames.add("����");
			columnNames.add("����");
			columnNames.add("ϵ��");
			
			rowData=new Vector();
			//�����ݿ�ȡ������
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman","sa","truman");
				ps=ct.prepareStatement("select*from stu");
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getInt(4));
					hang.add(rs.getString(5));
					hang.add(rs.getString(6));
					rowData.add(hang);
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
					try {
						if(rs!=null)
						{
							rs.close();
						}
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
						e.printStackTrace();
					}
				}
			
//			Vector hang=new Vector();
//			hang.add("sp001");
//			hang.add("�����");
//			hang.add("��");
//			hang.add("500");
//			hang.add("����ɽ");
//			hang.add("����");
			
			
			jt=new JTable(rowData,columnNames);//��ʼ��JTable
			jsp=new JScrollPane(jt);
			//��jsp����jframe
			this.add(jsp);//Ĭ�ϼӵ������м�
			this.setSize(400,300);
			this.setLocation(400,400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}

}
