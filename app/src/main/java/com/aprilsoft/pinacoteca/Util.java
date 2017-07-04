package com.aprilsoft.pinacoteca;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aprilsoft.pinacoteca.Entidades.Configuracion;

public class Util {

    public Configuracion RecuperaConfiguracion(Context ctx){

        com.aprilsoft.pinacoteca.Entidades.Configuracion out_confi = new com.aprilsoft.pinacoteca.Entidades.Configuracion();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(ctx,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor fila = bd.rawQuery("select id, NumeroPreguntas, Dificultad, tipo, tiempo FROM Configuracion where id=1", null);

        if (fila.moveToFirst()) {

            out_confi.setId(fila.getInt(0));
            out_confi.setPreguntas(fila.getInt(1));
            out_confi.setDificultad(fila.getString(2));
            out_confi.setTipo(fila.getString(3));
            out_confi.setTiempo(fila.getString(4));

        } else {
            out_confi = null;
        }
            //Toast.makeText(ctx, "No existe ningúna configuracion",Toast.LENGTH_SHORT).show();

        bd.close();
        return  out_confi;

    }
}
