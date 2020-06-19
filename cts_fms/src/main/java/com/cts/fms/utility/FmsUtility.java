package com.cts.fms.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FmsUtility {
	
	public static String getDateInDDMMYYYY(Date myDate) {
		
		 SimpleDateFormat mdyFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		    SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");

		    // Format the date to Strings
		    String mdy = mdyFormat.format(myDate);
		    String dmy = dmyFormat.format(myDate);

		    // Results...
		    System.out.println(mdy);
		    System.out.println(dmy);
		    // Parse the Strings back to dates
		    // Note, the formats don't "stick" with the Date value
		    try {
				System.out.println(mdyFormat.parse(mdy));
				 System.out.println(dmyFormat.parse(dmy));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		return  mdy;
		
	}
	
	
	public static java.sql.Date stringToUtilDate(String date) {
		
		
		String sDate1=date;  
	    Date date1 = new Date();
	    
	    
		try {
			if(date!=null &&!(date.equals("")))
			{date1 = new SimpleDateFormat("MM/dd/yy").parse(date);}
			else
			{
				date1 = new SimpleDateFormat("MM/dd/yy").parse(new Date().toString());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		java.sql.Date sDate = new java.sql.Date(date1.getTime());
	    System.out.println(sDate1+"\t"+sDate);  
	    
	    
		return sDate;
		
		
	}
	
	public static  double parseDouble(String no) {
		if(no!=null)
			return Double.parseDouble(no);
		return 0;
	}
	

}
