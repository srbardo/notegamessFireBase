package com.example.notegamess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner)findViewById(R.id.spinner);

        String [] opciones = {"dark sould","blood borne","league of legend"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item,opciones);

        spinner1.setAdapter(adapter);


    }

    public void onClick(View view) {
        Intent algo=new Intent(MainActivity.this,news.class);
        startActivity(algo);
    }
}
