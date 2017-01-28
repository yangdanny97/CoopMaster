package com.example.danny.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String DATE = "com.example.project1.MESSAGE";
    public final static String EGG = "com.example.project1.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitData(View view) {

        EditText date = (EditText) findViewById(R.id.editText1);
        EditText eggs = (EditText) findViewById(R.id.editText2);
        String enteredDate = date.getText().toString();
        String enteredEggs = eggs.getText().toString();
        /*intent.putExtra(DATE, enteredDate);
        intent.putExtra(EGG, enteredEggs);*/
	
	File file = new File("Coop Master");
        String filename = "Coop Master";
        String string = enteredDate + "," + enteredEggs;
        FileOutputStream outputStream;

        try {
             outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
             outputStream.write(string.getBytes());
             outputStream.close();
        } catch (Exception e) {
             e.printStackTrace();
            }


    }

    public void viewGraph (View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
