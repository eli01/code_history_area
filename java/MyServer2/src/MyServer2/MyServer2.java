/**
 * ʱ�䣺2013.1.18
 * ���ߣ�������
 * ���ܣ���ǰһ��ʵ�����������Ļ����Ϲ���һ����˫����ͨ�ų���ʵ��
 * **/
package MyServer2;
import java.net.*;
import java.io.*;
public class MyServer2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer2 ms2=new MyServer2();
	}
	public MyServer2()
	{
		try {
			ServerSocket ss=new ServerSocket(9999);//�����˿�
			Socket s=ss.accept();//�������ȴ�����
			
			//�Ƚ��մӿͻ��˷�������Ϣ
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			//���մӿ���̨�������Ϣ
			InputStreamReader isr2=new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true)
			{
				String infoFromClient=br.readLine();
				System.out.println("�ͻ��˷�����"+infoFromClient);
				if(infoFromClient.equals("bye"))
				{
					System.out.println("�Ի�������");
					s.close();
					break;
				}
				//���մӿ���̨�������Ϣ
				System.out.println("������ϣ���Կͻ���˵�Ļ���");
				String response=br2.readLine();
				//�Ѵӿ���̨���յ���Ϣ�����͸��ͻ���
				pw.println(response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
