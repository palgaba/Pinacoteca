package com.aprilsoft.pinacoteca;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.aprilsoft.pinacoteca.Entidades.Obra;

import java.util.ArrayList;
import java.util.List;

public class CatalogoActivity extends AppCompatActivity {

    TextView txt_DatosSQL_estilo;
    TextView txt_DatosSQL_catalogo;
    TextView txt_DatosSQL_autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        txt_DatosSQL_estilo = (TextView)findViewById(R.id.txtView_datos);
        txt_DatosSQL_catalogo = (TextView)findViewById(R.id.textView_catalogo);
        txt_DatosSQL_autor = (TextView)findViewById(R.id.textView_autores);

        txt_DatosSQL_estilo.setText(Estilos());
        txt_DatosSQL_catalogo.setText(Catalogo());
        txt_DatosSQL_autor.setText(Autores());
    }

    private String Catalogo(){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getReadableDatabase();

        String Salida="";

        String consultaSQL   = " SELECT Count(Cuadros.titulo) FROM Cuadros; ";
        Cursor fila = bd.rawQuery(consultaSQL , null);

        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {
            Salida +="Total Obra:" +  fila.getInt(0) + "\n";
        }

        consultaSQL  = " SELECT Estilos.nombre, Count(Autores.nombre)";
        consultaSQL += " FROM Estilos LEFT JOIN Autores ON Autores.idEstilo = Estilos.id ";
        consultaSQL += " GROUP BY Estilos.nombre;";

        fila = bd.rawQuery(consultaSQL , null);

        Salida +="------ Autores por estilo --------\n";
        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                Salida += fila.getString(0) + ": "+ fila.getString(1)+"\n";
            } while(fila.moveToNext());
        }

        fila.close();
        bd.close();

        return Salida;
    }

    private String Estilos(){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getReadableDatabase();

        String Salida="";

        String consultaSQL   = " SELECT  Estilos.nombre, Count(Cuadros.titulo) ";
        consultaSQL  += " FROM Cuadros INNER JOIN Estilos ON Cuadros.idEstilo = Estilos.id ";
        consultaSQL  += " GROUP BY  Estilos.nombre ";
        consultaSQL  += " ORDER BY  Estilos.nombre; ";

        Cursor fila = bd.rawQuery(consultaSQL , null);

        Salida +="------ Cuadros por estilo--------\n";
        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {

            //Recorremos el cursor hasta que no haya más registros
            do {

                Salida +=fila.getString(0) + ": " + fila.getInt(1) + "\n";

            } while(fila.moveToNext());

        }

        fila.close();
        bd.close();

        return Salida;
    }

    private String Autores(){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getReadableDatabase();

        String Salida="";


        String consultaSQL   = " SELECT Autores.nombre, Count(Cuadros.titulo) ";
        consultaSQL  += " FROM Cuadros INNER JOIN Autores ON Cuadros.idAutor = Autores.id ";
        consultaSQL  += " GROUP BY Autores.nombre ";
        consultaSQL  += " ORDER BY Autores.nombre; ";

        Cursor fila = bd.rawQuery(consultaSQL , null);

        Salida +="------ Cuadros por autor --------\n";
        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {

            //Recorremos el cursor hasta que no haya más registros
            do {

                Salida +=fila.getString(0) + ": " + fila.getInt(1) + "\n";

            } while(fila.moveToNext());

        }

        fila.close();
        bd.close();

        return Salida;
    }

}
