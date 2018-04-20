package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class NameThatTone extends AppCompatActivity {
    private final int NUMBEROFNOTES = 12;
    private String TAG = "dean";
    private boolean[] notesBoolean;
    private CheckBox[] allTheNotes;
    private GridLayout gridLayout;
    private void p(String a){
        Log.v(TAG, a);
    }
    //ArrayList<CheckBox> theNotes;


    private void unnecessaryNotesDisappear(){
        for(int i = 0; i<NUMBEROFNOTES; i++){
            if(!notesBoolean[i] ){//if false
                gridLayout.removeView(allTheNotes[i]);
            }
        }
    }
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent lastIntent = getIntent();
        //String yes = lastIntent.getStringExtra("yes");
        //p(yes);
        notesBoolean = lastIntent.getBooleanArrayExtra("notesBoolean");
        for(int i = 0; i<notesBoolean.length; i++){
            p(""+notesBoolean[i]);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone);
        gridLayout = (GridLayout) findViewById(R.id.NTTGridLayout);
        allTheNotes = new CheckBox[NUMBEROFNOTES];

        initializeNotes();

        unnecessaryNotesDisappear();
        /*CheckBox checkA = (CheckBox) findViewById(R.id.aAnswer);
        gridLayout.removeView(checkA);
        */


        /*
        GridLayout gridLayout = new GridLayout(this);
        CheckBox checkBox = new CheckBox(this);
        checkBox.setGravity(Gravity.CENTER);

        gridLayout.addView(checkBox);*/

    }
}
