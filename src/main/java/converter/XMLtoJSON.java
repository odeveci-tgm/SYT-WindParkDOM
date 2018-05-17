package converter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

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
}
