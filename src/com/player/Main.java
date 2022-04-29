package com.player;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main (String [] args) {

        Album album1 = new Album("Justice", "Justin Bieber");

        album1.addSong("Holy", 3.5);
        album1.addSong("Peaches", 4.2);
        album1.addSong("Hold On", 4.1);
        album1.addSong("Anyone", 3.8);

        Album album2 = new Album("Immunity", "Clairo");

        album2.addSong("Softly", 4.1);
        album2.addSong("Bags", 4.5);
        album2.addSong("Sofia", 3.9);

        albums.add(album1);
        albums.add(album2);

        LinkedList<Song> playlist1 = new LinkedList<>();
        albums.get(0).addToPlaylist("Holy", playlist1);
        albums.get(0).addToPlaylist("Anyone", playlist1);
        albums.get(1).addToPlaylist("Bags", playlist1);

    }

}
