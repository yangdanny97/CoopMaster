package com.example.danny.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        File data = getFilesDir();
        ArrayList<Integer> date = new ArrayList<Integer>();
        ArrayList<Integer> eggs = new ArrayList<Integer>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(data));
            String str;
            while((str = bf.readLine()) != null) {
                String[] arg = str.split(",");
                date.add(Integer.parseInt(arg[0]));
                eggs.add(Integer.parseInt(arg[1]));
            }
        } catch (IOException e) {
        }

        GraphView graph = (GraphView) findViewById(R.id.graph);
        DataPoint[] d = new DataPoint[date.size()];
        for(int i = 0;i < date.size();i++) {
            d[i] = new DataPoint(date.get(i), eggs.get(i));
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(d);
        graph.addSeries(series);
    }
}