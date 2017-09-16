package com.book.library.rest;

import com.book.library.services.Book;
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
     * Returns all available books.
     *
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return Collections.emptyList();
    }

    /**
     * Returns book by specific id.
     *
     * @param bookId    book id.
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable long bookId) {
        return null;
    }

    /**
     * Creates new book.
     *
     * @param book    book to create.
     * @return  list of <>BOOKS</>
     * */
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String createBook(@RequestBody Book book) {
        return "";
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
        return "";
    }
}
