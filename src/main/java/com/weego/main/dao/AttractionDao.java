package com.weego.main.dao;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.weego.main.model.LatestAttractions;

@Repository
public class AttractionDao {
	private DB database = MongoConnectionFactory.getDatabase();

	public LatestAttractions getAttractionById(String id) {
		DBCollection collection = database.getCollection("latestAttractions");
		JacksonDBCollection<LatestAttractions, String> jackCollection = JacksonDBCollection
				.wrap(collection, LatestAttractions.class, String.class);
		
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(id));
		return jackCollection.findOne(query);
	}
}
