package com.example.mishka.gps;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.gson.FieldNamingPolicy;

//import com.google.maps.DirectionsApi;
//import com.google.maps.DistanceMatrixApi;
//import com.google.maps.DistanceMatrixApiRequest;
//import com.google.maps.GeoApiContext;
//import com.google.maps.errors.ApiException;
//import com.google.maps.model.DistanceMatrix;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;

import static java.lang.Integer.parseInt;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.maps.DistanceMatrixApi;
//import com.google.maps.GeoApiContext;
//import com.google.maps.model.DistanceMatrix;
//import com.google.maps.model.TravelMode;

import java.util.Calendar;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    String phoneNo = "7749949341"; //numaan
//            String phoneNo = "9785493294"; //nils
//            String phoneNo = "5083040353";

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button next = (Button) findViewById(R.id.adventure);
        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.i("GPS", "Before Intent");
                Intent myIntent = new Intent(MapsActivity.this, Information.class);
                startActivity(myIntent);
//                getLocationFromAddress(v.getContext(), "85 Prescott Street, Worcester, MA") ;


            }

        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        // check if enabled and if not send user to the GSP settings
        // Better solution would be to display a dialog and suggesting to
        // go to the settings
        if (!enabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }

    public void popUpMenu(View v) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_design, null);
        final EditText number = (EditText) alertLayout.findViewById(R.id.et_timeDiff);


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Settings");
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
                Integer timeDiff = parseInt(number.getText().toString());
                Toast.makeText(getBaseContext(), "Time: " + timeDiff, Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

//    public String DistanceMatrix(View v) throws Exception {
//        String API_KEY = "AIzaSyCaqZYl9tswKSk6espZPWkMtKjNrEeZXd4";
//        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
//        Toast.makeText(getBaseContext(), "hey", Toast.LENGTH_SHORT).show();
//        try {
//            Toast.makeText(getBaseContext(), "yay", Toast.LENGTH_SHORT).show();
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(getBaseContext(), "permission", Toast.LENGTH_SHORT).show();
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
//            }
//            Toast.makeText(this, "else", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getBaseContext(), "hi", Toast.LENGTH_SHORT).show();
//            //DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(context).origins("85 Prescott St, Worcester MA").destinations("497 Howard St, Northborough MA").await();
//            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
//            DistanceMatrix distanceMatrix = req.origins("497 Howard St, Northborough MA")
//                    .destinations("85 Prescott St, Worcester MA").await();
//            Toast.makeText(getBaseContext(), distanceMatrix.rows[0].elements[0].duration.humanReadable, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, "welp", Toast.LENGTH_SHORT).show();
//            return (distanceMatrix.rows[0].elements[0].duration.humanReadable);
//        } catch (Exception e) {
//            Toast.makeText(getBaseContext(), "oops", Toast.LENGTH_SHORT).show();
//            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//            AlertDialog dialog = alertDialogBuilder.create();
//            dialog.setMessage(e.getMessage());
//            dialog.show();
//        }
//        Toast.makeText(getBaseContext(), "ohno", Toast.LENGTH_SHORT).show();
//        return null;
//    }

//    public void popConfirmation(View v) {
//        LayoutInflater inflater = getLayoutInflater();
//        View alertLayout = inflater.inflate(R.layout.confirmation, null);
//
//
//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alert.setTitle("Confirm Sending Text");
//        // this is set the view from XML inside AlertDialog
//        alert.setView(alertLayout);
//        // disallow cancel of AlertDialog on click of back button and outside touch
//        alert.setCancelable(false);
//        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alert.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                sendText();
//            }
//        });
//        AlertDialog dialog = alert.create();
//        dialog.show();
//    }

//    public void getTime() {
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                getETA();
//                handler.postDelayed(this, 10000);
//            }
//        }, 20000);  //the time is in miliseconds
//    }
//
//    public void getETA() {
//
//        if(TimeManipulation.getTotalLate() > 0)
//            popConfirmation(view);
//    }

//    String strAddress = "65 Commonwealth Ave, Worcester, MA";

//    public void sendText() {
//        Toast.makeText(getBaseContext(), "start", Toast.LENGTH_SHORT).show();
////            String phoneNo = "9785493294";
////            String phoneNo = "7749949341"; //numaan
////            String phoneNo = "5083040353";
//        String message = "Hey! Im about 15 minutes out, sorry I'm late!    - the app Sero";
//        try {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
//            }
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
//                SmsManager smsManager = SmsManager.getDefault();
//                smsManager.sendTextMessage(phoneNo, null, message, null, null);
//                Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
//            }
//        } catch (Exception e) {
//            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//            AlertDialog dialog = alertDialogBuilder.create();
//            dialog.setMessage(e.getMessage());
//            dialog.show();
//            Toast.makeText(getBaseContext(), "failed", Toast.LENGTH_SHORT).show();
//        }
//        Toast.makeText(getBaseContext(), "done", Toast.LENGTH_SHORT).show();
//    }

    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                Toast.makeText(getBaseContext(), "latitude22", Toast.LENGTH_SHORT).show();
                return null;
            }
            Address location2 = address.get(0);
//            LatLng latLng = new LatLng(location2.getLatitude(), location2.getLongitude());
            Toast.makeText(getBaseContext(), "latitude: " + location2.getLatitude(), Toast.LENGTH_SHORT).show();
//
        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return p1;
    }


//    public void DistanceMatrix(View v) throws Exception{
//               String API_KEY = "AIzaSyC5ySQ9cICmbEHRFDJfrWnfcoUPc_9o2cM";
//               GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
//
//      try {
//            DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(context).origins("85 Prescott St, Worcester MA").destinations("497 Howard St, Northborough MA").await();
////            System.out.println(distanceMatrix);
////            System.out.println(distanceMatrix.rows[0].elements[0].duration.humanReadable);
////                       return (distanceMatrix.rows[0].elements[0].duration.humanReadable);
//        }
//             catch(Exception e) {
//                       System.out.println("oops");
//                       AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//                       AlertDialog dialog = alertDialogBuilder.create();
//                       dialog.setMessage(e.getMessage());
//                       dialog.show();
//                 Toast.makeText(getBaseContext(), "oops ", Toast.LENGTH_SHORT).show();
//             }
//
//        Toast.makeText(getBaseContext(), "distance ", Toast.LENGTH_SHORT).show();
//    }



//        public void adventure(View v) {
//
//        Intent info = new Intent(v.getContext(), Information.class);
//        startActivity(info);
//
//            getLocationFromAddress(this, "65 Commonwealth Ave, Worcester, MA");

//    }

//    protected void onStart() {
//        mGoogleApiClient.connect();
//        super.onStart();
//    }
//
//    protected void onStop() {
//        mGoogleApiClient.disconnect();
//        super.onStop();
//    }

//    public void enterInfo(View v){
////        EditText goToAddress= (EditText) findViewById(R.id.address_person);
////        EditText numberContact = (EditText) findViewById(R.id.phone_number);
////        phoneNo = (numberContact).toString();
////        EditText currentAddress = (EditText) findViewById(R.id.currAddress);
////
////        String personAddress = goToAddress.getText().toString();
////        String contactNumber = numberContact.getText().toString();
////        String currentAdd = currentAddress.getText().toString();
////
////        EveryAdventure adventure = new EveryAdventure(contactNumber, personAddress, currentAdd);
////        data.addItem(adventure);
//
//    }
}

