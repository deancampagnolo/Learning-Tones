package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button nameThatToneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameThatToneButton = (Button)findViewById(R.id.nameThatToneButton);
        nameThatToneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, NameThatToneSelectorScreen.class));
            }
        });

    }


    /*public void onClick(View v){

    }*/
}