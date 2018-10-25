package com.deancampagnolo.learningtones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class StatisticsPage extends AppCompatActivity {
    private void p(String a){
        Log.v(TAG, a);
    }

    ArrayList<BarEntry> barEntry;
    ArrayList<String> labels;
    int[][] scores;
    String TAG = "dean";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_page);


        String sRecieved = getIntent().getExtras().getString("scores");

        Object[] objectArray = (Object[]) getIntent().getExtras().getSerializable("scoresSerializable");
        if(objectArray!=null){
            scores = new int[objectArray.length][];
            for(int i=0;i<objectArray.length;i++){
                scores[i]=(int[]) objectArray[i];
            }
        }

        HorizontalBarChart chart = (HorizontalBarChart) findViewById(R.id.bar_chart);
        ArrayList<BarDataSet> entryData = new ArrayList<>();
        barEntry = new ArrayList<>();


        createBarEntries();
        labels = new ArrayList<>();
        createLabels();

        entryData.add(new BarDataSet(barEntry, "Notes"));

        BarData data = new BarData(labels,entryData);

        //chart.getAxisLeft().setAxisMinValue(100);//FIXME this crashes on the name that tone selector screen


        chart.setData(data);
        chart.setDescription("Percentages of Your Guesses");
        chart.animateXY(1000, 2000);
        chart.invalidate();

    }

    public void createBarEntries(){
        p("yay");
        BarEntry aBar = new BarEntry(calculatePercentage(0),0);
        barEntry.add(aBar);
        p("yaypt2");

        BarEntry asBar = new BarEntry(calculatePercentage(1),1);
        barEntry.add(asBar);

        BarEntry bBar = new BarEntry(calculatePercentage(2),2);
        barEntry.add(bBar);

        BarEntry cBar = new BarEntry(calculatePercentage(3),3);
        barEntry.add(cBar);

        BarEntry csBar = new BarEntry(calculatePercentage(4),4);
        barEntry.add(csBar);

        BarEntry dBar = new BarEntry(calculatePercentage(5),5);
        barEntry.add(dBar);

        BarEntry dsBar = new BarEntry(calculatePercentage(6),6);
        barEntry.add(dsBar);

        BarEntry eBar = new BarEntry(calculatePercentage(7),7);
        barEntry.add(eBar);

        BarEntry fBar = new BarEntry(calculatePercentage(8),8);
        barEntry.add(fBar);

        BarEntry fsBar = new BarEntry(calculatePercentage(9),9);
        barEntry.add(fsBar);

        BarEntry gBar = new BarEntry(calculatePercentage(10),10);
        barEntry.add(gBar);

        BarEntry gsBar = new BarEntry(calculatePercentage(11),11);
        barEntry.add(gsBar);



    }

    public float calculatePercentage(int index){
        if(scores[index][0] == 0 && scores[index][1] == 0){
            return 0;
        }
        return ((float)scores[index][0]/(scores[index][0]+scores[index][1]))*100;
    }

    public void createLabels(){
        labels.add(getString(R.string.aNote));
        labels.add(getString(R.string.asNote));
        labels.add(getString(R.string.bNote));
        labels.add(getString(R.string.cNote));
        labels.add(getString(R.string.csNote));
        labels.add(getString(R.string.dNote));
        labels.add(getString(R.string.dsNote));
        labels.add(getString(R.string.eNote));
        labels.add(getString(R.string.fNote));
        labels.add(getString(R.string.fsNote));
        labels.add(getString(R.string.gNote));
        labels.add(getString(R.string.gsNote));

    }
}
