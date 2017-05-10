package com.example.mishka.gps;

/**
 * Created by Mishka on 5/9/17.
 */

public class LatAndLong {

    double lat;
    double longitude;

    public LatAndLong(double LAT, double LONG){
        lat = LAT;
        longitude = LONG;
    }

    public String getLatStringCoor(){
        String coor = ((Double)lat).toString();
        return coor;
    }

    public String getLongStringCoor(){
        String coor = ((Double)longitude).toString();
        return coor;
    }
}
