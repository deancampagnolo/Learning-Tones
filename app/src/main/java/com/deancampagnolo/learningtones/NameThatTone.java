package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.graphics.Color;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import java.util.ArrayList;

public class NameThatTone extends AppCompatActivity {
    private int usableNotesStart = 2;
    private int usableNotesFinish = 6;
    private final int NUMBEROFNOTES = 12;
    private String TAG = "dean";
    private boolean[] notesBoolean;
    private CheckBox[] allTheNotes;
    private GridLayout gridLayout;
    private ArrayList<Integer> usableNotes;
    private ArrayList<Integer> soundPoolUsableNotes;
    private ArrayList<Integer> soundPoolExtras;
    private int[][] scores;
    private int currentNote;
    private int numberOfNotesBeingUsed;
    private SoundPool sp;

    //This function helps with debugging by logging values
    private void p(String a){
        Log.v(TAG, a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //setting the xml file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone);

        //this block is to retrieve the booleanArray from the last intent
        Intent lastIntent = getIntent();
        notesBoolean = lastIntent.getBooleanArrayExtra("notesBoolean");

        //gets the grid layout
        gridLayout = (GridLayout) findViewById(R.id.NTTGridLayout);
        allTheNotes = new CheckBox[NUMBEROFNOTES];

        initializeNotes();
        initializeScores();
        unnecessaryNotesDisappear();

        createUsableNotes();
        sp = new SoundPool.Builder().setMaxStreams(2).build();//samples default to 1 which I want.
        loadRealNotes(sp);
        loadExtras(sp);

        numberOfNotesBeingUsed = soundPoolUsableNotes.size();
        getRandomNote();
        currentNote = getRandomNote();

        //initializing the button to next note in the beginning
        Button a = (Button)findViewById(R.id.submitButton);
        a.setText(R.string.start);

        p("after play");
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

    public void initializeScores(){
        //first is number of notes, second is right and wrong
        scores = new int[12][2];//in java all values are initialized to 0
    }

    //removes CheckBoxes from view if they have the value false
    private void unnecessaryNotesDisappear(){
        for(int i = 0; i<NUMBEROFNOTES; i++){
            if(!notesBoolean[i] ){//if false
                gridLayout.removeView(allTheNotes[i]);
            }
        }
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
            soundPoolUsableNotes.add(sp.load(this,usableNotes.get(i),0));
        }
    }

    private void loadExtras(SoundPool sp){
        //first index is always success
        //second index is always wrong
        soundPoolExtras = new ArrayList<>();
        soundPoolExtras.add(sp.load(this,R.raw.success,0));
        soundPoolExtras.add(sp.load(this,R.raw.wrong,0));
    }

    public int getRandomNote(){
        return (int)(Math.random()*numberOfNotesBeingUsed);
    }

    public void onButtonClicked(View v){
        switch(v.getId()){
            case R.id.hearAgainButton:
                p("hearAgainButton pressed");
                sp.play(soundPoolUsableNotes.get(currentNote),1f,1f,0,0,1f);
                break;

            case R.id.submitButton:
                //p("submitButton pressed");

                if(((Button) v).getText().toString() == getString(R.string.nextNote) ||
                        ((Button) v).getText().toString() == getString(R.string.start)){
                    clearEverything();
                    ((Button) v).setText(R.string.submit);
                    currentNote = getRandomNote();
                    sp.play(soundPoolUsableNotes.get(currentNote),1,1,0,0,1f);
                    break;
                }

                if(isSubmissionCorrect()){
                    answerTrue();
                } else {
                    answerFalse();
                }
                break;

            case R.id.statsButton:
                Intent i = new Intent(this, StatisticsPage.class);
                String stringToSend = "theScores";
                i.putExtra("scores", stringToSend);

                Bundle bundle = new Bundle();
                bundle.putSerializable("scoresSerializable", scores);

                i.putExtras(bundle);
                startActivity(i);
                break;

        }
    }

    public void onCheckBoxClicked(View v){//TODO this functions speed can be massively improved
        for(int i = 0; i<NUMBEROFNOTES; i++){
            if(v.getId() != allTheNotes[i].getId()){
                allTheNotes[i].setChecked(false);
            }
        }
    }

    public void clearEverything(){
        for(int i  = 0; i<NUMBEROFNOTES; i++){
            allTheNotes[i].setChecked(false);
            allTheNotes[i].setTextColor(Color.BLACK);
        }
    }

    public boolean isSubmissionCorrect(){
        for(int i = 0; i<notesBoolean.length; i++) {
            if (notesBoolean[i]) {

                if (allTheNotes[i].isChecked() && i != currentNoteIs()) {
                    return false;
                }
            }
        }
        if(allTheNotes[currentNoteIs()].isChecked()){
            return true;
        }else {
            return false;
        }
    }

    public void answerTrue(){
        sp.play(soundPoolExtras.get(0),1f,1f,0,0,1f);
        allTheNotes[currentNoteIs()].setTextColor(Color.GREEN);
        Button a = (Button)findViewById(R.id.submitButton);
        a.setText(R.string.nextNote);
        scores[currentNoteIs()][0] ++;

    }

    public void answerFalse(){
        sp.play(soundPoolExtras.get(1),.3f,.3f,0,0,1f);
        allTheNotes[currentNoteIs()].setTextColor(Color.GREEN);
        Button k = (Button)findViewById(R.id.submitButton);
        k.setText(R.string.nextNote);
        scores[currentNoteIs()][1] ++;

    }

    public int currentNoteIs(){//returns the note in regards to allTheNotes
        int amountPerNote = (usableNotesFinish-usableNotesStart)+1;//for the total amount of notes
        int beginningSearch = 0;

        for(int i = 0; i<notesBoolean.length; i++){
            if(notesBoolean[i]){
                if(currentNote>=beginningSearch && currentNote<beginningSearch+amountPerNote){
                    return i;
                }
                beginningSearch += amountPerNote;
            }
        }
        return -1;
    }
}