/**
 * �����ҵ�һ��stu���ģ��
 */
package StudentsManager1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
public class StuModel extends AbstractTableModel{

	Vector rowData,columnNames;
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	
	//Ϊ�˼��ٴ��������ȣ����Ǵ���һ����ʼ�������������������캯���б�����
	public void init(String sql)
	{
		if(sql=="")
		{
			sql="select * from stu";
		}
		columnNames=new Vector();//��������
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("ϵ��");
		
		rowData=new Vector();
		//�����ݿ�ȡ������

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman","sa","truman");
			ps=ct.prepareStatement(sql);
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
		
//		Vector hang=new Vector();
//		hang.add("sp001");
//		hang.add("�����");
//		hang.add("��");
//		hang.add("500");
//		hang.add("����ɽ");
//		hang.add("����");
	}
	//���캯������ʼ������ģ��
	public StuModel(String sql)
	{
		this.init(sql);							
	}
	public StuModel()
	{
		this.init("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//����ĺ���Ҫ����д�����ڴ���ʵ��ʱ���Զ�����
	@Override
	//���ع��ж�����
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	//���ع��ж�����
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

}
