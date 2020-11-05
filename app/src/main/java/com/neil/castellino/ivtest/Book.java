package com.neil.castellino.ivtest;

public class Book {
    private String bookTitle;
    private String authorFName1;
    private String authorLName1;
    private String thumbURL;

    public Book(String bookTitle, String authorFName1, String authorLName1, String thumbURL) {
        this.bookTitle = bookTitle;
        this.authorFName1 = authorFName1;
        this.authorLName1 = authorLName1;
        this.thumbURL = thumbURL;
    }

    public String getTitle() {
        return bookTitle;
    }

    public String getName() {
        return authorFName1 + " " + authorLName1;
    }

    public String getThumbURL() {
        return thumbURL;
    }
}
