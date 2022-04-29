package com.player;

import java.util.*;

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

        printOptions();
        printSongs(playlist1);
        play(playlist1);
    }

    private static void playlist(LinkedList<Song> playlist) {
    }

    //Play the playlist
    private static void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size() == 0) {
            System.out.println("This playlist has no songs");
        } else {
            System.out.println("Now playing \"" + listIterator.next().getTitle() + "\"");
            printOptions();
        }

        while(!quit) {
            int action = sc.nextInt();

            if (action == 0) {
                System.out.println("The music has stopped playing");
                quit = true;
            }
            else if (action == 1) {
                if (!forward && listIterator.hasNext()) {
                    forward = true;
                }
                if (listIterator.hasNext()) {
                    System.out.println("Now playing \"" + listIterator.next().getTitle() + "\"");
                }
                else {
                    System.out.println("Reached the end of the playlist.");
                    forward = false;
                }
            }
            else if (action == 2) {
                if (forward && listIterator.hasPrevious()) {
                    forward = false;
                }
                if (listIterator.hasPrevious()) {
                    System.out.println("Now playing \"" + listIterator.previous().getTitle() + "\"");
                }
                else {
                    System.out.println("Reached the beginning of the playlist.");
                    forward = false;
                }
            }
            else if (action == 3) {
                printSongs(playlist);
            }
            else if (action == 4) {
                printOptions();
            }
            else if (action == 5) {
                if (playlist.size() == 1) {
                    listIterator.remove();
                    System.out.println("Your playlist is empty");
                }
                else if (playlist.size() > 0) {
                    System.out.println("The song has been removed");
                    listIterator.remove();
                    if (forward && listIterator.hasNext()) {
                        listIterator.next();
                    }
                    else {
                        listIterator.previous();
                    }
                }
                else {
                    System.out.println("There is no song to remove");
                }
            }
            else if (action == 6) {
                System.out.println("What is your song name?");
                String songName = sc.next();
                sc.nextLine();
                System.out.println("What is the song duration?");
                double songTime = sc.nextDouble();
                Song newSong = new Song(songName, songTime);
                System.out.println(songName + " has been added to the playlist");
                listIterator.add(newSong);
                printOptions();
                }
            }
        }
    private static void printOptions() {
        System.out.println("Choose an option: ");
        System.out.println(
                "0 - Quit\n" +
                "1 - Play next song\n" +
                "2 - Play previous song\n" +
                "3 - Show all songs\n" +
                "4 - Show all options\n" +
                "5 - Delete current song\n" +
                "6 - Add new song\n");
    }

    private static void printSongs(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("---------------Songs---------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------------------");
    }
}
