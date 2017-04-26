package com.example.mishka.gps;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Mishka on 4/6/17.
 */

public class Information extends AppCompatActivity{

    DatabaseHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_info);

//        data = new DatabaseHelper(this);
        Button enter = (Button) findViewById(R.id.enter_info_button);
    }

    public void enterInfo(View v){
//        EditText goToAddress= (EditText) findViewById(R.id.address_person);
//        EditText numberContact = (EditText) findViewById(R.id.phone_number);
//        EditText currentAddress = (EditText) findViewById(R.id.currAddress);
//
//        String personAddress = goToAddress.getText().toString();
//        String contactNumber = numberContact.getText().toString();
//        String currentAdd = currentAddress.getText().toString();

//        EveryAdventure adventure = new EveryAdventure(contactNumber, personAddress, currentAdd);
//        data.addItem(adventure);

    }


}
