package com.book.library.model;

import org.mongodb.morphia.annotations.Embedded;

import java.io.Serializable;

/**
 * Represents comment entity.
 *
 * @author Vlad Lukjanenko.
 */
@Embedded
public class Comment implements Serializable {

    /**
     * Comment content.
     * */
    private String content;

    /**
     * Comment author.
     * */
    private String accountId;


    /**
     * Default constructor.
     * */
    public Comment() {

    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        Comment comment = (Comment) o;

        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        return accountId != null ? accountId.equals(comment.accountId) : comment.accountId == null;

    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
