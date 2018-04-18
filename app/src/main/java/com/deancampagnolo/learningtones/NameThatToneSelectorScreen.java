package com.deancampagnolo.learningtones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;


public class NameThatToneSelectorScreen extends AppCompatActivity {

    private CheckBox a, as, b, c, cs, d, ds, e, f, fs, g, gs;// declared for every checkbox/note
    String TAG = "Dean";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_that_tone_selector_screen);

        Log.v(TAG, "Weemp Womp");


        a = (CheckBox)findViewById(R.id.aCheck);
        as = (CheckBox)findViewById(R.id.asCheck);
        b = (CheckBox)findViewById(R.id.bCheck);
        c = (CheckBox)findViewById(R.id.cCheck);
        cs = (CheckBox)findViewById(R.id.csCheck);
        d = (CheckBox)findViewById(R.id.dCheck);
        ds = (CheckBox)findViewById(R.id.dsCheck);
        e = (CheckBox)findViewById(R.id.eCheck);
        f = (CheckBox)findViewById(R.id.fCheck);
        g = (CheckBox)findViewById(R.id.gCheck);
        gs = (CheckBox)findViewById(R.id.gsCheck);

    }

    public void onCheckboxClicked(View v){
        boolean checked = ((CheckBox)v).isChecked();
        switch(v.getId()){
            case R.id.aCheck:
                Log.v(TAG, "asdljldsakfjlsdkfjlsdkj");
        }
    }


}
