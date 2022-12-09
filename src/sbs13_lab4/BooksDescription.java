package sbs13_lab4;

public class BooksDescription {

    private Integer id;
    private String pages;
    private String genres;

    public BooksDescription() {
    }

    public BooksDescription(String pages, String genres) {
        this.pages = pages;
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Description{" + "id = " + id + ", pages = " + pages + ", genres = " + genres + '}';
    }
}
