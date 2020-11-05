package com.neil.castellino.ivtest;

public class Music {
    private String musicTitle;
    private String artistName;
    private String thumbURL;

    public Music(String musicTitle, String artistName, String thumbURL) {
        this.musicTitle = musicTitle;
        this.artistName = artistName;
        this.thumbURL = thumbURL;
    }

    public String getTitle() {
        return musicTitle;
    }

    public String getName() {
        return artistName;
    }

    public String getThumbURL() {
        return thumbURL;
    }
}
