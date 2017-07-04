package com.aprilsoft.pinacoteca;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aprilsoft.pinacoteca.Entidades.Configuracion;

/**
 * Created by palgaba on 04/07/2017.
 */

public class ConfiguracionActivity extends AppCompatActivity {
    TextView txt_preguntas;
    TextView txt_dificultad;
    TextView txt_tiempo;
    TextView txt_tipo;
    TextView txt_About;

    Configuracion Conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        Util Utilidades = new Util();

        Conf = Utilidades.RecuperaConfiguracion(getBaseContext());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarConf);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_preguntas = (TextView)findViewById(R.id.textView_preguntas);
        txt_dificultad = (TextView)findViewById(R.id.textView_dificultad);
        txt_tiempo = (TextView)findViewById(R.id.textView_tiempo);
        txt_tipo = (TextView)findViewById(R.id.textView_tipo);

        txt_preguntas.setText( String.valueOf(Conf.getPreguntas()));
        txt_dificultad.setText(Conf.getDificultad());
        txt_tipo.setText(Conf.getTiempo() );


        // SeekBar
//        SeekBar seekBar_dificultad = (SeekBar)findViewById(R.id.seekBar_dificultad);
//        SeekBar seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        // Valor Inicial
//        seekBar_dificultad.setProgress(0);
//        seekBar2.setProgress(0);
//        // Valot Final
//        seekBar_dificultad.setMax(2);
//        seekBar2.setMax(2);
//
//        seekBar_dificultad.setOnSeekBarChangeListener(
//                new SeekBar.OnSeekBarChangeListener() {
//                    //hace un llamado a la perilla cuando se arrastra
//                    @Override
//                    public void onProgressChanged(SeekBar seekBar,
//                                                  int progress, boolean fromUser) {
//                        String Salida;
//                        switch (progress) {
//                            case 0:  Salida = "Facil";//cuadro + sin especificar estilo
//                                break;
//                            case 1:  Salida = "Medio";//cuadro + el mismo estilo pictorico
//                                break;
//                            case 2:  Salida = "Dificil"; // solo titulo + el mismo estilo pictorico
//                                break;
//                            default: Salida = "Invalid ";
//                                break;
//                        }
//                        mostrar_dificultad.setText("DIFICULTAD " + Salida);
//                    }
//
//                    //hace un llamado  cuando se toca la perilla
//                    public void onStartTrackingTouch(SeekBar seekBar) {
//                    }
//
//                    //hace un llamado  cuando se detiene la perilla
//                    public void onStopTrackingTouch(SeekBar seekBar) {
//                    }
//                });
//

//        seekBar2.setOnSeekBarChangeListener(
//                new SeekBar.OnSeekBarChangeListener() {
//                    //hace un llamado a la perilla cuando se arrastra
//                    @Override
//                    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser) {
//                        String Salida;
//                        switch (progress) {
//                            case 0:  Salida = "Por Autor";
//                                break;
//                            case 1:  Salida = "Por Titulo";
//                                break;
//                            default: Salida = "Invalid ";
//                                break;
//                        }
//                        mostrar_tipo.setText("TIPO " + Salida);
//                    }
//
//                    //hace un llamado  cuando se toca la perilla
//                    public void onStartTrackingTouch(SeekBar seekBar) {
//                    }
//
//                    //hace un llamado  cuando se detiene la perilla
//                    public void onStopTrackingTouch(SeekBar seekBar) {
//                    }
//                });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

    }
}