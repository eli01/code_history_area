/*这是一个客户端程序*/
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
			//Socket()就是连接某个服务器，127,。0.0.1表示服务器的ip地址
			//9999表示端口号
			Socket s=new Socket("127.0.0.1",9999);//如果s连接成功，就可以向s发送数据
			//我们通过pw向s写数据,true表示及时刷新
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("你好吗？我是客户端！");
			//要求取s中传递的数据
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String response=br.readLine();
			System.out.println("我是客户端，接收到信息："+response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
