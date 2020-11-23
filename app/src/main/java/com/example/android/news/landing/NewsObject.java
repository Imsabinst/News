package com.example.android.news.landing;

public class NewsObject {
    private String title;
    private int image;
    private String author;
    private String date;
    private String source;
    private String content;

    public NewsObject() {
    }

    public NewsObject(String title, int image, String author, String date, String source) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.date = date;
        this.source = source;
    }

    public NewsObject(String title, int image, String author, String date, String source, String content) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.date = date;
        this.source = source;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
