package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name ;
    private String artist ;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<Song>(); // here we initialize the ArrayList in the constructor
    }

    public boolean addSong (String title , double duration){
        if (findSong(title) == null){  // we check if the song is already int the ArrayList
            this.songs.add(new Song(title,duration)); // if it is not in then we add the new song in the ArrayList
            return true;
        }
        return false;
    }

    private Song findSong(String title ){
        for(Song checkedSong: this.songs) { // here we create a variable checkedSong for every entry in the ArrayList
            if (checkedSong.getTitle().equals(title)) {    // and then we compare it with the new entry
                return checkedSong;      // and if we find it in the ArrayList then we return that
            }
        }
        return null;  // we return null when we did not find it in the list
    }

    public boolean addToPlayList (int trackNumber , LinkedList<Song> playList) {
        int index = trackNumber - 1 ; // we do -1 because the first element of the index is 0
        if((index>=0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true ;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList (String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album ");
        return true ;
    }

}
