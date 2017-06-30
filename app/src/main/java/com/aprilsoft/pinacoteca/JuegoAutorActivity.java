package com.aprilsoft.pinacoteca;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aprilsoft.pinacoteca.Entidades.Autor;
import com.aprilsoft.pinacoteca.Entidades.Configuracion;
import com.aprilsoft.pinacoteca.Entidades.Obra;
import java.util.ArrayList;
import java.util.List;


public class JuegoAutorActivity extends AppCompatActivity {

    int indiceActual;//mantine dentro de la lista
    List<Obra> CatalogoObras =  new ArrayList<>();
    List<Autor> CatalogoAutores =  new ArrayList<>();
    List<Obra> ObrasSeleccionadas =  new ArrayList<>();
    List<Integer> listaTemporal =  new ArrayList<>();

    int aciertos;
    int errores;
    int numeroDePreguntas;
    Configuracion Conf ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_juego_autor);

            reiniciaJuego();

        } catch (Exception e) {
            e.printStackTrace();
            Log.v("ERROR", e.toString());
        }

    }


    public void reiniciaJuego(){

        try {

            //inicializamos variables de configuracion
            Conf = RecuperarConfiguracion();

            //inicializa varible generales del juego
            aciertos=0;
            errores=0;
            indiceActual=0;
            numeroDePreguntas=Conf.getPreguntas();


            //cargar un array de TODAS las obras que se leen desde un XMl alojado en RES/raw
            CatalogoObras = CargarObras();

            //lo necesito para escoger mas autores que no son para completar las respuestas
            CatalogoAutores =  CargarAutores();

            //selecciona aleatoriamente dentro del catalogo n obras
            listaTemporal=NumeroaAleatoriosSinRepeticion(0,CatalogoObras.size(),numeroDePreguntas,-1);

            //guarda los n obras aleatorias en las obras seleccionadas para preguntar
            for (int i = 0; i < numeroDePreguntas ; i++) {
                ObrasSeleccionadas.add(CatalogoObras.get(listaTemporal.get(i)));
            }

            //TITULO de la primera ... indice =0
            TextView textView_titulo = (TextView) findViewById(R.id.textView_titulo);
            textView_titulo.setText(ObrasSeleccionadas.get(indiceActual).getTitulo());

            //IMAGEN DEL CUADRO...
            String Imagen = ObrasSeleccionadas.get(indiceActual).getImagen();

            //busco el identificador interno a partir del nombre del recurso
            Resources res = getResources();
            int resourceId = res.getIdentifier(Imagen, "drawable", getPackageName() );

            ImageView MiimageCodigo = (ImageView) findViewById(R.id.MI_imageView);
            MiimageCodigo.setImageResource( resourceId );

            int IDAutorReal = ObrasSeleccionadas.get(indiceActual).getIdautor();

            listaTemporal=NumeroaAleatoriosSinRepeticion(0,CatalogoAutores.size(),2,IDAutorReal);

            listaTemporal = BajaraLista(listaTemporal);

            //Escribe los autores en cada boton
            Button boton01 = (Button) findViewById(R.id.button01);
            boton01.setText(CatalogoAutores.get(listaTemporal.get(0)).getAutor());

            Button boton02 = (Button) findViewById(R.id.button02);
            boton02.setText(CatalogoAutores.get(listaTemporal.get(1)).getAutor());

            Button boton03 = (Button) findViewById(R.id.button03);
            boton03.setText(CatalogoAutores.get(listaTemporal.get(2)).getAutor());;

            TextView textView_estado = (TextView) findViewById(R.id.textView_preguntaActualTotal);
            textView_estado.setText((indiceActual+1)+ "/" + numeroDePreguntas);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CompruebaRespuesta(Button BotonSeleccionado){

        String AutorSeleccionado = BotonSeleccionado.getText().toString();
        String AutorReal = ObrasSeleccionadas.get(indiceActual).getAutorNombre();

        if (AutorSeleccionado.equals(AutorReal)) {
            BotonSeleccionado.setBackgroundColor(Color.GREEN);
            aciertos++;
        }else {
            BotonSeleccionado.setBackgroundColor(Color.RED);
            Toast.makeText(this, "oohhhh !!!", Toast.LENGTH_SHORT).show();
            errores++;
        }

        delay(1);
    }

    public void SiguientePregunta(){

        try {

            //comprueba final de fase
            if( (indiceActual) >= numeroDePreguntas){

//                GuardarEstadisticas();
//
//                String ParamAciertos;
//                ParamAciertos = String.valueOf(aciertos);
//                Intent tarea= new Intent(this,FinalEstadisticasActivity.class);
//                tarea.putExtra("aciertos", ParamAciertos);
//                startActivity(tarea);
            }else{
                //TITULO de la primera ... indice =0
                TextView textView_titulo = (TextView) findViewById(R.id.textView_titulo);
                textView_titulo.setText(ObrasSeleccionadas.get(indiceActual).getTitulo());

                //IMAGEN DEL CUADRO...
                String Imagen = ObrasSeleccionadas.get(indiceActual).getImagen();

                //busco el identificador interno a partir del nombre del recurso
                Resources res = getResources();
                int resourceId = res.getIdentifier(Imagen, "drawable", getPackageName() );

                ImageView MiimageCodigo = (ImageView) findViewById(R.id.MI_imageView);
                MiimageCodigo.setImageResource( resourceId );

                int IDAutorReal = ObrasSeleccionadas.get(indiceActual).getIdautor();

                listaTemporal=NumeroaAleatoriosSinRepeticion(0,CatalogoAutores.size(),2,IDAutorReal);
                listaTemporal = BajaraLista(listaTemporal);


                //Escribe los autores en cada boton
                Button boton01 = (Button) findViewById(R.id.button01);
                boton01.setText(CatalogoAutores.get(listaTemporal.get(0)).getAutor());
                boton01.setBackgroundResource(R.color.cellColor512);

                Button boton02 = (Button) findViewById(R.id.button02);
                boton02.setText(CatalogoAutores.get(listaTemporal.get(1)).getAutor());
                boton02.setBackgroundResource(R.color.cellColor512);

                Button boton03 = (Button) findViewById(R.id.button03);
                boton03.setText(CatalogoAutores.get(listaTemporal.get(2)).getAutor());
                boton03.setBackgroundResource(R.color.cellColor512);

                TextView textView_estado = (TextView) findViewById(R.id.textView_preguntaActualTotal);
                textView_estado.setText((indiceActual+1) + "/" + numeroDePreguntas);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void  Boton_01 (View v){
        Button boton1 = (Button)findViewById(R.id.button01);
        CompruebaRespuesta(boton1);
    }
    public void  Boton_02 (View v){
        Button boton1 = (Button)findViewById(R.id.button02);
        CompruebaRespuesta(boton1);
    }
    public void  Boton_03 (View v){
        Button boton1 = (Button)findViewById(R.id.button03);
        CompruebaRespuesta(boton1);
    }

    private Configuracion RecuperarConfiguracion(){

        Configuracion out = new Configuracion();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery("select id, NumeroPreguntas, Dificultad, opcion1, opcion2 from configuracion where id=1", null);

        if (fila.moveToFirst()) {

            out.setId(1);
            out.setPreguntas(fila.getInt(1));
            out.setDificultad(fila.getString(2));
            out.setOpcion1(fila.getString(3));
            out.setOpcion2(fila.getString(4));


        } else
            Toast.makeText(this, "No existe ningúna configuracion",Toast.LENGTH_SHORT).show();

        bd.close();

        return  out;

    }

    private List<Obra> CargarObras(){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String  consultaSQL;
        consultaSQL  = " SELECT Cuadros.titulo, Autores.nombre, Estilos.nombre, Cuadros.imagen ";
        consultaSQL += " FROM Autores INNER JOIN (Estilos INNER JOIN Cuadros ON Estilos.id = Cuadros.idEstilo) ON Autores.id = Cuadros.idAutor;";


        Cursor fila = bd.rawQuery(consultaSQL , null);

        List<Obra> CatalogoObras = new ArrayList<>();

            //Nos aseguramos de que existe al menos un registro
            if (fila.moveToFirst()) {

                //Recorremos el cursor hasta que no haya más registros
                do {
                    Obra Obra_item = new Obra();

                    Obra_item.setTitulo(fila.getString(0));
                    Obra_item.setAutorNombre(fila.getString(1));
                    Obra_item.setEstilo(fila.getString(2));
                    Obra_item.setImagen(fila.getString(3));


                    CatalogoObras.add(Obra_item);

                } while(fila.moveToNext());

            }
            return CatalogoObras;
    }

    private List<Autor> CargarAutores(){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String  consultaSQL;

        consultaSQL  = " SELECT Autores.id, Autores.nombre, Estilos.nombre ";
        consultaSQL += " FROM Autores INNER JOIN Estilos ON Autores.idEstilo = Estilos.Id;";


        Cursor fila = bd.rawQuery(consultaSQL , null);

        List<Autor> CatalogoAutores = new ArrayList<>();

        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {

            //Recorremos el cursor hasta que no haya más registros
            do {
                Autor autor_item = new Autor();

                autor_item.setIdentificador(fila.getInt(0));
                autor_item.setAutor(fila.getString(1));
                autor_item.setEstilo(fila.getString(2));

                CatalogoAutores.add(autor_item);

            } while(fila.moveToNext());

        }
        return CatalogoAutores;
    }

    public List<Integer> NumeroaAleatoriosSinRepeticion (int minValor , int maxValor, int elementosDevueltos, int valorExcluido ) {

        Integer pos;
        List<Integer> listaTemporal =  new ArrayList<>();

        if (valorExcluido >=0){
            pos = valorExcluido;
            listaTemporal.add(pos);
        }

        //numeros aleatorios sin repeticion entre 0..n
        for (int i = 0; i < elementosDevueltos ; i++) {
            pos = (int) Math.floor(Math.random() * maxValor );
            while (listaTemporal.contains(pos)) {
                pos = (int) Math.floor(Math.random() * maxValor );
            }
            listaTemporal.add(pos);
        }


        return listaTemporal;

    }

    public List<Integer> BajaraLista(List<Integer> listaEntrada){

        Integer pos=0;
        Integer tamanno = listaEntrada.size();

        List<Integer> listaTemporalMezcla =  new ArrayList<>();
        List<Integer> listaTemporalSalida =  new ArrayList<>(tamanno);


        //inicializo a ceros
        for (int i = 0; i < tamanno ; i++) {
            listaTemporalSalida.add(i,0);
        }


        //como el primer valor de la matriz es siempre le correcto
        //tenemos que mezclzr un poco el resultado
        for (int i = 0; i < tamanno ; i++) {
            pos = (int) Math.floor(Math.random() * tamanno );
            while (listaTemporalMezcla.contains(pos)) {
                pos = (int) Math.floor(Math.random() * tamanno );
            }
            listaTemporalMezcla.add(pos);
        }

        //el la salida guardo
        for (int i = 0; i < tamanno ; i++) {
            int index = listaTemporalMezcla.get(i);
            Integer valor = listaEntrada.get(i);
            listaTemporalSalida.set(index,valor);
        }


        return listaTemporalSalida;
    }

    public void delay(int seconds){

        final int milliseconds = seconds * 1000;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //add your code here
                        indiceActual++;
                        SiguientePregunta();
                    }
                }, milliseconds);
            }
        });
    }

}
