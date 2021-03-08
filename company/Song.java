package com.company;

public class Song {
    private String title ;
    private double duration ;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() { // we override the toString build in method so we can print the actual content of the class
        return this.title + ": " +this.duration ;
    }
}
