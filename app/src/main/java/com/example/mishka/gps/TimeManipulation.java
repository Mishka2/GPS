package com.example.mishka.gps;

import java.util.Calendar;

/**
 * Created by Mishka on 5/7/17.
 */

public class TimeManipulation {

    //data
    int etaHour = 0;
    int etaMin = 0;

    int realETAH;
    int realETAM;



    //constructors

    public TimeManipulation(String wantedETA, int realETAHours, int realETAMins){

        int subOneHour = Integer.parseInt(wantedETA.substring(0, 2));
        int subOneMin = Integer.parseInt(wantedETA.substring(3, 5));

        etaHour = subOneHour;
        etaMin = subOneMin;

        realETAH = realETAHours;
        realETAM = realETAMins;
    }

    public int getEstimatedTotalReal(){
        int totalReal = (realETAH * 60) + realETAM;
        return totalReal;
    }

    public int getEtaHour(){
        return etaHour;
    }

    public int getEtaMin(){
        return etaMin;
    }

    public int getTotalETA(){

        int totalETA = (etaHour * 60) + etaMin;
        return totalETA;
    }

    public int getTotalCurrent(){

        Calendar rightNow = Calendar.getInstance();
        int hourCurrent = rightNow.get(Calendar.HOUR);
        if(hourCurrent > 12){
            hourCurrent = hourCurrent-12;// 1 pm
        }
        int minCurrent = rightNow.get(Calendar.MINUTE); // 1 pm

        int totalCurrent = (hourCurrent * 60) + minCurrent;

        return totalCurrent;
    }

    public int getTotalLate(){
        int mins = getTotalETA() - (getTotalCurrent() + getEstimatedTotalReal());
        return mins;
    }



}
