package com.weego.main.dao;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.weego.main.model.Pgcs;


@Repository
public class PgcDao {
    private DB database = MongoConnectionFactory.getDatabase();

    public Pgcs getSpecifiedPgc(String pgcId) {
        DBCollection collection = database.getCollection("pgcs");
        JacksonDBCollection<Pgcs, String> jackCollection = JacksonDBCollection.wrap(collection, Pgcs.class, String.class);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(pgcId));
        return jackCollection.findOne(query);
    }
}
