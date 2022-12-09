package sbs13_lab4;

public class Books {

    private Integer id;
    private BooksDescription booksDescription;
    private String name;
    private String publisher;

    public Books() {
    }

    public Books(Integer id) {
        this.id = id;
    }

    public Books(Integer id, BooksDescription booksDescription, String name, String publisher) {
        this.id = id;
        this.booksDescription = booksDescription;
        this.name = name;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BooksDescription getBooksDescription() {
        return booksDescription;
    }

    public void setBooksDescription(BooksDescription booksDescription) {
        this.booksDescription = booksDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String toString() {
        return "Book = " + id + ", " + booksDescription + ", name = " + name + ", publisher = " + publisher;
    }

}
