/**
 * 
 * @author Neo
 * 功能：客户端（半全工）
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
			//从控制台获得消息的流（输入流）
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			//从服务器获得消息的流
			InputStreamReader isr2=new InputStreamReader(s.getInputStream());
			BufferedReader br2=new BufferedReader(isr2);
			while(true)
			{
				System.out.println("请输入你想对服务器说的话：");
				String say=br.readLine();//客户端从控制台接收数据
				pw.println(say);//然后发送给服务器
				if(say.equals("bye"))
				{
					System.out.println("对话结束！");
					s.close();
					break;
				}
				//接收从服务器发来的话
				String infoFromServer=br2.readLine();
				System.out.println("服务器说"+infoFromServer);	
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
