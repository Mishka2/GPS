package com.example.mishka.gps;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Mishka on 4/25/17.
 */

public class AllTrips {

    //data
    int total;
    private ArrayList<EveryAdventure> trips;


    //constructor
    public AllTrips(){
        total = 0;
        trips = new ArrayList<EveryAdventure>();
    }

    //methods

    public void addParticipant(String number, String addContact, String currAddress){
        EveryAdventure i = new EveryAdventure(number, addContact, currAddress);
        trips.add(i);

    }

    public ArrayList<EveryAdventure> getTrips(){
        return trips;
    }

    public int getSize(){
        int size = trips.size();
        return size;
    }



}
