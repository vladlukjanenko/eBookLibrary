package com.book.library.services.author;

import com.book.library.model.Author;
import com.book.library.services.persistence.MongoConnector;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * {@link AuthorService} implementation.
 *
 * @author Vlad Lukjanenko.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    /**
     * {@link DataSource} instance.
     * */
    private Datastore datastore;


    /**
     * Default constructor.
     * */
    public AuthorServiceImpl() {
        datastore = MongoConnector.getDatabase();
    }

    @Override
    public Author getAuthor(ObjectId id) throws AuthorServiceException {
        return datastore.createQuery(Author.class).field("_id").equal(id).get();
    }

    @Override
    public List<Author> getAuthors() throws AuthorServiceException {
        return datastore.createQuery(Author.class).asList();
    }

    @Override
    public void savAuthor(Author author) throws AuthorServiceException {

        if (author == null) {
            throw new AuthorServiceException("Unable to save Author object. Values is null.");
        }

        datastore.save(author);
    }

    @Override
    public void deleteAuthor(ObjectId id) throws AuthorServiceException {

        Author author = datastore.createQuery(Author.class).field("_id").equal(id).get();

        if (author == null) {
            throw new AuthorServiceException("Author by id=" + id + " not found.");
        }

        datastore.delete(author).isUpdateOfExisting();
    }
}
