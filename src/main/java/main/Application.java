package main;

import org.json.JSONObject;

import converter.XMLtoJSON;

public class Application {

	public static void main(String []args) {
		JSONObject json = XMLtoJSON.convertXMLFileToJSON("parknodedata.xml");
		System.out.println(json.toString(4));
	}
}
