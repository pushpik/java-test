package com.nibauri;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.mongodb.client.MongoDatabase;

public class Main {

    private static void checkMongoDB() {
        // write your code here
        MongoClientURI connStr = new MongoClientURI("mongodb://hexbid:hex10101@localhost:27017/hbdb");
        MongoClient mongoClient = new MongoClient(connStr);
        MongoDatabase hbdb = mongoClient.getDatabase("hbdb");
        MongoCollection<Document> collection = hbdb.getCollection("Category");

        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    public static void main(String[] args) {
        checkMongoDB();
    }
}
