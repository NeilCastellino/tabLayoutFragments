package com.neil.castellino.ivtest;

public class Game {
    private String gameTitle;
    private String publisherName;
    private String thumbURL;

    public Game(String gameTitle, String publisherName, String thumbURL) {
        this.gameTitle = gameTitle;
        this.publisherName = publisherName;
        this.thumbURL = thumbURL;
    }

    public String getTitle() {
        return gameTitle;
    }

    public String getName() {
        return publisherName;
    }

    public String getThumbURL() {
        return thumbURL;
    }
}
