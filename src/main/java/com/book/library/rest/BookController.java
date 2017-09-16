package com.book.library.rest;

import com.book.library.services.Book;
import com.book.library.services.BookService;
import com.book.library.services.BookServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Handles all request which comes from client side.
 *
 * @author Vlad Lukjanenko.
 */
@RestController
@RequestMapping(value = "/library")
public class BookController {

    /**
     * {@link Logger} instance.
     * */
    private static Logger LOGGER = LoggerFactory.getLogger("RestLogger");


    /**
     * {@link BookService} instance.
     * */
    @Autowired
    private BookService bookService;


    /**
     * Returns all available books.
     *
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {

        try {
            return bookService.getBooks();
        } catch (BookServiceException e) {
            LOGGER.error("Unable to get list of books. Returning empty collection", e);
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * Returns book by specific id.
     *
     * @param bookId    book id.
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable long bookId) {

        try {
            return bookService.getBook(bookId);
        } catch (BookServiceException e) {
            LOGGER.error("Unable to get book by id=" + bookId, e);
            return null;
        }
    }

    /**
     * Creates new book.
     *
     * @param book    book to create.
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String createBook(@RequestBody Book book) {

        try {
            bookService.saveBook(book);
        } catch (BookServiceException e) {
            LOGGER.error("Error occurred while saving object", e);
        }

        return "{}";
    }

    /**
     * Updates new book.
     *
     * @param book    book to update.
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public String updateBook(@RequestBody Book book) {
        return "";
    }

    /**
     * Removes existing book.
     *
     * @param bookId    book id.
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable long bookId) {

        try {
            bookService.deleteBook(bookId);
        } catch (BookServiceException e) {
            LOGGER.error("Error occurred while removing object, id=" + bookId, e);
        }

        return "{}";
    }
}
