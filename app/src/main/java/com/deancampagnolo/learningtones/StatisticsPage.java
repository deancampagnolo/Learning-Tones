package com.deancampagnolo.learningtones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;

public class StatisticsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_page);

        BarChart chart = (BarChart) findViewById(R.id.bar_chart);


    }
}
