package com.example.mishka.gps;

import java.util.Calendar;

/**
 * Created by Mishka on 5/7/17.
 */

public class TimeManipulation {

    //data
    int etaHour = 0;
    int etaMin = 0;

    String finalEta;



    //constructors

    public TimeManipulation(String wantedETA, String eta){

        int subOneHour = Integer.parseInt(wantedETA.substring(0, 2));
//        String hourTwo = new String(wantedETA.replaceAll("0",""));
//        int hour = Integer.parseInt(hourTwo);

        int subOneMin = Integer.parseInt(wantedETA.substring(3, 5));
//        String minTwo = new String(wantedETA.replaceAll("0",""));
//        int min = Integer.parseInt(minTwo);

        etaHour = subOneHour;
        etaMin = subOneMin;

        finalEta = eta;

    }

    //methods
    public int getHours(){
        return etaHour;
    }

    // 17 mins
    // 2 hours 2 mins
    // 12 hours 20 mins

    public int getEstimatedTotal(){
        int hoursETAFinal;
        int minsETAFinal;

        if(finalEta.length() > 8){
            hoursETAFinal = Integer.parseInt(finalEta.substring(0, 2));
//            minsETAFinal = Integer.parseInt(finalEta.substring(8, 10));
        } else {
            hoursETAFinal = 0;
        }

//        int hoursETAFinal = Integer.parseInt(finalEta.substring(0, i));

//        String newTime = finalEta.substring(i+1);
////
//        while(newTime.charAt(m) != 'm' && (m < newTime.length())){
//            m++;
//        }
//        int minsETAFinal = Integer.parseInt(newTime.substring(0, m));

        return hoursETAFinal;
    }

    public int getMin(){
        return etaMin;
    }

    public int getTotalETA(){

        int totalETA = (etaHour * 60) + etaMin;
        return totalETA;
    }

    public int getTotalCurrent(){

        Calendar rightNow = Calendar.getInstance();
        int hourCurrent = rightNow.get(Calendar.HOUR); // 1 pm
        int minCurrent = rightNow.get(Calendar.MINUTE); // 1 pm

        int totalCurrent = (hourCurrent * 60) + minCurrent;

        return totalCurrent;
    }

    public int getTotalCurrentETA(){
        return getTotalCurrent() + getEstimatedTotal();
    }

    public int getHoursLate(){

        int totalLate = Math.abs(getTotalETA() - getTotalCurrent());
        int totalHoursLate = Math.abs(totalLate / 60);

        return totalHoursLate;
    }

    public int getMinLate(){

        int totalLate = Math.abs(getTotalETA() - getTotalCurrent());
        int totalHoursLate = totalLate / 60;
        int totalMinutesLate = totalLate - (totalHoursLate * 60);

        return totalMinutesLate;
    }


    public int getTotalLate(){
        int totalLate = getTotalETA() - getTotalCurrent(); //if positive, then late
        return totalLate;
    }



}
