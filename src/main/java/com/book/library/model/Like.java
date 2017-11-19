package com.book.library.model;

import org.mongodb.morphia.annotations.Embedded;

import java.io.Serializable;

/**
 * Represents like entity.
 *
 * @author Vlad Lukjanenko.
 */
@Embedded
public class Like implements Serializable {

    /**
     * Account id.
     * */
    private String accountId;


    /**
     * Default constructor.
     * */
    public Like() {

    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        return accountId != null ? accountId.equals(like.accountId) : like.accountId == null;

    }

    @Override
    public int hashCode() {
        return accountId != null ? accountId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Like{" +
                "accountId='" + accountId + '\'' +
                '}';
    }
}
