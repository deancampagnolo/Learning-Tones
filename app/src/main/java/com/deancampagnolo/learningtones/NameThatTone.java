package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.GridLayout;


public class NameThatTone extends AppCompatActivity {
    private final int NUMBEROFNOTES = 12;
    private String TAG = "dean";
    private boolean[] notesBoolean;
    private CheckBox[] allTheNotes;
    private GridLayout gridLayout;

    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone);

        //this block is to retrieve the booleanArray from the last intent
        Intent lastIntent = getIntent();
        notesBoolean = lastIntent.getBooleanArrayExtra("notesBoolean");

        gridLayout = (GridLayout) findViewById(R.id.NTTGridLayout);
        allTheNotes = new CheckBox[NUMBEROFNOTES];

        initializeNotes();

        unnecessaryNotesDisappear();
    }

    //This function initializes the CheckBoxes in nameThatTone into the allTheNotes CheckBox array
    public void initializeNotes(){
        allTheNotes[0] = (CheckBox)findViewById(R.id.aAnswer);
        allTheNotes[1] = (CheckBox)findViewById(R.id.asAnswer);
        allTheNotes[2] = (CheckBox)findViewById(R.id.bAnswer);
        allTheNotes[3] = (CheckBox)findViewById(R.id.cAnswer);
        allTheNotes[4] = (CheckBox)findViewById(R.id.csAnswer);
        allTheNotes[5] = (CheckBox)findViewById(R.id.dAnswer);
        allTheNotes[6] = (CheckBox)findViewById(R.id.dsAnswer);
        allTheNotes[7] = (CheckBox)findViewById(R.id.eAnswer);
        allTheNotes[8] = (CheckBox)findViewById(R.id.fAnswer);
        allTheNotes[9] = (CheckBox)findViewById(R.id.fsAnswer);
        allTheNotes[10] = (CheckBox)findViewById(R.id.gAnswer);
        allTheNotes[11] = (CheckBox)findViewById(R.id.gsAnswer);
    }

    //removes CheckBoxes from view if they have the value false
    private void unnecessaryNotesDisappear(){
        for(int i = 0; i<NUMBEROFNOTES; i++){
            if(!notesBoolean[i] ){//if false
                gridLayout.removeView(allTheNotes[i]);
            }
        }
    }




}
