package com.aprilsoft.pinacoteca;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aprilsoft.pinacoteca.Entidades.Estilo;

import java.util.ArrayList;
import java.util.List;

public class Estilos extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estilos);

        lista = (ListView)findViewById(R.id.mi_listview);

        //asiganamos un adapter a la listaView
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CargarEstilos());
        lista.setAdapter(adaptador);

    }

    private List<String> CargarEstilos(){

        ArrayList<String> Salida = new ArrayList<String>();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String  consultaSQL;

        consultaSQL  = " SELECT Estilos.id, Estilos.nombre, Estilos.descripcion, Estilos.grupo ";
        consultaSQL += " FROM Estilos ";
        consultaSQL += " ORDER BY Estilos.nombre ";

        Cursor fila = bd.rawQuery(consultaSQL , null);

        List<Estilo> CatalogoEstilos = new ArrayList<>();

        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {

            //Recorremos el cursor hasta que no haya más registros
            do {
                Estilo estilo_item = new Estilo();

                estilo_item.setIdEstilo(fila.getInt(0));
                estilo_item.setNombre(fila.getString(1));
                estilo_item.setDescripcion(fila.getString(2));
                estilo_item.setGrupo(fila.getString(3));

                Salida.add(
                        fila.getString(1) + " :\n " +
                        fila.getString(2)+ "\n"
                );
                CatalogoEstilos.add(estilo_item);

            } while(fila.moveToNext());

        }
        return Salida;
    }
}
