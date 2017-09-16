package com.book.library.services.persistence;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Mongo connector for performing all operation with mongo DB.
 *
 * @author Vlad Lukjanenko.
 */
public final class MongoConnector {

    /**
     * {@link MongoConnector} instance.
     * */
    private static MongoConnector INSTANCE = null;

    /**
     * {@link MongoClient} instance.
     * */
    private MongoClient mongo;

    /**
     * {@link Morphia} instance.
     * */
    private Morphia morphia;

    /**
     * {@link Datastore} instance.
     * */
    private Datastore datastore;


    /**
     * Default constructor.
     * */
    private MongoConnector() {

        mongo = new MongoClient("127.0.0.1", 27017);
        morphia = new Morphia();
        morphia.mapPackage("com.book.library.services");
        datastore = morphia.createDatastore(mongo, "library");
        datastore.ensureIndexes();
    }


    /**
     * Returns {@link MongoConnector} instance.
     * */
    private static MongoConnector getInstance() {

        if (INSTANCE == null) {

            synchronized (MongoConnector.class) {

                if (INSTANCE == null) {
                    INSTANCE = new MongoConnector();
                }
            }
        }

        return INSTANCE;
    }

    /**
     * Returns {@link Datastore} instance.
     * */
    public static Datastore getDatabase() {
        return getInstance().datastore;
    }
}
