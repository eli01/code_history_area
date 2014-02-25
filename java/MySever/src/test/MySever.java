/*第一个服务器端程序，让它在9999端口监听，可以接受从客户端发啊来的信息*/
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
			//在9999端口监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我是服务器，我在9999端口监听");
			Socket s=ss.accept();//等待某个客户端来连接，该函数会返回一个socket连接
			System.out.println("此时不堵塞！");
			//要读取s中传递的数据
			InputStreamReader isr=new InputStreamReader(s.getInputStream()); 
			BufferedReader br=new BufferedReader(isr);
			String info=br.readLine();
			System.out.println("服务器接收到："+info);
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("我是服务器，你也好！");
		}catch(Exception e){
			
		}finally{
			
		}
	}
}
