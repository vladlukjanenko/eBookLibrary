package com.book.library.services.account;

/**
 * General exception class for catching all errors from {@link AccountService}.
 *
 * @author Vlad Lukjanenko.
 */
public class AccountServiceException extends Exception {

    /**
     * Default constructor.
     */
    public AccountServiceException() {
    }

    /**
     * Public constructor.
     *
     * @param message exception message
     */
    public AccountServiceException(final String message) {
        super(message);
    }

    /**
     * Public constructor.
     *
     * @param cause exception cause
     */
    public AccountServiceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Public constructor.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public AccountServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}