package com.example.notegamess;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Consulta extends AppCompatActivity {

    EditText campoBusc,campoDes;

    conexionSQlite conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        conn=new conexionSQlite(getApplicationContext(),"bd_juegos",null,1);

        campoBusc=(EditText) findViewById(R.id.campoBusc);
        campoDes=(EditText) findViewById(R.id.campoDes);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buscar:
                consultar();

        }
    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros ={campoBusc.getText().toString()};
        String[] campos={utilidad.CAMPO_JUEGO,utilidad.CAMPO_DESCRIPCION};

        try{
            Cursor cursor =db.query(utilidad.TABLA_JUEGOS,campos,utilidad.CAMPO_JUEGO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoBusc.setText(cursor.getString(0));
            campoDes.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"el documento no existe",Toast.LENGTH_LONG).show();
            limpiar();

        }


    }

    private void limpiar() {
        campoBusc.setText("");
        campoDes.setText("");
    }


}
