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
        ArrayList<Double> water = new ArrayList<Double>();
        ArrayList<Double> feed = new ArrayList<Double>();
        ArrayList<Double> temp = new ArrayList<Double>();
        ArrayList<Double> hum = new ArrayList<Double>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String str;
            while((str = bf.readLine()) != null) {
                String[] arg = str.split(",");
                date.add(Integer.parseInt(arg[0]));
                eggs.add(Integer.parseInt(arg[1]));
                water.add(Double.parseDouble(arg[2]));
                feed.add(Double.parseDouble(arg[3]));
                temp.add(Double.parseDouble(arg[4]));
                hum.add(Double.parseDouble(arg[5]));
            }
        } catch (IOException e) {
        }

        //Egg Plot
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

        //Water Plot
        GraphView graph2 = (GraphView) findViewById(R.id.graph2);
        DataPoint[] d2 = new DataPoint[date.size()];
        for(int i = 0;i < date.size();i++) {
            d2[i] = new DataPoint(date.get(i), water.get(i));
        }

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(d2);
        PointsGraphSeries<DataPoint> series21 = new PointsGraphSeries<DataPoint>(d2);
        series21.setSize(12);

        //Axis
        graph2.getGridLabelRenderer().setTextSize(40);
        graph2.getGridLabelRenderer().setVerticalAxisTitleTextSize(40);
        graph2.getGridLabelRenderer().setVerticalAxisTitle("Water Remaining");

        graph2.getGridLabelRenderer().setHorizontalAxisTitleTextSize(40);
        graph2.getGridLabelRenderer().setHorizontalAxisTitle("Day");

        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(date.get(0));
        graph2.getViewport().setMaxX(date.get(date.size() - 1) + 0.2);

        graph2.getViewport().setYAxisBoundsManual(true);
        graph2.getViewport().setMinY(0);
        graph2.getViewport().setMaxY(Collections.max(water)*6/5);

        graph2.getViewport().setScrollable(true);

        //Plot Graph
        graph2.addSeries(series2);
        graph2.addSeries(series21);

        //Feed Plot
        GraphView graph3 = (GraphView) findViewById(R.id.graph3);
        DataPoint[] d3 = new DataPoint[date.size()];
        for(int i = 0;i < date.size();i++) {
            d3[i] = new DataPoint(date.get(i), feed.get(i));
        }

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(d3);
        PointsGraphSeries<DataPoint> series31 = new PointsGraphSeries<DataPoint>(d3);
        series31.setSize(12);

        //Axis
        graph3.getGridLabelRenderer().setTextSize(40);
        graph3.getGridLabelRenderer().setVerticalAxisTitleTextSize(40);
        graph3.getGridLabelRenderer().setVerticalAxisTitle("Feed Remaining");

        graph3.getGridLabelRenderer().setHorizontalAxisTitleTextSize(40);
        graph3.getGridLabelRenderer().setHorizontalAxisTitle("Day");

        graph3.getViewport().setXAxisBoundsManual(true);
        graph3.getViewport().setMinX(date.get(0));
        graph3.getViewport().setMaxX(date.get(date.size() - 1) + 0.2);

        graph3.getViewport().setYAxisBoundsManual(true);
        graph3.getViewport().setMinY(0);
        graph3.getViewport().setMaxY(Collections.max(feed)*6/5);

        graph3.getViewport().setScrollable(true);

        //Plot Graph
        graph3.addSeries(series3);
        graph3.addSeries(series31);

        //Temperature Plot
        GraphView graph4 = (GraphView) findViewById(R.id.graph4);
        DataPoint[] d4 = new DataPoint[date.size()];
        for(int i = 0;i < date.size();i++) {
            d4[i] = new DataPoint(date.get(i), temp.get(i));
        }

        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(d4);
        PointsGraphSeries<DataPoint> series41 = new PointsGraphSeries<DataPoint>(d4);
        series41.setSize(12);

        //Axis
        graph4.getGridLabelRenderer().setTextSize(40);
        graph4.getGridLabelRenderer().setVerticalAxisTitleTextSize(40);
        graph4.getGridLabelRenderer().setVerticalAxisTitle("Temperature");

        graph4.getGridLabelRenderer().setHorizontalAxisTitleTextSize(40);
        graph4.getGridLabelRenderer().setHorizontalAxisTitle("Day");

        graph4.getViewport().setXAxisBoundsManual(true);
        graph4.getViewport().setMinX(date.get(0));
        graph4.getViewport().setMaxX(date.get(date.size() - 1) + 0.2);

        graph4.getViewport().setYAxisBoundsManual(true);
        graph4.getViewport().setMinY(0);
        graph4.getViewport().setMaxY(Collections.max(temp)*6/5);

        graph4.getViewport().setScrollable(true);

        //Plot Graph
        graph4.addSeries(series4);
        graph4.addSeries(series41);

        //Humidity Plot
        GraphView graph5 = (GraphView) findViewById(R.id.graph5);
        DataPoint[] d5 = new DataPoint[date.size()];
        for(int i = 0;i < date.size();i++) {
            d5[i] = new DataPoint(date.get(i), hum.get(i));
        }

        LineGraphSeries<DataPoint> series5 = new LineGraphSeries<DataPoint>(d5);
        PointsGraphSeries<DataPoint> series51 = new PointsGraphSeries<DataPoint>(d5);
        series51.setSize(12);

        //Axis
        graph5.getGridLabelRenderer().setTextSize(40);
        graph5.getGridLabelRenderer().setVerticalAxisTitleTextSize(40);
        graph5.getGridLabelRenderer().setVerticalAxisTitle("Humidity");

        graph5.getGridLabelRenderer().setHorizontalAxisTitleTextSize(40);
        graph5.getGridLabelRenderer().setHorizontalAxisTitle("Day");

        graph5.getViewport().setXAxisBoundsManual(true);
        graph5.getViewport().setMinX(date.get(0));
        graph5.getViewport().setMaxX(date.get(date.size() - 1) + 0.2);

        graph5.getViewport().setYAxisBoundsManual(true);
        graph5.getViewport().setMinY(0);
        graph5.getViewport().setMaxY(Collections.max(hum)*6/5);

        graph5.getViewport().setScrollable(true);

        //Plot Graph
        graph5.addSeries(series5);
        graph5.addSeries(series51);

    }
}