import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DateStuff {
	public static void main(String[] args){
		/*String str=Calendar.getInstance().getTime().toLocaleString();
		System.out.println(str);
		int year=Calendar.getInstance().getTime().getYear();
		System.out.println(year);
		
		
		  String time="1256006105375";//long型转换成的字符串  
		  Date date= new Date(Long.parseLong(time.trim()));  
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		  String dateString = formatter.format(date);  
		  System.out.println("TIME:::"+dateString);  
		  
		 String time2="2009-10-21 10:35:05";//时间格式的字符串  
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		//Date s=null;  
		try {  
			java.util.Date s=formatter2.parse(time2);  
			System.out.println("TIME:::"+s); 
		} catch (ParseException e) {  
		// TODO Auto-generated catch block  
		e.printStackTrace();  
		}  
		 
        String time="2009-10-21 10:35:05";//时间格式的字符串
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date s=null;
        try {
             s= formatter.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("TIME:::"+s);
        */
	    Calendar   c   =   Calendar.getInstance();   
	    c.setTime(new java.util.Date());   
	    int   year =   c.get(Calendar.YEAR);   
	    int   month =   c.get(Calendar.MONTH)+1;   
	    int   day   =   c.get(Calendar.DAY_OF_MONTH);   
	    int   hour =   c.get(Calendar.HOUR_OF_DAY);   
	    int   minute =   c.get(Calendar.MINUTE);   
	    int   second =   c.get(Calendar.SECOND); 
	    
	    String s=String.valueOf(minute);
	    System.out.println(s);
	
	}
}
