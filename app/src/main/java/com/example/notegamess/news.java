package com.example.notegamess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class news extends AppCompatActivity {

    EditText campoJuego,campoDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        campoJuego=(EditText) findViewById(R.id.campoJuego);
        campoDescripcion=(EditText) findViewById(R.id.campoDescripcion);



    }
    public void onClick(View view){

        RegistrarJuegos();
    }

    private void RegistrarJuegos() {
        conexionSQlite conn = new conexionSQlite(this, "bd_juegos", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(utilidad.CAMPO_JUEGO,campoJuego.getText().toString());
        values.put(utilidad.CAMPO_DESCRIPCION,campoDescripcion.getText().toString());

        long juegoResultante=db.insert(utilidad.TABLA_JUEGOS,utilidad.CAMPO_JUEGO,values);

        Toast.makeText(getApplicationContext(),"juego registro: "+juegoResultante,Toast.LENGTH_SHORT).show();


    }}