/**
 * 这是我的一个stu表的模型
 */
package StudentsManager2;
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
	
	
	//添加函数
	public boolean updateStu(String sql,String []paras)//通过字符串数组的方式传递对sql的设置（防止注入漏洞）
	{
		//System.out.println(sql);
		//如果程序并发性不考虑，可以把sqlsever做成static
		SqlHelper sqlHelper=new SqlHelper();
		return sqlHelper.updExecute(sql, paras);
	}
	//为了减少代码的冗余度，我们创建一个初始化函数，并在两个构造函数中被调用
	//查询的本质就是初始化
	public void queryStu(String sql,String []paras)
	{
		SqlHelper sqlHelper=null;
		columnNames=new Vector();//设置列名
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowData=new Vector();
		//从数据库取出数据

		try {
			sqlHelper=new SqlHelper();
			ResultSet rs=sqlHelper.queryExecute(sql, paras);
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
			sqlHelper.close();
			}
		
//		Vector hang=new Vector();
//		hang.add("sp001");
//		hang.add("孙悟空");
//		hang.add("男");
//		hang.add("500");
//		hang.add("花果山");
//		hang.add("少林");
	}
	//构造函数：初始化数据模型


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	//下面的函数要求被重写，定在创建实例时被自动调用
	@Override
	//返回共有多少行
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	//返回共有多少列
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
