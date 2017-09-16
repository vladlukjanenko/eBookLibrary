package com.book.library.services;

import com.book.library.services.persistence.MongoConnector;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * {@link BookService} implementation.
 *
 * @author Vlad Lukjanenko.
 */
@Service
public class BookServiceImpl implements BookService {

    /**
     * {@link DataSource} instance.
     * */
    private Datastore datastore;


    /**
     * Default constructor.
     * */
    public BookServiceImpl() {
        datastore = MongoConnector.getDatabase();
    }

    @Override
    public Book getBook(long id) throws BookServiceException {
        return datastore.createQuery(Book.class).field("_id").equal(new ObjectId()).get();
    }

    @Override
    public List<Book> getBooks() throws BookServiceException {
        return datastore.createQuery(Book.class).asList();
    }

    @Override
    public void saveBook(Book book) throws BookServiceException {

        if (book == null) {
            throw new BookServiceException("Unable to save Book object. Values is null.");
        }

        datastore.save(book);
    }

    @Override
    public void deleteBook(long id) throws BookServiceException {

        Book book = datastore.createQuery(Book.class).field("_id").equal(new ObjectId()).get();

        if (book == null) {
            return;
        }

        datastore.delete(book).isUpdateOfExisting();
    }
}
