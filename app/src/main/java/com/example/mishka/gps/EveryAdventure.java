package com.example.mishka.gps;

/**
 * Created by Mishka on 4/7/17.
 */

public class EveryAdventure {
    //data
    String numContact = null;
    String addressContact = null;
    //////////////////////////////////////////////////////////////////////////
    String currentAddress = null;

    //constructor
    public EveryAdventure(String number, String addContact){
        numContact = number;
        addressContact = addContact;
    }

    //methods
    public String getNumContact(){
       return numContact;
    }

    public String getAddressContact(){
        return addressContact;
    }

    public String getCurrentAddress(){
        return currentAddress;
    }

}
