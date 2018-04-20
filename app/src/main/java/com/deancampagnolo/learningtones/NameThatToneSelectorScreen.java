package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import java.util.ArrayList;


public class NameThatToneSelectorScreen extends AppCompatActivity {


    private CheckBox[] allTheNotes;
    private ArrayList<CheckBox> ibby;
    private ArrayList<String> k;
    //private ArrayList<CheckBox> allTheNotes;
    String TAG = "dean";

    private void p(String a){
        Log.v(TAG, a);
    }

    /*private ArrayList<CheckBox> getTrueNotes(){
        p("start of getTrueNotes");
        ArrayList<CheckBox> trueNotes = new ArrayList<>();
        for(int i = 0; i<allTheNotes.size(); i++){
            if(allTheNotes.get(i).isChecked()){
                trueNotes.add(allTheNotes.get(i));
            }
        }
        p("end of getTrueNotes");
        return trueNotes;
    }*/
    private boolean[] getNotesBoolean(){
        boolean[] notesBoolean = new boolean[allTheNotes.length];
        for(int i = 0; i<allTheNotes.length; i++){
            if(allTheNotes[i].isChecked()){
                notesBoolean[i] = true;
            } else{
                notesBoolean[i] = false;
            }
        }
        return notesBoolean;

    }

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
    /*
    public void initializeNotes(){
        allTheNotes.add((CheckBox)findViewById(R.id.aCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.asCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.bCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.cCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.csCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.dCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.dsCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.eCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.fCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.fsCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.gCheck));
        allTheNotes.add((CheckBox)findViewById(R.id.gsCheck));
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        k = new ArrayList<String>();
        k.add("hi");
        allTheNotes = new CheckBox[12];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone_selector_screen);

        Log.v(TAG, "Weemp Womp");

        //initializeNotes();
       // allTheNotes = new ArrayList<>();
        initializeNotes();

        //p(""+allTheNotes[0].isChecked());



    }


    public void onCheckboxClicked(View v){
        boolean checked = ((CheckBox)v).isChecked();
        switch(v.getId()){
            case R.id.aCheck:
                if(checked) {
                    p("a");
                } else {
                    p("na");
                }
                break;
            case R.id.asCheck:
                if(checked){
                    p("as");
                } else{
                    p("nas");
                }
        }
    }


    public void onButtonClicked(View v){
        Intent i = new Intent(this, NameThatTone.class);
        //i.putExtra("trueNotes", getTrueNotes());
        //p("right before startActivity");
        //i.putExtra("yes", TAG);
        //getTrueNotes();
        /*Bundle bundle = new Bundle();
        bundle.putSerializable("trueNotes", ibby);
        i.putExtras(bundle);*/
        i.putExtra("notesBoolean", getNotesBoolean());
        p("hi");
        //i.putExtra("no", allTheNotes);
        startActivity(i);
    }


}
