package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    String TAG = "dean";//for debugging
    AdView myAdView;

    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for ads
        //MobileAds.initialize(this, "ca-app-pub-8739894858175787~8702293436"); //will add later
        myAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAdView.loadAd(adRequest);


        /*nameThatToneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, NameThatToneSelectorScreen.class));
            }
        });*/ //kept this because I can reference this later
    }

    public void onButtonClicked(View v){
        switch(v.getId()){
            case R.id.nameThatToneButton:
                startActivity(new Intent(MainActivity.this, NameThatToneSelectorScreen.class));
                break;

            case R.id.humThatToneButton:
                break;
        }
    }
}
