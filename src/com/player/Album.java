package com.player;

import java.util.ArrayList;

public class Album {
    private String name;

    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist, ArrayList<Song> songs) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return songs.get(i);
            }
        }
            return null;
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
            System.out.println(title + " was successfully added to the playlist.");
            return true;
        }
        else {
            System.out.println(title + " already exists in the list.");
            return false;
        }
    }



}
