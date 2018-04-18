package com.deancampagnolo.learningtones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import java.util.ArrayList;

public class NameThatTone extends AppCompatActivity {
    ArrayList<CheckBox> theNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone);


    }
}
