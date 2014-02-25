import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DataBaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	  Connection ctt=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
		//1.加载驱动
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2.得到连接
			ctt=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=spdb","sa","truman");		
			ps=ctt.prepareStatement("select top 1 passwd from users");
			rs=ps.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ctt!=null) ctt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
			
	}

}
