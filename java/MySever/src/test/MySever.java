/*��һ���������˳���������9999�˿ڼ��������Խ��ܴӿͻ��˷���������Ϣ*/
package test;
import java.net.*;
import java.io.*;
public class MySever {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySever b=new MySever();
	}
	
	public MySever()
	{
		try{
			//��9999�˿ڼ���
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("���Ƿ�����������9999�˿ڼ���");
			Socket s=ss.accept();//�ȴ�ĳ���ͻ��������ӣ��ú����᷵��һ��socket����
			System.out.println("��ʱ��������");
			//Ҫ��ȡs�д��ݵ�����
			InputStreamReader isr=new InputStreamReader(s.getInputStream()); 
			BufferedReader br=new BufferedReader(isr);
			String info=br.readLine();
			System.out.println("���������յ���"+info);
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("���Ƿ���������Ҳ�ã�");
		}catch(Exception e){
			
		}finally{
			
		}
	}
}
