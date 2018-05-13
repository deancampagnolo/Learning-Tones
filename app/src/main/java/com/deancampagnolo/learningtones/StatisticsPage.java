package com.deancampagnolo.learningtones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class StatisticsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_page);

        BarChart chart = (BarChart) findViewById(R.id.bar_chart);
        ArrayList<BarDataSet> entryData = new ArrayList<>();
        //https://stackoverflow.com/questions/38658487/how-to-implement-horizontal-rating-bar-chart-in-android-studio
        ArrayList<BarEntry> barEntry = new ArrayList<>();

        BarEntry theOne = new BarEntry(11f,0);
        barEntry.add(theOne);
        BarEntry theTwo = new BarEntry(20f, 1);
        barEntry.add(theTwo);




        ArrayList<String> labels = new ArrayList<>();

        labels.add("The One");
        labels.add("The Two");

        entryData.add(new BarDataSet(barEntry, "Notes"));

        BarData data = new BarData(labels,entryData);

        chart.setData(data);
        chart.setDescription("The Chart");
        chart.animateXY(2000, 2000);
        chart.invalidate();




    }
}
