package com.book.library.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Basic service for operations on {@link Book} entities.
 *
 * @author Vlad Lukjanenko.
 */
@Service
@Component
public interface BookService {

    /**
     * Returns book by id.
     *
     * @param id    book id.
     * @return  {@link Book} instance or null if entity not found.
     * @throws  BookServiceException    if error occurs.
     * */
    Book getBook(long id) throws BookServiceException;

    /**
     * Returns all books.
     *
     * @return  list of {@link Book} instances or null if entity not found.
     * @throws  BookServiceException    if error occurs.
     * */
    List<Book> getBooks() throws BookServiceException;

    /**
     * Saves book.
     *
     * @param book    {@link Book} instance to save.
     * @throws  BookServiceException    if error occurs.
     * */
    void saveBook(Book book) throws BookServiceException;

    /**
     * Removes book by id.
     *
     * @param id    book id.
     * @throws  BookServiceException    if error occurs.
     * */
    void deleteBook(long id) throws BookServiceException;
}
