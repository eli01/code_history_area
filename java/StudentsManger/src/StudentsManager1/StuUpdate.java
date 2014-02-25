//���ѧ���ĶԻ���
package StudentsManager1;
import java.awt.*;
//import java.awt.event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class StuUpdate extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	//Frame�����ڡ�String������������ģʽ
	public StuUpdate (Frame owner,String title,boolean modal,StuModel sm,int rowNums)
	{
		super(owner,title,modal);//���ø��๹�췽����ʼ������ģ̬
		//��ʼ�����ĸ������
		jl1=new JLabel("stuId");
		jl2=new JLabel("stuName");
		jl3=new JLabel("stuSex");
		jl4=new JLabel("stuAge");
		jl5=new JLabel("stuJg");
		jl6=new JLabel("stuDept");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		jtf5=new JTextField();
		jtf6=new JTextField();
		//��ʼ���ı���
		jtf1.setText((String)sm.getValueAt(rowNums,0));//��objectתΪString
		jtf1.setEditable(false);//������ֹ�޸�
		jtf2.setText((String)sm.getValueAt(rowNums,1));
		jtf3.setText((String)sm.getValueAt(rowNums,2));
		//jtf4.setText((String)sm.getValueAt(rowNums,3));
		jtf4.setText(sm.getValueAt(rowNums,3).toString());
		jtf5.setText((String)sm.getValueAt(rowNums,4));
		jtf6.setText((String)sm.getValueAt(rowNums,5));
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("�޸�");
		jb2=new JButton("ȡ��");
		
		//���ò��ֹ�����,jp3Ĭ��Ϊ��ʽ����
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		
		//������
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		//ע�����
		jb1.addActionListener(this);
		
		//չʾ
		this.setSize(400,300);
		this.setLocation(400,400);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);									
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//�������ݿ�
			ResultSet rs=null;
			Connection ct=null;
			PreparedStatement ps=null;
			//ResultSet rs=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=stuman","sa","truman");
				
//				String stuId=jtf1.getText().trim();
//				String stuName=jtf2.getText().trim();
//				String stuSex=jtf3.getText().trim();
//				//int stuAge=Integer.parseInt(jtf4.getText().trim());				
//				String stuJg=jtf5.getText().trim();
//				String stuDept=jtf6.getText().trim();
				
				
				//�������������ע��©��
				//ps=ct.prepareStatement("insert into stu values(stuId,stuName,stuSex,stuAge,stuJg,stuDept)");
				//�Ż�Ϊ
				//ps=ct.prepareStatement("insert into stu values(?,?,?,?,?,?)");
				String str="update stu set stuName=?,stuSex=?,stuAge=?,stuJg=?,stuDept=? where stuId=?";
				ps=ct.prepareStatement(str);
				
				ps.setString(1, jtf2.getText());
				ps.setString(2, jtf3.getText());
				ps.setString(3, jtf4.getText());//�������Զ�ת�����ܣ���Ҫ��ת�����ַ��߱���������
				//ps.setInt(4 Integer.parseInt(jtf4.getText()));
				ps.setString(4, jtf5.getText());
				ps.setString(5, jtf6.getText());
				ps.setString(6, jtf1.getText());
				
				ps.executeUpdate();//ִ�в���
				
				this.dispose();//�رնԻ���
				//System.out.println("succeed!");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		}
	}
}

