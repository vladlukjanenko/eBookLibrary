package com.book.library.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * */
@Entity
@Access(AccessType.FIELD)
@Table(name = "account")
public class Account implements Serializable {

    /**
     * Generated serial version UID.
     * */
    private static final long serialVersionUID = 7781133000778525418L;


    /**
     * Account id.
     * */
    @Id
    @Column
    private long id;

    /**
     * Account login name.
     * */
    @Column
    private String name;

    /**
     * Account password.
     * */
    @Column
    private String password;

    /**
     * If account is confirmed.
     * */
    @Column
    private boolean confirmed;

    /**
     * Account renewal timestamp.
     * */
    @Column
    private long updated;

    /**
     * Account creation timestamp.
     * */
    @Column
    private long created;


    /**
     * Constructor.
     * */
    public Account() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(name, account.name) &&
                Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", confirmed=" + confirmed +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
