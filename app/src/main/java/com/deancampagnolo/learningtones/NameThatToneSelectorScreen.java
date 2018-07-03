package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;




public class NameThatToneSelectorScreen extends AppCompatActivity {

    String TAG = "dean";//for debugging

    boolean atLeastOneIsChecked;//boolean value for whether at least one of the checkboxes is checked
    private CheckBox[] allTheNotes;//array that contains all of the checkboxes for each of the 12 respective notes


    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone_selector_screen);

        allTheNotes = new CheckBox[12];
        initializeNotes();//populates the allTheNotes array with each of the checkbox notes

    }

    //This function initializes the CheckBoxes in selector screen into the allTheNotes CheckBox array
    public void initializeNotes(){
        allTheNotes[0] = (CheckBox)findViewById(R.id.aCheck);
        allTheNotes[1] = (CheckBox)findViewById(R.id.asCheck);
        allTheNotes[2] = (CheckBox)findViewById(R.id.bCheck);
        allTheNotes[3] = (CheckBox)findViewById(R.id.cCheck);
        allTheNotes[4] = (CheckBox)findViewById(R.id.csCheck);
        allTheNotes[5] = (CheckBox)findViewById(R.id.dCheck);
        allTheNotes[6] = (CheckBox)findViewById(R.id.dsCheck);
        allTheNotes[7] = (CheckBox)findViewById(R.id.eCheck);
        allTheNotes[8] = (CheckBox)findViewById(R.id.fCheck);
        allTheNotes[9] = (CheckBox)findViewById(R.id.fsCheck);
        allTheNotes[10] = (CheckBox)findViewById(R.id.gCheck);
        allTheNotes[11] = (CheckBox)findViewById(R.id.gsCheck);
    }

    //sends the boolean values to the next intent through clicking the next button.
    public void onButtonClicked(View v){
        switch(v.getId()) {
            case R.id.nameThatToneNextButton:
                Intent i = new Intent(this, NameThatTone.class);
                i.putExtra("notesBoolean", getNotesBoolean());
                if (atLeastOneIsChecked) {
                    startActivity(i);
                }
        }
    }

    //This function puts all of the checked values of allTheNotes into a boolean array and returns it.
    private boolean[] getNotesBoolean(){
        atLeastOneIsChecked = false;
        boolean[] notesBoolean = new boolean[allTheNotes.length];
        for(int i = 0; i<allTheNotes.length; i++){
            if(allTheNotes[i].isChecked()){
                notesBoolean[i] = true;
                atLeastOneIsChecked = true;//not sure if there is a faster way to do this
            } else{
                notesBoolean[i] = false;
            }
        }
        return notesBoolean;
    }
}
