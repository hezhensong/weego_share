package com.weego.main.dao;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.weego.main.model.Activities;

@Repository
public class ActivityDao {

	private DB database = MongoConnectionFactory.getDatabase();

	public Activities getSpecifiedCity(String cityActivityId) {
		DBCollection collection = database.getCollection("activities");
		JacksonDBCollection<Activities, String> coll = JacksonDBCollection.wrap(collection, Activities.class,
				String.class);
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(cityActivityId));
		return coll.findOne(query);
	}

}
