package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class HumThatToneSelectorScreen extends AppCompatActivity {

    String TAG = "dean";//for debugging

    boolean atLeastOneIsChecked;//boolean value for whether at least one of the checkboxes is checked
    private CheckBox[] allTheNotes;//array that contains all of the checkboxes for each of the 12 respective notes
    private SeekBar lowerBoundSeekBar;
    private SeekBar upperBoundSeekBar;
    private TextView lowerBoundText;
    private TextView upperBoundText;
    final int minimumBound = 1;
    final int maximumBound = 7;
    int currentLowerBound = 2;//setting this to 2 because It is "suggested"
    int currentUpperBound = 6;//setting this to 6 because It is "suggested"


    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hum_that_tone_selector_screen);

        allTheNotes = new CheckBox[12];
        initializeNotes();//populates the allTheNotes array with each of the checkbox notes
        initializeSeekBars();//initializes the seekbars
        initializeTextViews();//initializes the textViews
        updateSeekBars();


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

    public void initializeSeekBars(){
        lowerBoundSeekBar = (SeekBar)findViewById(R.id.seekBarLowerBound);
        upperBoundSeekBar = (SeekBar)findViewById(R.id.seekBarUpperBound);

        //this block is -minimumBound as there is no setMinimum
        lowerBoundSeekBar.setMax(maximumBound-minimumBound);
        upperBoundSeekBar.setMax(maximumBound-minimumBound);

        //this block is -minimumBound as there is no setMinimum
        lowerBoundSeekBar.setProgress(currentLowerBound-minimumBound);
        upperBoundSeekBar.setProgress(currentUpperBound-minimumBound);
    }

    private void initializeTextViews(){
        lowerBoundText = (TextView)findViewById(R.id.lowerBoundText);
        upperBoundText = (TextView)findViewById(R.id.upperBoundText);
        lowerBoundText.setText(String.valueOf(getString(R.string.lowerBoundPitch)+getString(R.string.space)+currentLowerBound));//value of makes it so that it doesn't concatenate in set text
        upperBoundText.setText(String.valueOf(getString(R.string.upperBoundPitch)+getString(R.string.space)+currentUpperBound));//value of makes it so that it doesn't concatenate in set text
    }

    private void updateSeekBars(){
        lowerBoundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentLowerBound = progress+minimumBound;//as the true lowest is equal to the minimum
                lowerBoundText.setText(String.valueOf(getString(R.string.lowerBoundPitch)+getString(R.string.space)+currentLowerBound));//value of makes it so that it doesn't concatenate in set text
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        upperBoundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentUpperBound = progress+minimumBound;//as the true lowest is equal to the minimum
                upperBoundText.setText(String.valueOf(getString(R.string.upperBoundPitch)+getString(R.string.space)+currentUpperBound));//value of makes it so that it doesn't concatenate in set text
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    //sends the boolean values to the next intent through clicking the next button.
    public void onButtonClicked(View v){
        switch(v.getId()) {
            case R.id.nameThatToneNextButton:
                getNotesBoolean();//this needs to be here so that it can check for if a checkbox is checked for the if statements
                if (atLeastOneIsChecked &&(currentLowerBound<=currentUpperBound)) {
                    Intent i = new Intent(this, HumThatTone.class);
                    i.putExtra("notesBoolean", getNotesBoolean());
                    i.putExtra("currentLowerBound", currentLowerBound);
                    i.putExtra("currentUpperBound", currentUpperBound);
                    startActivity(i);
                }
                if(!atLeastOneIsChecked){
                    Toast.makeText(this, "There must be at least one checkbox checked", Toast.LENGTH_SHORT).show();
                }
                if(!(currentLowerBound<=currentUpperBound)){
                    Toast.makeText(this, "The Lower Bound must be less than or equal to the Upper Bound", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.selectAllCheck:
                selectEverything();
                ((CheckBox)findViewById(R.id.selectAllCheck)).setChecked(false);
                break;

            case R.id.deselectAllCheck:
                deselectEverything();
                ((CheckBox)findViewById(R.id.deselectAllCheck)).setChecked(false);
                break;
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

    private void selectEverything(){
        for(int i  = 0; i<allTheNotes.length; i++){
            allTheNotes[i].setChecked(true);
        }
    }

    private void deselectEverything(){
        for(int i  = 0; i<allTheNotes.length; i++){
            allTheNotes[i].setChecked(false);
        }
    }
}
