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

        //Initialize File
        File path = context.getFilesDir();
        String filename = "Coop Master";
	    File file = new File(path, filename);

        //
        String enteredDate = date.getText().toString();
        String enteredEggs = eggs.getText().toString();
        String string = enteredDate + "," + enteredEggs + "\n";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
            date.setText("");
            eggs.setText("");
            Toast.makeText(MainActivity.this, "Saved Data!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewGraph (View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
