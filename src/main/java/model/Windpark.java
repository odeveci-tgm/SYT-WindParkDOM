package model;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.data.annotation.Id;

import converter.XMLtoJSON;

public class Windpark {

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	
	public static double randomValue(int Low, int High) {
		double result = (Math.random() * (High - Low)) + Low;
		double rounded = round(result,2);
		return rounded;
	}
	
	  public  String randomXML(int id) {
		  Date date = new Date(System.currentTimeMillis());
		  String xml = "<windpark id=\""+id+"\"> <windrad id=\"001\"> <power>"+randomValue(10, 200)+"</power> <blindpower>"+randomValue(10, 200)+"</blindpower>\n"+ 
			  		"<windspeed>"+randomValue(10, 200)+"</windspeed>\n"+ 
			  		"<rotationspeed>"+randomValue(10, 30)+"</rotationspeed>\n"+ 
			  		"<temperature>"+randomValue(0, 30)+"</temperature>\n" + 
			  		"<bladeposition>"+randomValue(10, 360)+"</bladeposition>\n"+ 
			  		"<transfertime>"+date+"</transfertime> </windrad> </windpark>";
		  writeXML(xml);
		  return xml;
	  }
	  
	  public void writeXML(String xml) {
		  try {
			ClassLoader classLoader = Windpark.class.getClassLoader();
			File xmlfile = new File(classLoader.getResource("parknodedata.xml").getFile());
			FileOutputStream fs = new FileOutputStream(xmlfile,true);
			byte[] strToBytes = xml.getBytes();
			fs.write(strToBytes);
			fs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
}
