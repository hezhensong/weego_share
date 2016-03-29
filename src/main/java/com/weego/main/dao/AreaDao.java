package com.weego.main.dao;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.weego.main.model.Areas;

@Repository
public class AreaDao {
	private DB database = MongoConnectionFactory.getDatabase();

	public Areas getAreaById(String id) {
		DBCollection collection = database.getCollection("areas");
		JacksonDBCollection<Areas, String> jackCollection = JacksonDBCollection
				.wrap(collection, Areas.class, String.class);
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(id));
		return jackCollection.findOne(query);
	}
}
