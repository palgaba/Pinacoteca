package com.aprilsoft.pinacoteca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.aprilsoft.pinacoteca.Entidades.Configuracion;
import com.aprilsoft.pinacoteca.Entidades.Estilo;

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

        //controles
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarConf);
        txt_preguntas = (TextView)findViewById(R.id.textView_preguntas);
        Edit_Preguntas = (EditText) findViewById(R.id.editText_numeroPreguntas);
        txt_dificultad = (TextView)findViewById(R.id.textView_dificultad);
        seekBar_dificultad = (SeekBar)findViewById(R.id.seekBar_dificultad);
        txt_tiempo = (TextView)findViewById(R.id.textView_tiempo);
        Switch_tiempo = (Switch) findViewById(R.id.switch1);
        txt_tipo = (TextView)findViewById(R.id.textView_tipo);
        seekBar_tipo = (SeekBar)findViewById(R.id.seekBar2);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //recupero la configuracion
        final Util Utilidades = new Util();
        Conf = Utilidades.RecuperaConfiguracion(getBaseContext());

        //******************************************
        //* Asignar la configuracion a los controles
        //******************************************

        //Numero de preguntas
        Edit_Preguntas.setText(String.valueOf(Conf.getPreguntas()));
        // SeekBar DIFICULTAD
        switch (Conf.getDificultad().toUpperCase()) {
            case "FACIL":
                seekBar_dificultad.setProgress(0);//cuadro + sin especificar estilo
                txt_dificultad.setText( R.string.Idioma_DIFICULTAD_Facil);
                break;
            case "NORMAL":
                seekBar_dificultad.setProgress(1);//cuadro + el mismo estilo pictorico
                txt_dificultad.setText( R.string.Idioma_DIFICULTAD_Normal);
                break;
            case "DIFICIL":
                seekBar_dificultad.setProgress(2); // solo titulo + el mismo estilo pictorico
                txt_dificultad.setText(R.string.Idioma_DIFICULTAD_Dificil);
                break;

        }
        // Switch TIEMPO
        if(Conf.getTiempo().toUpperCase().equals("SI")){
            Switch_tiempo.setChecked(true);
            Switch_tiempo.setText(R.string.Idioma_SI);
        }else{
            Switch_tiempo.setChecked(false);
            Switch_tiempo.setText(R.string.Idioma_NO);
        }
        // SeekBar TIPO
        switch (Conf.getTipo().toUpperCase()) {
            case "AUTOR":
                seekBar_tipo.setProgress(0);
                txt_tipo.setText(R.string.Idioma_TIPO_Autor);
                break;
            case "TITULO":
                seekBar_tipo.setProgress(1);
                txt_tipo.setText(R.string.Idioma_TIPO_Titulo);
                break;
            case "ESTILO":
                seekBar_tipo.setProgress(2);
                txt_tipo.setText(R.string.Idioma_TIPO_Estilo);;
                break;

        }

        //************
        //* Listener *
        //************
        Edit_Preguntas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //no puede ser superior al tamaño de la obra
                String texto = Edit_Preguntas.getText().toString();
                if(texto.equals("")) texto ="0";

                int number = Integer.valueOf(texto);
                if(number > 50) number = 50; //tamaño de l
                // a obra

                Conf.setPreguntas(number);
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
                            case 0:
                                Salida = "FACIL";//cuadro + sin especificar estilo
                                txt_dificultad.setText(R.string.Idioma_DIFICULTAD_Facil);
                                break;
                            case 1:
                                Salida = "NORMAL";//cuadro + el mismo estilo pictorico
                                txt_dificultad.setText(R.string.Idioma_DIFICULTAD_Normal);
                                break;
                            case 2:
                                Salida = "DIFICIL"; // solo titulo + el mismo estilo pictorico
                                txt_dificultad.setText(R.string.Idioma_DIFICULTAD_Dificil);
                                break;
                            default:
                                Salida = "INVALIDO";
                                txt_dificultad.setText(R.string.Idioma_Invalido);
                                break;
                        }
                        Conf.setDificultad(Salida);
                        if (!Utilidades.GuardarConfiguracion(Conf,getBaseContext())){
                            txt_dificultad.setText(R.string.Idioma_Error);
                        }
                    }

                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        Switch_tiempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    Switch_tiempo.setText(R.string.Idioma_SI);
                    Conf.setTiempo("SI");
                }else{
                    Switch_tiempo.setText(R.string.Idioma_NO);
                    Conf.setTiempo("NO");
                }

                Utilidades.GuardarConfiguracion(Conf,getBaseContext());

            }
        });




        seekBar_tipo.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser) {
                        String Salida;
                        switch (progress) {
                            case 0:
                                Salida = "AUTOR";
                                txt_tipo.setText(R.string.Idioma_TIPO_Autor);
                                break;
                            case 1:
                                Salida = "TITULO";
                                txt_tipo.setText(R.string.Idioma_TIPO_Titulo);
                                break;
                            case 2:
                                Salida = "ESTILO";
                                txt_tipo.setText(R.string.Idioma_TIPO_Estilo);
                                break;

                            default:
                                Salida = "INVALIDO";
                                txt_tipo.setText(R.string.Idioma_Invalido);
                                break;
                        }
                        Conf.setTipo(Salida);
                        if (!Utilidades.GuardarConfiguracion(Conf,getBaseContext())){
                            txt_tipo.setText(R.string.Idioma_Error);
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


    public void CatalogoEstadisticas (View v){
        Intent tarea= new Intent(this,CatalogoActivity.class);
        startActivity(tarea);
    }

    public void EstiloEstadisticas (View v){
        Intent tarea= new Intent(this,Estilos.class);
        startActivity(tarea);
    }

}