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
import java.util.ArrayList;


public class NameThatTone extends AppCompatActivity {
    private int usableNotesStart = 1;
    private int usableNotesFinish = 7;
    private final int NUMBEROFNOTES = 12;
    private String TAG = "dean";
    private boolean[] notesBoolean;
    private CheckBox[] allTheNotes;
    private GridLayout gridLayout;
    private ArrayList<Integer> usableNotes;
    private ArrayList<Integer> soundPoolUsableNotes;
    private int currentNote;
    private int numberOfNotesBeingUsed;
    private SoundPool sp;

    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }

    private void createUsableNotes(){
        usableNotes = new ArrayList<>();
        for(int i = 0; i<notesBoolean.length; i++){
            if(notesBoolean[i]){//if it is true

                switch(i){
                    case 0://case a
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"a");
                        break;
                    case 1://case bb
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"bb");
                        break;
                    case 2://case b
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"b");
                        break;
                    case 3://case c
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"c");
                        break;
                    case 4://case db
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"db");
                        break;
                    case 5://case d
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"d");
                        break;
                    case 6://case eb
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"eb");
                        break;
                    case 7://case e
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"e");
                        break;
                    case 8://case f
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"f");
                        break;
                    case 9://case gb
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"gb");
                        break;
                    case 10://case g
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"g");
                        break;
                    case 11://case ab
                        addingIntoUsableNotes(usableNotesStart,usableNotesFinish,"ab");
                        break;
                }//end of switch
            }//end of if
        }//end of for
    }

    private void addingIntoUsableNotes(int start, int finish, String note){
        for(int i = start; i<=finish;i++){
            usableNotes.add(getApplicationContext().getResources().getIdentifier(note + i,"raw",getPackageName()));
        }
    }

    private void loadRealNotes(SoundPool sp){
        soundPoolUsableNotes = new ArrayList<>();
        for(int i = 0;i<usableNotes.size();i++){
            soundPoolUsableNotes.add(sp.load(this,usableNotes.get(i),1));
        }
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
        //R.id.
        initializeNotes();
        unnecessaryNotesDisappear();
        //int id = getApplicationContext().getResources().getIdentifier("a0","raw",getPackageName());
        //p("FIRST"+id);
        //p("SECOND"+R.raw.a0);
        createUsableNotes();
        sp = new SoundPool.Builder().setMaxStreams(1).build();//samples default to 1 which I want.
        loadRealNotes(sp);


        numberOfNotesBeingUsed = soundPoolUsableNotes.size();
        getRandomNote();
        currentNote = getRandomNote();




        //traverse(R.raw);
        //sp.play(k,1,1,1,1,.5f);
        p("after play");
    }

    public int getRandomNote(){
        return (int)(Math.random()*numberOfNotesBeingUsed);
    }


    /*public void traverse (File dir) {
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
    }*/

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
                sp.play(soundPoolUsableNotes.get(currentNote),1,1,0,0,.5f);
                break;

            case R.id.submitButton:
                p("submitButton pressed");
                currentNote = getRandomNote();
                sp.play(soundPoolUsableNotes.get(currentNote),1,1,0,0,.5f);
                break;

        }

    }




}
