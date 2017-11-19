package com.book.library.services.author;

/**
 * General exception class for catching all errors from {@link AuthorService}.
 *
 * @author Vlad Lukjanenko.
 */
public class AuthorServiceException extends Exception {

    /**
     * Default constructor.
     */
    public AuthorServiceException() {
    }

    /**
     * Public constructor.
     *
     * @param message exception message
     */
    public AuthorServiceException(final String message) {
        super(message);
    }

    /**
     * Public constructor.
     *
     * @param cause exception cause
     */
    public AuthorServiceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Public constructor.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public AuthorServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}