package com.book.library.services;

/**
 * Represents book entity.
 *
 * @author Vlad Lukjanenko.
 */
public class Book {

    /**
     * Book id.
     * */
    private long id;

    /**
     * Book name.
     * */
    private String name;

    /**
     * Book author.
     * */
    private String author;


    /**
     * Default constructor.
     * */
    public Book() {

    }


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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        return name != null ? name.equals(book.name) : book.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
