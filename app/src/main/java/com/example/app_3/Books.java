package com.example.app_3;

public class Books {

    int id;
    String Book_Name;
    String Book_Author;
    String img_URL;
    int pages;
    String description;
    boolean isExpanded;

    public Books(int id, String book_Name, String book_Author, String img_URL, int pages, String description) {
        this.id = id;
        Book_Name = book_Name;
        Book_Author = book_Author;
        this.img_URL = img_URL;
        this.pages = pages;
        this.description = description;
        isExpanded = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(String book_Author) {
        Book_Author = book_Author;
    }

    public String getImg_URL() {
        return img_URL;
    }

    public void setImg_URL(String img_URL) {
        this.img_URL = img_URL;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Book_Name='" + Book_Name + '\'' +
                ", Book_Author='" + Book_Author + '\'' +
                ", img_URL='" + img_URL + '\'' +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                '}';
    }
}
