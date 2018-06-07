package converter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.XML;

public class XMLtoJSON {

	public static JSONObject convertXMLFileToJSON(String filename) {
		ClassLoader classLoader = XMLtoJSON.class.getClassLoader();
		File xmlfile = new File(classLoader.getResource(filename).getFile());
		
		String content = null;
		try {
			content = FileUtils.readFileToString(xmlfile,Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		JSONObject xmlJsonobject = XML.toJSONObject(content);
		
		return xmlJsonobject;
	}
	

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
	
	  public  static String randomXML(int id) {
		  Date date = new Date(System.currentTimeMillis());
		  String xml = "<windpark id=\""+id+"\"> <windrad id=\"001\"> <power>"+randomValue(10, 200)+"</power> <blindpower>"+randomValue(10, 200)+"</blindpower>\n"+ 
			  		"<windspeed>"+randomValue(10, 200)+"</windspeed>\n"+ 
			  		"<rotationspeed>"+randomValue(10, 30)+"</rotationspeed>\n"+ 
			  		"<temperature>"+randomValue(0, 30)+"</temperature>\n" + 
			  		"<bladeposition>"+randomValue(10, 360)+"</bladeposition>\n"+ 
			  		"<transfertime>"+date+"</transfertime> </windrad> </windpark>";
		  
		  
		  return xml;
	  }
	  
	  
}
