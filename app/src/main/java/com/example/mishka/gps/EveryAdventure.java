package com.example.mishka.gps;

/**
 * Created by Mishka on 4/7/17.
 */

public class EveryAdventure {
    //data
    String numContact = null;
    String addressContact = null;
    String currentAddress = null;
    String estimatedTime;
    String hour;
    String min;
    int ID;
    int counter = 0;

    //constructor
    public EveryAdventure(String number, String addContact, String currAddress, String eta) {
        numContact = number;
        addressContact = addContact;
        currentAddress = currAddress;
        estimatedTime = eta;
        this.ID = counter;
        counter++;
    }


    public EveryAdventure() {
        numContact = "0";
        addressContact = "bloopAway";
        currentAddress = "bloop";
    }

    //methods
    public int getID() {
        return ID;
    }

    public String getNumContact() {
        return numContact;
    }

    public void setNumContact(String number) {
        numContact = number;
    }

    public String getAddressContact() {
        return addressContact;
    }

    public void setAddressContact(String address) {
        addressContact = address;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currAdd) {
        currentAddress = currAdd;
    }

    public String getETA() {
        return estimatedTime;
    }

    public void setETA(String eta) {
        estimatedTime = eta;
    }

    public int getETAHour() {
        String subHour = new String(estimatedTime);
        int hour = Integer.parseInt(subHour.substring(0, 1));
        return hour;
    }

    public int getETAMin(){
        String subMin = new String(estimatedTime);
        int min = Integer.parseInt(subMin.substring(2, 3));
        return min;
    }


}
