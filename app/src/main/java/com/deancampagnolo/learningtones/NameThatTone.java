package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;

import java.util.ArrayList;

public class NameThatTone extends AppCompatActivity {
    private final int NUMBEROFNOTES = 12;
    private String TAG = "dean";
    private void p(String a){
        Log.v(TAG, a);
    }
    //ArrayList<CheckBox> theNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent lastIntent = getIntent();
        //String yes = lastIntent.getStringExtra("yes");
        //p(yes);
        boolean[] notesBoolean = lastIntent.getBooleanArrayExtra("notesBoolean");
        for(int i = 0; i<notesBoolean.length; i++){
            p(""+notesBoolean[i]);
        }
        p("h");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone);


    }
}
