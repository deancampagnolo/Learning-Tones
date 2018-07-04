package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);



    }

    public void onButtonClicked(View v){
        if(v.getId()==R.id.helpBackToMainMenuButton){
            finish();
            //startActivity(new Intent(this, MainActivity.class));//TODO understand what activities really mean, why can't i go back to MainActivity here?
        }
    }
}
