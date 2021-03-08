package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums =  new ArrayList<Album>(); // here we create a list of all the albums


    public static void main(String[] args) {

        Album album = new Album("Spoken for","Mercy me");
        album.addSong("The Change inside of me" , 3.24);
        album.addSong("All The Above" , 3.23);
        album.addSong("Spoken for" , 4.09);
        album.addSong("Word of God Speak" , 3.07);
        album.addSong("Love of God Speak" , 3.07);
        album.addSong("Go",3.27);
        album.addSong("All Because Of This" , 1.37);
        albums.add(album);
        album = new Album("Almost there" , "Mercy me");
        album.addSong("Here i am " , 4.20);
        album.addSong("House of God" , 3.13);
        album.addSong("Call to Worship" , 4.51);
        album.addSong("All Fall Down",3.44);
        album.addSong("In You",4.17);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Spoken for" , playList);
        albums.get(0).addToPlayList("All The Above" , playList);
        albums.get(0).addToPlayList("Go",playList);
        albums.get(0).addToPlayList(6,playList);
        albums.get(1).addToPlayList(1,playList);
        albums.get(1).addToPlayList(3,playList);
        play(playList);




    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true ;


        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0 ) { // we check if there are any songs in the list
            System.out.println("No songs in the list !");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString()); // we print the song that is being played
        printMenu();
        }

        while (!quit){  // here we crate the menu for playing the playlist
            int action = scanner.nextInt(); // we take input from the keybord ant save it to action variable
            scanner.nextLine();

            switch (action) {
                case 0 :
                    System.out.println("Playlist complete .");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (listIterator.hasNext()){ // here we check if the playlist has a next song
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the list");
                        forward=false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) { // here we check if we have a previous element in the list
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the start of the play list .");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                        forward = false;
                        }else{
                            System.out.println("We are at the stat of the list");
                        }
                    }else { // in the case that we do not have
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                        forward = true ;
                        }else{
                            System.out.println("We have reached the end of the list !");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        }else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("o - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist ");
    }

    private static void printList(LinkedList<Song> playList ) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===================");
        while(iterator.hasNext()){ // we check if we have another element in the list and if we have we print it
            System.out.println(iterator.next());
        }
        System.out.println("===================");
    }


}
