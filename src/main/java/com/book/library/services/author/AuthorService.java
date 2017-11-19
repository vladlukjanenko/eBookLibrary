package com.book.library.services.author;

import com.book.library.model.Author;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Basic service for operations on {@link Author} entities.
 *
 * @author Vlad Lukjanenko.
 */
@Service
@Component
public interface AuthorService {

    /**
     * Returns author by id.
     *
     * @param id    author id.
     * @return      {@link Author} instance or null if entity not found.
     * @throws      AuthorServiceException    if error occurs.
     * */
    Author getAuthor(ObjectId id) throws AuthorServiceException;

    /**
     * Returns all authors.
     *
     * @return      list of {@link Author} instances or null if entity not found.
     * @throws      AuthorServiceException    if error occurs.
     * */
    List<Author> getAuthors() throws AuthorServiceException;

    /**
     * Saves author.
     *
     * @param author    {@link Author} instance to save.
     * @throws          AuthorServiceException    if error occurs.
     * */
    void savAuthor(Author author) throws AuthorServiceException;

    /**
     * Removes author by id.
     *
     * @param id    author id.
     * @throws      AuthorServiceException    if error occurs.
     * */
    void deleteAuthor(ObjectId id) throws AuthorServiceException;
}
