package main;

import org.json.JSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import converter.XMLtoJSON;
import model.Windpark;

public class Application {

	public static MongoDatabase connectToDatabase() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("windparkDb");
		return db;
	}
	
	public static void saveToDatabase(MongoDatabase db,JSONObject json) {
		MongoCollection<org.bson.Document> collection = db.getCollection("parknode");
		collection.insertOne(org.bson.Document.parse(json.toString()));
	}
	
	public static JSONObject createNodeFile() {
		Windpark windpark = new Windpark();
		windpark.randomXML(1);
		JSONObject json = XMLtoJSON.convertXMLFileToJSON("parknodedata.xml");
		System.out.println(json.toString(4));
		return json;
	}
	
	public static void main(String []args) {
		MongoDatabase db = connectToDatabase();
		JSONObject json = createNodeFile();
		saveToDatabase(db, json);
	}
}
