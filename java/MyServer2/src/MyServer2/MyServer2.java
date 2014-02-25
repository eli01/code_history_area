/**
 * 时间：2013.1.18
 * 作者：孟庆申
 * 功能：在前一个实例（单工）的基础上构建一个半双工的通信程序实例
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
			ServerSocket ss=new ServerSocket(9999);//监听端口
			Socket s=ss.accept();//堵塞，等待连接
			
			//先接收从客户端发来的信息
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			//接收从控制台输入的信息
			InputStreamReader isr2=new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true)
			{
				String infoFromClient=br.readLine();
				System.out.println("客户端发来："+infoFromClient);
				if(infoFromClient.equals("bye"))
				{
					System.out.println("对话结束！");
					s.close();
					break;
				}
				//接收从控制台输入的信息
				System.out.println("输入你希望对客户端说的话：");
				String response=br2.readLine();
				//把从控制台接收的信息，回送给客户端
				pw.println(response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
