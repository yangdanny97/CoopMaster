package com.example.danny.project1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    public final static String DATE = "com.example.project1.MESSAGE";
    public final static String EGG = "com.example.project1.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitData(View view) {
        Context context = this.getApplicationContext();
        EditText date = (EditText) findViewById(R.id.editText1);
        EditText eggs = (EditText) findViewById(R.id.editText2);
        EditText water = (EditText) findViewById(R.id.editText3);
        EditText feed = (EditText) findViewById(R.id.editText4);
        EditText temp = (EditText) findViewById(R.id.editText5);
        EditText hum = (EditText) findViewById(R.id.editText6);

        //Initialize File
        File path = context.getFilesDir();
        String filename = "Coop Master";
	    File file = new File(path, filename);

        //
        String enteredDate = date.getText().toString();
        String enteredEggs = eggs.getText().toString();
        String enteredWater = water.getText().toString();
        String enteredFeed = feed.getText().toString();
        String enteredTemp = temp.getText().toString();
        String enteredHum = hum.getText().toString();
        if (enteredDate.equals("") || enteredEggs.equals("") || enteredWater.equals("") ||enteredFeed.equals("")||enteredTemp.equals("")||enteredHum.equals("")){
            Toast.makeText(MainActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
        } else{
            String string = enteredDate + "," + enteredEggs + "," + enteredWater+ "," + enteredFeed+ "," + enteredTemp+ "," + enteredHum+ "\n";
            FileOutputStream outputStream;
            try {
                outputStream = openFileOutput(filename, Context.MODE_APPEND);
                outputStream.write(string.getBytes());
                outputStream.close();
                date.setText("");
                eggs.setText("");
                feed.setText("");
                water.setText("");
                temp.setText("");
                hum.setText("");
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void viewGraph (View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void resetAllData (View view) {
        Context context = this.getApplicationContext();
        File path = context.getFilesDir();
        String filename = "Coop Master";
        File file = new File(path, filename);

        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write("".getBytes());
            Toast.makeText(MainActivity.this, "Reset All Data!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
