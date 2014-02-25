package StudentsManager1;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
public class StudentsManager1 extends JFrame{
	//rowData用来存放行数据
	//columnNames存放列名
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	StudentsManager1 sm=new	StudentsManager1();
	}
	//构造函数
	public StudentsManager1()
	{
		columnNames=new Vector();//设置列名
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowData=new Vector();
		Vector hang=new Vector();
		hang.add("sp001");
		hang.add("孙悟空");
		hang.add("男");
		hang.add("500");
		hang.add("花果山");
		hang.add("少林");
		rowData.add(hang);
		
		jt=new JTable(rowData,columnNames);//初始化JTable
		jsp=new JScrollPane(jt);
		//将jsp放入jframe
		this.add(jsp);//默认加到面板的中间
		this.setSize(400,300);
		this.setLocation(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
