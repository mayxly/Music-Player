package com.player;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;

    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    //Find song in album
    public Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return songs.get(i);
            }
        }
        return null;
    }

    //Add song in album
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            System.out.println(title + " was successfully added to the album.");
            return true;
        }
            System.out.println(title + " already exists in the album.");
            return false;
    }

    //Adding to a playlist with album track number
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> Playlist) {
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()) {
            Playlist.add(this.songs.get(index));
            System.out.println("The song with track number " + trackNumber +
                    " was successfully added to the playlist.");
            return true;
        }
        System.out.println("The song with track number " + trackNumber + " does not exist.");
        return false;
    }

    //Adding to a playlist with album song title
    public Song addToPlaylist(String title, LinkedList<Song> Playlist) {
        for (int i = 0; i < this.songs.size(); i++) {
            if (this.songs.get(i).getTitle().equals(title)) {
                Playlist.add(this.songs.get(i));
                System.out.println(title + " was successfully added to the playlist.");
                return this.songs.get(i);
            }
        }
        System.out.println(title + " does not exist in the album.");
        return null;
    }




}





