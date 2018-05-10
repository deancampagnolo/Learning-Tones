package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    Button nameThatToneButton;
    String TAG = "dean";
    AdView myAdView;

    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameThatToneButton = (Button)findViewById(R.id.nameThatToneButton);

        //for ads
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");//FIXME CHANGE THIS LATER TO MY ADMOB APP ID
        myAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myAdView.loadAd(adRequest);


        nameThatToneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, NameThatToneSelectorScreen.class));
            }
        });
    }
}
