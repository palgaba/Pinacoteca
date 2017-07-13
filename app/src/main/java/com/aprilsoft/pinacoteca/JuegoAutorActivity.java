package com.aprilsoft.pinacoteca;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.v4.content.ContextCompat;
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
import com.aprilsoft.pinacoteca.Entidades.Estilo;
import com.aprilsoft.pinacoteca.Entidades.Obra;
import java.util.ArrayList;
import java.util.List;


public class JuegoAutorActivity extends AppCompatActivity {

    private static final String LOGTAG = "LogsAndroid";

    int indiceActual;//mantine dentro de la lista
    List<Obra> CatalogoObras =  new ArrayList<>();
    List<Autor> CatalogoAutores =  new ArrayList<>();
    List<Estilo> CatalogoEstilos =  new ArrayList<>();
    List<Obra> ObrasSeleccionadas =  new ArrayList<>();
    List<Integer> listaTemporal =  new ArrayList<>();

    int aciertos;
    int errores;
    int numeroDePreguntas;
    String TipoJuego;
    String DificultadJuego;
    String CuentaAtras;
    Configuracion Conf ;
    boolean PuedoPulsar = true;
    // Cronómetro de la aplicación.
    private CountDownTimer timer;

    //Controles de la aplicacion
    TextView txtViev_Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_juego_autor);

            reiniciaJuego();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void reiniciaJuego(){

        try {

            PreparaTablero();

            SiguientePregunta();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PreparaTablero(){


        //cargo los controles
        txtViev_Timer = (TextView) findViewById(R.id.txtVievTimer);

        Util utilidades = new Util();

        //inicializamos variables de configuracion
        Conf = utilidades.RecuperaConfiguracion(this);

        //inicializa varible generales del juego
        aciertos = 0;
        errores  = 0;
        indiceActual = 0;
        numeroDePreguntas = Conf.getPreguntas();
        TipoJuego = Conf.getTipo();
        DificultadJuego = Conf.getDificultad();
        CuentaAtras = Conf.getTiempo();

        //cargar un array de TODAS las obras
        CatalogoObras   = CargarObras();
        CatalogoAutores = CargarAutores();
        CatalogoEstilos = CargarEstilos();

        //selecciona aleatoriamente dentro del catalogo de pinturas completo
        listaTemporal = NumeroaAleatoriosSinRepeticion(0,CatalogoObras.size(),numeroDePreguntas,-1);

        //guarda los n obras aleatorias en las obras seleccionadas para preguntar
        for (int i = 0; i < numeroDePreguntas ; i++) {
            ObrasSeleccionadas.add(CatalogoObras.get(listaTemporal.get(i)));
        }

    }

    public void SiguientePregunta(){

        try {

            //comprueba final de fase
            if( (indiceActual) >= numeroDePreguntas){

                Intent tarea = new Intent(this,estadisticasFinales.class);

                tarea.putExtra("aciertos", String.valueOf(aciertos));
                tarea.putExtra("preguntas", String.valueOf(numeroDePreguntas));

                if(CuentaAtras.equals("SI"))timer.cancel();
                startActivity(tarea);

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


                switch (TipoJuego) {
                    case "AUTOR":
                        JuegoxAutor();
                        break;
                    case "TITULO":
                            if(!DificultadJuego.equals("FACIL")){
                                textView_titulo.setText("");
                            }
                        JuegoxTitulo();
                        break;
                    case "ESTILO":
                        JuegoxEstilo();
                        break;

                    default:
                        break;
                }

                //el indice de la pregunta x/total
                TextView textView_estado = (TextView) findViewById(R.id.textView_preguntaActualTotal);
                textView_estado.setText((indiceActual+1) + "/" + numeroDePreguntas);

                if(CuentaAtras.equals("SI")){
                    cuentaatras(11);
                    // Una vez configurado el timer, lo iniciamos.
                    timer.start();
                }else{
                    txtViev_Timer.setText("");
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void  Boton_01 (View v){
        if(PuedoPulsar){
            Button boton1 = (Button)findViewById(R.id.button01);
            CompruebaRespuesta(boton1);
        }

    }
    public void  Boton_02 (View v){
        if(PuedoPulsar) {
            Button boton1 = (Button) findViewById(R.id.button02);
            CompruebaRespuesta(boton1);
        }
    }
    public void  Boton_03 (View v){
        if(PuedoPulsar) {
            Button boton1 = (Button) findViewById(R.id.button03);
            CompruebaRespuesta(boton1);
        }
    }

    public void CompruebaRespuesta(Button BotonSeleccionado){

        String AutorSeleccionado = BotonSeleccionado.getText().toString();
        String Autor_Estilo_Titulo_Real="";

        switch (TipoJuego) {
            case "AUTOR":
                Autor_Estilo_Titulo_Real = ObrasSeleccionadas.get(indiceActual).getAutorNombre();
                break;
            case "TITULO":
                Autor_Estilo_Titulo_Real = ObrasSeleccionadas.get(indiceActual).getTitulo();
                break;
            case "ESTILO":
                Autor_Estilo_Titulo_Real = ObrasSeleccionadas.get(indiceActual).getEstilo();
                break;

            default:
                break;
        }

        PuedoPulsar = false;

        if(CuentaAtras.equals("SI")){
            timer.cancel();
        }

        if (AutorSeleccionado.equals(Autor_Estilo_Titulo_Real)) {
            BotonSeleccionado.setBackgroundColor(ContextCompat.getColor(this, R.color.cellColor256));
            aciertos++;
        }else {
            BotonSeleccionado.setBackgroundColor(ContextCompat.getColor(this, R.color.lightUpRectangle));
            if(CuentaAtras.equals("NO")) Toast.makeText(this, "oohhhh !!!", Toast.LENGTH_SHORT).show();
            errores++;
        }

        delay(1);
    }

    public void JuegoxAutor(){

        Log.d(LOGTAG, "JuegoxAutor");
        //seleciono una triada de autores incluido el correcto, realmente busco solo dos
        //y que sean diferentes del que incluyo dentro del catalogo completo de autores

        int IDAutorReal= ObrasSeleccionadas.get(indiceActual).getIdautor();
        Obra obraSeleccion = ObrasSeleccionadas.get(indiceActual);
        switch (DificultadJuego) {
            case "FACIL":
                listaTemporal=NumeroaAleatoriosSinRepeticionMATRIZ(TipoJuego,obraSeleccion);
                break;

            case "NORMAL":
                listaTemporal=NumeroaAleatoriosSinRepeticion(0,CatalogoAutores.size(),2,IDAutorReal);
                break;

            case "DIFICIL":
                listaTemporal=NumeroaAleatoriosSinRepeticionMATRIZ(TipoJuego,obraSeleccion);
                break;

            default:
                listaTemporal=NumeroaAleatoriosSinRepeticion(0,CatalogoAutores.size(),2,IDAutorReal);
                break;
        }
        listaTemporal = BajaraLista(listaTemporal);



        //Escribe los autores en cada boton
        Button boton01 = (Button) findViewById(R.id.button01);
        boton01.setText(CatalogoAutores.get(listaTemporal.get(0)).getAutor());
        boton01.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));

        Button boton02 = (Button) findViewById(R.id.button02);
        boton02.setText(CatalogoAutores.get(listaTemporal.get(1)).getAutor());
        boton02.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));

        Button boton03 = (Button) findViewById(R.id.button03);
        boton03.setText(CatalogoAutores.get(listaTemporal.get(2)).getAutor());
        boton03.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));
    }

    public void JuegoxEstilo(){

        //seleciono una triada de autores incluido el correcto, realmente busco solo dos
        //y que sean diferentes del que incluyo dentro del catalogo completo de autores
        Obra obraSeleccion = ObrasSeleccionadas.get(indiceActual);
        listaTemporal=NumeroaAleatoriosSinRepeticionMATRIZ(TipoJuego,obraSeleccion);
        listaTemporal = BajaraLista(listaTemporal);

        //Escribe los autores en cada boton
        Button boton01 = (Button) findViewById(R.id.button01);
        boton01.setText(CatalogoEstilos.get(listaTemporal.get(0)).getNombre());
        boton01.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));

        Button boton02 = (Button) findViewById(R.id.button02);
        boton02.setText(CatalogoEstilos.get(listaTemporal.get(1)).getNombre());
        boton02.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));

        Button boton03 = (Button) findViewById(R.id.button03);
        boton03.setText(CatalogoEstilos.get(listaTemporal.get(2)).getNombre());
        boton03.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));
    }

    public void JuegoxTitulo(){

        //seleciono una triada de autores incluido el correcto, realmente busco solo dos
        //y que sean diferentes del que incluyo dentro del catalogo completo de autores
        int iObraReal = ObrasSeleccionadas.get(indiceActual).getId();
        listaTemporal = NumeroaAleatoriosSinRepeticion(0,CatalogoObras.size(),2,iObraReal);
        listaTemporal = BajaraLista(listaTemporal);


        //Escribe los autores en cada boton
        Button boton01 = (Button) findViewById(R.id.button01);
        boton01.setText(CatalogoObras.get(listaTemporal.get(0)).getTitulo());
        boton01.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));

        Button boton02 = (Button) findViewById(R.id.button02);
        boton02.setText(CatalogoObras.get(listaTemporal.get(1)).getTitulo());
        boton02.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));

        Button boton03 = (Button) findViewById(R.id.button03);
        boton03.setText(CatalogoObras.get(listaTemporal.get(2)).getTitulo());
        boton03.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBoton));
    }

    private List<Obra> CargarObras(){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String  consultaSQL;

        consultaSQL   = " SELECT Cuadros.id, Cuadros.titulo, Cuadros.idAutor, Autores.nombre, Cuadros.idEstilo, Estilos.nombre, Cuadros.imagen ";
        consultaSQL  += " FROM (Cuadros INNER JOIN Autores ON Cuadros.idAutor = Autores.id) INNER JOIN Estilos ON Cuadros.idEstilo = Estilos.id ";
        consultaSQL  += " ORDER BY Cuadros.id ";

        Cursor fila = bd.rawQuery(consultaSQL , null);
        List<Obra> CatalogoObrasT =  new ArrayList<>();

            //Nos aseguramos de que existe al menos un registro
            if (fila.moveToFirst()) {

                //Recorremos el cursor hasta que no haya más registros
                do {
                    Obra Obra_item = new Obra();

                    Obra_item.setId(fila.getInt(0));
                    Obra_item.setTitulo(fila.getString(1));
                    Obra_item.setIdautor(fila.getInt(2));
                    Obra_item.setAutorNombre(fila.getString(3));
                    Obra_item.setIdEstilo(fila.getInt(4));
                    Obra_item.setEstilo(fila.getString(5));
                    Obra_item.setImagen(fila.getString(6));


                    CatalogoObrasT.add(Obra_item);

                } while(fila.moveToNext());

            }
            return CatalogoObrasT;
    }

    private List<Autor> CargarAutores(){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String  consultaSQL;

        consultaSQL   = " SELECT Autores.id, Autores.nombre, Estilos.nombre ";
        consultaSQL  += " FROM Autores INNER JOIN Estilos ON Autores.idEstilo = Estilos.Id;";
        consultaSQL  += " ORDER BY Autores.id ";


        Cursor fila = bd.rawQuery(consultaSQL , null);

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

    private List<Estilo> CargarEstilos(){


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String  consultaSQL;

        consultaSQL  = " SELECT Estilos.id, Estilos.nombre, Estilos.descripcion, Estilos.grupo ";
        consultaSQL += " FROM Estilos ;";


        Cursor fila = bd.rawQuery(consultaSQL , null);

        List<Estilo> CatalogoEstilosT = new ArrayList<>();

        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {

            //Recorremos el cursor hasta que no haya más registros
            do {
                Estilo estilo_item = new Estilo();

                estilo_item.setIdEstilo(fila.getInt(0));
                estilo_item.setNombre(fila.getString(1));
                estilo_item.setDescripcion(fila.getString(2));
                estilo_item.setGrupo(fila.getString(3));


                CatalogoEstilosT.add(estilo_item);

            } while(fila.moveToNext());

        }
        return CatalogoEstilosT;
    }

    public List<Integer> NumeroaAleatoriosSinRepeticion (int minValor , int maxValor, int elementosDevueltos, int valorExcluido ) {

        Integer pos;
        List<Integer> listaTemporalTrabajo =  new ArrayList<>();

        if (valorExcluido >=0){
            listaTemporalTrabajo.add(valorExcluido);
        }

        //numeros aleatorios sin repeticion entre 0..n
        for (int i = 0; i < elementosDevueltos ; i++) {
            pos = (int) Math.floor(Math.random() * maxValor );
            while (listaTemporalTrabajo.contains(pos)) {
                pos = (int) Math.floor(Math.random() * maxValor );
            }
            listaTemporalTrabajo.add(pos);
        }


        return listaTemporalTrabajo;

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

    public List<Integer> NumeroaAleatoriosSinRepeticionMATRIZ(String Tipojuego, Obra cObra ) {

        Log.d(LOGTAG, "NumeroaAleatoriosSinRepeticionMATRIZ");
        //recuperar de una matriz de numeros X valores al azar
        Integer pos;
        Integer maxValor=2;
        String  consultaSQL="";
        String GrupooObra="colores";

        for (Estilo item: CatalogoEstilos) {
            if (item.getIdEstilo() == cObra.getIdEstilo()){
                GrupooObra = item.getGrupo();
                break;
            }
        }

        //contine todos los id de autores del mismo estilo pictorico
        List<Integer> listaTemporalSeleccion =  new ArrayList<>();

        //numeros aleatorios sin repeticion entre 0..n de listaTemporalSeleccion
        List<Integer> listaTemporalindices =  new ArrayList<>();

        List<Integer> listaSalida =  new ArrayList<>();

        //cargar el array con diferentes resultados
        switch (Tipojuego) {
            case "AUTOR":
                if(DificultadJuego.equals("FACIL")){
                    consultaSQL   = " SELECT Autores.id FROM Autores WHERE Autores.idEstilo <> " + cObra.getIdEstilo() ;
                    consultaSQL  += " AND Autores.id <> " + cObra.getIdautor();
                    listaSalida.add(cObra.getIdautor());
                }else if (DificultadJuego.equals("DIFICIL")){
                    consultaSQL   = " SELECT Autores.id FROM Autores WHERE Autores.idEstilo = " + cObra.getIdEstilo() ;
                    consultaSQL  += " AND Autores.id <> " + cObra.getIdautor();
                    listaSalida.add(cObra.getIdautor());
                }else if(DificultadJuego.equals("NORMAL")){
                    consultaSQL   = " SELECT Autores.id FROM Autores WHERE Autores.id <> " + cObra.getIdautor();
                    listaSalida.add(cObra.getIdautor());
                }

                break;

            case "ESTILO":
                if(DificultadJuego.equals("FACIL")){
                    consultaSQL   = "  SELECT Estilos.id FROM Estilos WHERE Estilos.grupo <>'" + GrupooObra + "' " ;
                    consultaSQL  += " AND Estilos.id <> " + cObra.getIdEstilo();
                    listaSalida.add(cObra.getIdEstilo());
                }else if (DificultadJuego.equals("DIFICIL")){
                    consultaSQL   = " SELECT Estilos.id FROM Estilos WHERE Estilos.grupo = '" + GrupooObra + "' " ;
                    consultaSQL  += " AND Estilos.id <> " + cObra.getIdEstilo();
                    listaSalida.add(cObra.getIdEstilo());
                }else if(DificultadJuego.equals("NORMAL")){
                    consultaSQL   = " SELECT Estilos.id FROM Estilos WHERE Estilos.id <> " + cObra.getIdEstilo();
                    listaSalida.add(cObra.getIdEstilo());
                }
                break;

        }

        Log.d(LOGTAG, Tipojuego + ": " + consultaSQL);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"BBDD", null, AdminSQLiteOpenHelper.DATABASE_VERSION);

        SQLiteDatabase bd = admin.getReadableDatabase();

        Cursor fila = bd.rawQuery(consultaSQL , null);

        Log.d(LOGTAG, "Fila contador: " + fila.getCount());

        //Nos aseguramos de que existe al menos un registro
        if (fila.moveToFirst()) {
            //Al menos tre autores de este estilo
            Log.d(LOGTAG, "Elemento SQL: " +  fila.getCount());
            if (fila.getCount()>=2){
                //Recorremos el cursor hasta que no haya más registros
                do {
                    listaTemporalSeleccion.add(fila.getInt(0));
                } while (fila.moveToNext());
            }
        }

        Log.d(LOGTAG, Tipojuego + ": listaTemporalindices");
        //numeros aleatorios sin repeticion entre 0..n de listaTemporalSeleccion
        for (int i = 0; i < maxValor ; i++) {
            pos = (int) Math.floor(Math.random() * listaTemporalSeleccion.size() );
            while (listaTemporalindices.contains(pos)) {
                pos = (int) Math.floor(Math.random() * listaTemporalSeleccion.size() );
            }
            listaTemporalindices.add(pos);
        }


        Log.d(LOGTAG, Tipojuego + ": listaSalida");
        for (int k = 0; k < maxValor ; k++) {
            int i = listaTemporalSeleccion.get(listaTemporalindices.get(k));
            listaSalida.add(i);
        }

        Log.d(LOGTAG, Tipojuego + ": return listaSalida");

        fila.close();
        bd.close();
        return listaSalida;

    }

    public void delay(int seconds){
      //  Log.d(LOGTAG, "delay");
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
                        PuedoPulsar = true;
                    }
                }, milliseconds);
            }
        });
    }


    public void cuentaatras(int seconds){

        timer = new CountDownTimer(seconds * 1000, 100) {

            @Override
            public void onTick(long millisUntilFinished) {
             //   Log.d(LOGTAG, "onTick");
                // Este método se lanza por cada lapso de tiempo transcurrido,
                txtViev_Timer.setText(String.valueOf(millisUntilFinished / 1000));
                if((millisUntilFinished / 1000)<=3){
                    txtViev_Timer.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.lightUpRectangle));
                }else{
                    txtViev_Timer.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorAccent));
                }
            }

            @Override
            public void onFinish() {
                //txtViev_Timer.setText("FIN TIEMPO");
                //nueva pregunta
                timer.cancel();
                delay(1);
            }
        };

    }
}
