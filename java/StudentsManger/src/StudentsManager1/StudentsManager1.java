package StudentsManager1;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
public class StudentsManager1 extends JFrame{
	//rowData�������������
	//columnNames�������
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	StudentsManager1 sm=new	StudentsManager1();
	}
	//���캯��
	public StudentsManager1()
	{
		columnNames=new Vector();//��������
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("ϵ��");
		
		rowData=new Vector();
		Vector hang=new Vector();
		hang.add("sp001");
		hang.add("�����");
		hang.add("��");
		hang.add("500");
		hang.add("����ɽ");
		hang.add("����");
		rowData.add(hang);
		
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
