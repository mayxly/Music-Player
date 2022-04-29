package com.player;

public class Song {
    String title;
    String artist;
    double duration;

    public Song(String title, String artist,  double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public double getDuration() {
        return duration;
    }
    @Override
    public String toString() {
        return "Song { Title: " + title + "\"" +
                        "Artist: " + artist + "\"" +
                        "Duration: " + duration + " }";

    }
}
