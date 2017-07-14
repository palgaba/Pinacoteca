package com.aprilsoft.pinacoteca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aprilsoft.pinacoteca.Entidades.Configuracion;

public class Util {

    public Configuracion RecuperaConfiguracion(Context ctx){

        com.aprilsoft.pinacoteca.Entidades.Configuracion out_confi = new com.aprilsoft.pinacoteca.Entidades.Configuracion();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(ctx,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor fila = bd.rawQuery("select id, NumeroPreguntas, Dificultad, tipo, tiempo, animacion FROM Configuracion where id=1", null);

        if (fila.moveToFirst()) {

            out_confi.setId(fila.getInt(0));
            out_confi.setPreguntas(fila.getInt(1));
            out_confi.setDificultad(fila.getString(2));
            out_confi.setTipo(fila.getString(3));
            out_confi.setTiempo(fila.getString(4));
            out_confi.setAnimacion(fila.getString(5));

        } else {
            out_confi = null;
        }
            //Toast.makeText(ctx, "No existe ningúna configuracion",Toast.LENGTH_SHORT).show();

        bd.close();
        return  out_confi;

    }

    public boolean GuardarConfiguracion(Configuracion Datos, Context ctx){


        boolean estado= false;

        // COMPROBAR QUE ESTAN TODOS LOS DATOS, return FALSE

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(ctx,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();

        // actualizamos con los nuevos datos, la información cambiada
        registro.put("NumeroPreguntas", Datos.getPreguntas());
        registro.put("Dificultad", Datos.getDificultad());
        registro.put("tipo", Datos.getTipo());
        registro.put("tiempo", Datos.getTiempo());
        registro.put("animacion", Datos.getAnimacion());

        int cant = bd.update("Configuracion", registro, "id=1", null);

        bd.close();
        admin.close();

        if (cant == 1){
            estado = true;
        }
        return estado;

    }

    public boolean isNumeric(String str) {
        try
        {
            int numEntero = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
