package com.example.mishka.gps;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.IDNA;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Mishka on 4/6/17.
 */

public class Information extends AppCompatActivity{

    DatabaseHelper data;
    AllTrips likeAllTrips = new AllTrips();
    int trip = 0;
    View view;
    String estimatedTime = "12:00";
    String currentAdd;
    String personAddress;
    Double lat;
    Double longitude;
    Context context;

    String phoneNo;

    String finalETAHours = "0";
    String finalETAMins = "0";

    String latString;
    String longString;

    TimeManipulation manipulate;

    final Handler handler = new Handler();
    View v;
    String finalEstimatedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_info);

//        data = new DatabaseHelper(this);
        Button enter = (Button) findViewById(R.id.enter_info_button);

        Intent intent = getIntent();
        latString = intent.getStringExtra("latString");
        longString = intent.getStringExtra("longString");

        Toast.makeText(getBaseContext(), "latitude: " + latString, Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(), "longitude: " + longString, Toast.LENGTH_SHORT).show();
    }


    public void enterInfo(View v)  throws Exception{
        EditText goToAddress = (EditText) findViewById(R.id.address_person);
        EditText numberContact = (EditText) findViewById(R.id.phone_number);
        EditText wantedArrival = (EditText) findViewById(R.id.wantedEta);

        personAddress = goToAddress.getText().toString();
        String contactNumber = numberContact.getText().toString();
        String wantedETA = wantedArrival.getText().toString();

        phoneNo = contactNumber;

//        String coordinates = lat + "," + longitude;


        String API_KEY = "AIzaSyCaqZYl9tswKSk6espZPWkMtKjNrEeZXd4";
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        try {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getBaseContext(), "permission", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
            }
            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
            DistanceMatrix distanceMatrix = req.origins(latString + "," + longString)
//            latString + "," + longString
//            currentAdd
//            "497 Howard St, Northborough MA"
                    .destinations(personAddress).await();
            //personAddress
//            "85 Prescott St, Worcester MA"
//            personAdd
//            Toast.makeText(getBaseContext(), distanceMatrix.rows[0].elements[0].duration.
//                    humanReadable, Toast.LENGTH_SHORT).show();

            finalEstimatedTime =  ((Long) distanceMatrix.rows[0].elements[0].duration.inSeconds).toString();

        } catch (Exception e) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            AlertDialog dialog = alertDialogBuilder.create();
            dialog.setMessage(e.getMessage());
            dialog.show();
        }

        likeAllTrips.addTrip(contactNumber, personAddress, currentAdd, wantedETA);
        String etaTry = ((Integer)likeAllTrips.getTrips().get(trip).getETAMin()).toString();
//        Toast.makeText(getBaseContext(), "ETA: " + finalEstimatedTime, Toast.LENGTH_SHORT).show();

        ((Integer) Math.abs(likeAllTrips.getTrips().get(trip).getETAMin())).toString();
//
        trip++;

        int minsETA = Integer.parseInt(finalEstimatedTime);


        if ((minsETA/60)/60 >= 1){
            finalETAHours = ((Integer) ((minsETA/60)/60)).toString();
            finalETAMins = ((Integer) ((minsETA/60) - (Integer.parseInt(finalETAHours) * 60))).toString();
            manipulate = new TimeManipulation(wantedETA, Integer.parseInt(finalETAHours),
                    Integer.parseInt(finalETAMins));
            setTexts(finalETAHours + " hours and " + finalETAMins + " minutes");
        }
        else if ((minsETA/60)/60 < 1) {
            finalETAMins = ((Integer)(minsETA/60)).toString();
            manipulate = new TimeManipulation(wantedETA, Integer.parseInt(finalETAHours),
                    Integer.parseInt(finalETAMins));
            setTexts( finalETAMins + " minutes");
        }

//        manipulate = new TimeManipulation(wantedETA, Integer.parseInt(finalETAHours),
//                Integer.parseInt(finalETAMins));

    }


    public void setTexts(String eta){

        final TextView hEarly = (TextView) findViewById(R.id.hoursEarly);
        final TextView hLate = (TextView) findViewById(R.id.hoursLate);
//        final TextView mEarly = (TextView) findViewById(R.id.minEarly);
//        final TextView mLate = (TextView) findViewById(R.id.minLate);

        hEarly.setText(eta);
//        hLate.setText();

//        Toast.makeText(getBaseContext(), "Total current: " + ((Integer) manipulate.getTotalCurrent()).toString() + " mins",
//                Toast.LENGTH_SHORT).show();
//        //114
//
//        Toast.makeText(getBaseContext(), "Total real: " + ((Integer) manipulate.getEstimatedTotalReal()).toString() + " mins",
//                Toast.LENGTH_SHORT).show();
//        //21
//
//        Toast.makeText(getBaseContext(), "Total want: " + ((Integer) manipulate.getTotalETA()).toString() + " mins",
//                Toast.LENGTH_SHORT).show();
//        //83
//
//        Toast.makeText(getBaseContext(), "Total late: " + ((Integer) manipulate.getTotalLate()).toString() + " mins",
//                Toast.LENGTH_SHORT).show();


        if(manipulate.getTotalLate()>=0) {
            if (manipulate.getTotalLate()/ 60 >= 1) {
                String lateHours = ((Integer) ((manipulate.getTotalLate() / 60) / 60)).toString();
                String lateMins = ((Integer) ((manipulate.getTotalLate() / 60) - (Integer.parseInt(finalETAHours) * 60))).toString();
                hLate.setText(lateHours + " hours and " + lateMins + " mins");
            } else if (manipulate.getTotalLate()/ 60 < 1) {
                String lateMins = ((Integer) (manipulate.getTotalLate())).toString();
                hLate.setText(lateMins + " mins");
            }
        } else if (manipulate.getTotalLate() < 0){
            if ((Math.abs(manipulate.getTotalLate()) / 60) >= 1) {
                String lateHours = ((Integer) (((Math.abs(manipulate.getTotalLate())) / 60))).toString();
                String lateMins = ((Integer) ((Math.abs(manipulate.getTotalLate())) -
                        (Integer.parseInt(lateHours) * 60))).toString();
                hLate.setText(lateHours + " hours and " + lateMins + " mins late");
            } else if (((Math.abs(manipulate.getTotalLate())) / 60) < 1) {
                String lateMins = ((Integer) ((Math.abs(manipulate.getTotalLate())))).toString();
                hLate.setText(lateMins + " mins late");
            }

            if(Math.abs(manipulate.getTotalLate()) > 15){
                popConfirmation(v);
            }
        }

//        getTime();
//
    }


    public void popConfirmation(View v) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.confirmation, null);


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirm Sending Text");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendText();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void sendText() {
        Toast.makeText(getBaseContext(), "start", Toast.LENGTH_SHORT).show();
//            String phoneNo = "9785493294";
//            String phoneNo = "7749949341"; //numaan
//            String phoneNo = "5083040353";
        String message = "Hey! Im about 15 minutes out, sorry I'm late!    - the app Sero";
        try {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, 1);
            }
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, message, null, null);
                Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            AlertDialog dialog = alertDialogBuilder.create();
            dialog.setMessage(e.getMessage());
            dialog.show();
            Toast.makeText(getBaseContext(), "failed", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getBaseContext(), "done", Toast.LENGTH_SHORT).show();
    }

}
