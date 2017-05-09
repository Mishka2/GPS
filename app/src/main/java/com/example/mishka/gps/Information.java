package com.example.mishka.gps;

import android.*;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.IDNA;
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

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;

import java.util.Calendar;
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
    }

    public void enterInfo(View v)  throws Exception{
        EditText goToAddress = (EditText) findViewById(R.id.address_person);
        EditText numberContact = (EditText) findViewById(R.id.phone_number);
        EditText currentAddress = (EditText) findViewById(R.id.currAddress);
        EditText wantedArrival = (EditText) findViewById(R.id.wantedEta);

        personAddress = goToAddress.getText().toString();
        String contactNumber = numberContact.getText().toString();
        currentAdd = currentAddress.getText().toString();
        String wantedETA = wantedArrival.getText().toString();

        String API_KEY = "AIzaSyCaqZYl9tswKSk6espZPWkMtKjNrEeZXd4";
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        try {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getBaseContext(), "permission", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
            }
            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
            DistanceMatrix distanceMatrix = req.origins("497 Howard St, Northborough MA")
//            currentAdd
                    .destinations("85 Prescott St, Worcester MA").await();
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
        Toast.makeText(getBaseContext(), "ETA: " + finalEstimatedTime, Toast.LENGTH_SHORT).show();

//        ((Integer) Math.abs(likeAllTrips.getTrips().get(trip).getETAMin())).toString()
//
        Toast.makeText(getBaseContext(), "ETA MIN: " + etaTry, Toast.LENGTH_SHORT).show();
//        trip++;

        manipulate = new TimeManipulation(wantedETA, finalEstimatedTime);
        setTexts(finalEstimatedTime);
    }


    public void setTexts(String eta){

        final TextView hEarly = (TextView) findViewById(R.id.hoursEarly);
//        final TextView hLate = (TextView) findViewById(R.id.hoursLate);
//        final TextView mEarly = (TextView) findViewById(R.id.minEarly);
//        final TextView mLate = (TextView) findViewById(R.id.minLate);

        hEarly.setText(eta);


//            String hoursLate = ((Integer) Math.abs(manipulate.getHoursLate())).toString();
//            String minLate = ((Integer) Math.abs(manipulate.getMinLate())).toString();

        Toast.makeText(getBaseContext(), "all:" + ((Integer) manipulate.getEstimatedTotal()).toString(),
                  Toast.LENGTH_SHORT).show();


//        if(manipulate.getTotalLate() > 0) {
//            hEarly.setText(hoursLate);
//            mEarly.setText(minLate);
//        } else if (manipulate.getTotalLate() < 0){
//            hLate.setText(hoursLate);
//            mLate.setText(minLate);
//        }
//            hLate.setText("hello");


//        getTime();
//
    }

    public void getTime() {

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
                getETA();
//                handler.postDelayed(this, 10000);
//            }
//        }, 20000);  //the time is in miliseconds
    }

    public void getETA() {
        Toast.makeText(getBaseContext(), "start" + ((Integer) manipulate.getHours()).toString(), Toast.LENGTH_SHORT).show();

//        if(manipulate.getTotalLate() < 0)
//            popConfirmation(view);
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
            String phoneNo = "7749949341"; //numaan
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
