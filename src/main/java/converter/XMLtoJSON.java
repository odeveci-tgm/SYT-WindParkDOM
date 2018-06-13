package converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
		try {
			PrintWriter pw = new PrintWriter(xmlfile);
			pw.write("");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xmlJsonobject;
	}

	  
}
