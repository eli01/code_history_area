/*����һ���ͻ��˳���*/
package client;
import java.net.*;
import java.io.*;
public class MyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient mc=new MyClient();
	}
	public MyClient()
	{
		try{
			//Socket()��������ĳ����������127,��0.0.1��ʾ��������ip��ַ
			//9999��ʾ�˿ں�
			Socket s=new Socket("127.0.0.1",9999);//���s���ӳɹ����Ϳ�����s��������
			//����ͨ��pw��sд����,true��ʾ��ʱˢ��
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("��������ǿͻ��ˣ�");
			//Ҫ��ȡs�д��ݵ�����
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String response=br.readLine();
			System.out.println("���ǿͻ��ˣ����յ���Ϣ��"+response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
