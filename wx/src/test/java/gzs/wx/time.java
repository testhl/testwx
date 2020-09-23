package gzs.wx;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class time {
	public String timeA()  {
		  //打印时间戳 时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。
		   String time=String.valueOf(System.currentTimeMillis());
		   System.out.println(time);
		  return time;
		  
	}
	public String timeB()  { 
		//时间格式化
		 long cTime= System.currentTimeMillis();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		 Date date = new Date(cTime);
		 String a= formatter.format(date);
		 System.out.println(a);
		 return a;
	}
	public String timeC()  {
		  
		  //除以100 
		  String time1=String.valueOf(System.currentTimeMillis()/100);
		  System.out.println(time1);
		  return time1;
		  
	}
}
