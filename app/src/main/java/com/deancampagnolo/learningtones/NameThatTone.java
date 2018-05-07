package com.deancampagnolo.learningtones;


import android.content.Intent;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class NameThatTone extends AppCompatActivity {
    private final int NUMBEROFNOTES = 12;
    private String TAG = "dean";
    private boolean[] notesBoolean;
    private CheckBox[] allTheNotes;
    private GridLayout gridLayout;
    private int[] usableNotes;

    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }

    /*private void createUsableNotes(){
        for(int i = 0; i<notesBoolean.length; i++){
            if(notesBoolean[i]){//if it is true
                switch(i){
                    case 0:

                }




            }
        }

    }

    private void addingIntoUsableNotes(int start, int finish, char note){

        int id = getApplicationContext().getResources().getIdentifier("A0.wav","raw",getPackageName());
        p(""+id);
        p(""+R.raw.a0);
        for(int i = start; i<=finish;i++){
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone);

        //this block is to retrieve the booleanArray from the last intent
        Intent lastIntent = getIntent();
        notesBoolean = lastIntent.getBooleanArrayExtra("notesBoolean");


        gridLayout = (GridLayout) findViewById(R.id.NTTGridLayout);
        allTheNotes = new CheckBox[NUMBEROFNOTES];
        //R.id.
        initializeNotes();
        unnecessaryNotesDisappear();
        //int id = getApplicationContext().getResources().getIdentifier("A0.wav","raw",getPackageName());
        //p("FIRST"+id);
        //p("SECOND"+R.raw.a0);

        //createUsableNotes();

        SoundPool sp = new SoundPool.Builder().setMaxStreams(5).build();//samples default to 1 which I want.
        //int k = sp.load(this,R.raw.a0,1);


        //traverse(R.raw);
        //sp.play(k,1,1,1,1,.5f);
        p("after play");
    }


    public void traverse (File dir) {
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; ++i) {
                File file = files[i];
                if (file.isDirectory()) {
                    traverse(file);
                } else {
                    // do something here with the file
                }
            }
        }
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

    public void onButtonClicked(View v){
        switch(v.getId()){
            case R.id.hearAgainButton:
                p("hearAgainButton pressed");
                break;

            case R.id.submitButton:
                p("submitButton pressed");
                break;

        }

    }




}
