package com.example.mishka.gps;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Mishka on 4/6/17.
 */

public class Information extends AppCompatActivity{

    DatabaseHelper data;
    AllTrips likeAllTrips = new AllTrips();
    int trip = 0;
    Calendar rightNow = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_info);

//        data = new DatabaseHelper(this);
        Button enter = (Button) findViewById(R.id.enter_info_button);
    }

    public void enterInfo(View v) {
        EditText goToAddress = (EditText) findViewById(R.id.address_person);
        EditText numberContact = (EditText) findViewById(R.id.phone_number);
        EditText currentAddress = (EditText) findViewById(R.id.currAddress);
        EditText eta = (EditText) findViewById(R.id.wantedEta);

        String personAddress = goToAddress.getText().toString();
        String contactNumber = numberContact.getText().toString();
        String currentAdd = currentAddress.getText().toString();
        String wantedETA = eta.getText().toString();

        likeAllTrips.addTrip(contactNumber, personAddress, currentAdd, wantedETA);
        String etaTry = likeAllTrips.getTrips().get(trip).getETA();
        trip++;

//        Toast.makeText(getBaseContext(), "You will arive in " + getHoursLate() +" hours and " + getMinLate() + " minutes" , Toast.LENGTH_SHORT).show();
    }

    public int getHoursLate(){

        int hourCurrent = rightNow.get(Calendar.HOUR); // 1 pm
        int hoursETA = likeAllTrips.getTrips().get(trip).getETAHour(); // 4 pm

        int lateHour = hourCurrent - hoursETA;
        return lateHour;
    }

    public int getMinLate(){

        int minCurrent = rightNow.get(Calendar.MINUTE); // 1 pm
        int minETA = likeAllTrips.getTrips().get(trip).getETAMin(); // 4 pm

        int lateMin = minCurrent - minETA;
        return lateMin;
    }

}
