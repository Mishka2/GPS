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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_info);

        Button enter = (Button) findViewById(R.id.enter_info);
    }

    public void enterInfo(View v){
        EditText goToAddress= (EditText) findViewById(R.id.address_person);
        EditText numberContact = (EditText) findViewById(R.id.phone_number);

        String personAddress = goToAddress.getText().toString();
        String contactNumber = numberContact.getText().toString();

        EveryAdventure first = new EveryAdventure(contactNumber, personAddress);
    }


}
