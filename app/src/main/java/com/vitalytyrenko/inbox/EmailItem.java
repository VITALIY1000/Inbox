package com.vitalytyrenko.inbox;

public class EmailItem {
    private String title;
    private String content;
    private String date;
    private String imageURL;

    EmailItem(String title, String content, String date, String imageURL) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getImageURL() {
        return imageURL;
    }
}
