/**
 * 
 * @author Neo
 * ���ܣ��ͻ��ˣ���ȫ����
 *
 */
package MyClient2;
import java.net.*;
import java.io.*;
public class MyClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient2 mc2=new MyClient2();
	}
	public MyClient2()
	{
		try {	
			Socket s=new Socket("127.0.0.1",9999);
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			//�ӿ���̨�����Ϣ��������������
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			//�ӷ����������Ϣ����
			InputStreamReader isr2=new InputStreamReader(s.getInputStream());
			BufferedReader br2=new BufferedReader(isr2);
			while(true)
			{
				System.out.println("����������Է�����˵�Ļ���");
				String say=br.readLine();//�ͻ��˴ӿ���̨��������
				pw.println(say);//Ȼ���͸�������
				if(say.equals("bye"))
				{
					System.out.println("�Ի�������");
					s.close();
					break;
				}
				//���մӷ����������Ļ�
				String infoFromServer=br2.readLine();
				System.out.println("������˵"+infoFromServer);	
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
