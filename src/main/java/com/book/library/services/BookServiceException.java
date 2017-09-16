package com.book.library.services;

/**
 * General exception class for catching all errors from {@link BookService}.
 *
 * @author Vlad Lukjanenko.
 */
public class BookServiceException extends Exception {

    /**
     * Default constructor.
     */
    public BookServiceException() {
    }

    /**
     * Public constructor.
     *
     * @param message exception message
     */
    public BookServiceException(final String message) {
        super(message);
    }

    /**
     * Public constructor.
     *
     * @param cause exception cause
     */
    public BookServiceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Public constructor.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public BookServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}