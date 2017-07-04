package com.aprilsoft.pinacoteca;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
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
    EditText Edit_Preguntas;

    SeekBar seekBar_dificultad;
    SeekBar seekBar_tipo;
    Switch Switch_tiempo;

    Configuracion Conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        final Util Utilidades = new Util();

        Conf = Utilidades.RecuperaConfiguracion(getBaseContext());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarConf);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_preguntas = (TextView)findViewById(R.id.textView_preguntas);
        txt_dificultad = (TextView)findViewById(R.id.textView_dificultad);
        txt_tiempo = (TextView)findViewById(R.id.textView_tiempo);
        txt_tipo = (TextView)findViewById(R.id.textView_tipo);

        Edit_Preguntas = (EditText) findViewById(R.id.editText_numeroPreguntas);

        Edit_Preguntas.setText(String.valueOf(Conf.getPreguntas()));
        txt_dificultad.setText(Conf.getDificultad());
        txt_tipo.setText("Buscar por " + Conf.getTipo());


        // SeekBar DIFICULTAD
        seekBar_dificultad = (SeekBar)findViewById(R.id.seekBar_dificultad);
        txt_dificultad.setText("DIFICULTAD " + Conf.getDificultad());
        switch (Conf.getDificultad()) {
            case "Facil":  seekBar_dificultad.setProgress(0);//cuadro + sin especificar estilo
                break;
            case "Medio":  seekBar_dificultad.setProgress(1);//cuadro + el mismo estilo pictorico
                break;
            case "Dificil":  seekBar_dificultad.setProgress(2); // solo titulo + el mismo estilo pictorico
                break;

        }

        // SeekBar TIPO
        seekBar_tipo = (SeekBar)findViewById(R.id.seekBar2);
        txt_tipo.setText("Buscar por " + Conf.getTipo());
        switch (Conf.getTipo()) {
            case "autor":  seekBar_tipo.setProgress(0);//cuadro + sin especificar estilo
                break;
            case "titulo":  seekBar_tipo.setProgress(1);//cuadro + el mismo estilo pictorico
                break;
            case "estilo":  seekBar_tipo.setProgress(2); // solo titulo + el mismo estilo pictorico
                break;

        }

        // initiate a Switch
        Switch_tiempo = (Switch) findViewById(R.id.switch1);

        // check current state of a Switch (true or false).
        if(Conf.getTiempo().toUpperCase().equals("SI")){
            Switch_tiempo.setChecked(true);
            Switch_tiempo.setText("SI");
        }else{
            Switch_tiempo.setChecked(false);
            Switch_tiempo.setText("NO");
        }


        Switch_tiempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    Switch_tiempo.setText("SI");
                    Conf.setTiempo("SI");
                }else{
                    Switch_tiempo.setText("NO");
                    Conf.setTiempo("NO");
                }

                Utilidades.GuardarConfiguracion(Conf,getBaseContext());

            }
        });



        seekBar_dificultad.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser) {
                        String Salida;
                        switch (progress) {
                            case 0:  Salida = "Facil";//cuadro + sin especificar estilo
                                break;
                            case 1:  Salida = "Medio";//cuadro + el mismo estilo pictorico
                                break;
                            case 2:  Salida = "Dificil"; // solo titulo + el mismo estilo pictorico
                                break;
                            default: Salida = "Invalid ";
                                break;
                        }
                        Conf.setDificultad(Salida);
                        if (Utilidades.GuardarConfiguracion(Conf,getBaseContext())){
                            txt_dificultad.setText("DIFICULTAD " + Salida);
                        }else{
                            txt_dificultad.setText("DIFICULTAD Error");
                        }
                    }

                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        seekBar_tipo.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser) {
                        String Salida;
                        switch (progress) {
                            case 0:  Salida = "autor";
                                break;
                            case 1:  Salida = "titulo";
                                break;
                            case 2:  Salida = "estilo";
                                break;

                            default: Salida = "Invalid ";
                                break;
                        }
                        Conf.setTipo(Salida);
                        if (Utilidades.GuardarConfiguracion(Conf,getBaseContext())){
                            txt_tipo.setText("BUSCAR POR por " + Salida);
                        }else{
                            txt_tipo.setText("Buscar Error");
                        }

                    }

                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

    }


}