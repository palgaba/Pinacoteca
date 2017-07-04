package com.aprilsoft.pinacoteca;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boolean EliminarBBDD = true;

        //eliminar la base de datos de prieba en modo desarrollo
        if (EliminarBBDD) {
            String DB_PATH = "/data/user/0/com.aprilsoft.pinacoteca/databases/";
            String myPath = DB_PATH + "BBDD";
            SQLiteDatabase.deleteDatabase(new File(myPath));
        }

    }

    public void comienzaJuegoAutor (View v){
        Intent tarea= new Intent(this,JuegoAutorActivity.class);
        tarea.putExtra("xAutor", "comienzaJuegoAutor");
        startActivity(tarea);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent tarea= new Intent(this,ConfiguracionActivity.class);
            tarea.putExtra("xAutor", "Configuracion");
            startActivity(tarea);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
