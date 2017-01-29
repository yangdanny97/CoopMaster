package com.example.danny.project1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Context context = this.getApplicationContext();

        File path = context.getFilesDir();
        String filename = "Coop Master";
        File file = new File(path, filename);

        ArrayList<Integer> date = new ArrayList<Integer>();
        ArrayList<Integer> eggs = new ArrayList<Integer>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String str;
            while((str = bf.readLine()) != null) {
                String[] arg = str.split(",");
                System.out.println(str);
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

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(d);
        PointsGraphSeries<DataPoint> series1 = new PointsGraphSeries<DataPoint>(d);
        series1.setSize(12);

        //Axis
        graph.getGridLabelRenderer().setTextSize(40);
        graph.getGridLabelRenderer().setVerticalAxisTitleTextSize(40);
        graph.getGridLabelRenderer().setVerticalAxisTitle("Egg Count");

        graph.getGridLabelRenderer().setHorizontalAxisTitleTextSize(40);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Day");

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(date.get(0));
        graph.getViewport().setMaxX(date.get(date.size() - 1) + 0.2);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(Collections.max(eggs)*6/5);

        graph.getViewport().setScrollable(true);

        //Plot Graph
        graph.addSeries(series);
        graph.addSeries(series1);
    }
}