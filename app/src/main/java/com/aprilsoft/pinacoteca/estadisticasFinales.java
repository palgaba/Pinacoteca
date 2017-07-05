package com.aprilsoft.pinacoteca;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class estadisticasFinales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_finales);

        //paso de parametros
        Intent tarea =getIntent();
        String Aciertos=tarea.getStringExtra("aciertos");
        String preguntas=tarea.getStringExtra("preguntas");

        RatingBar mi_rating = (RatingBar) findViewById(R.id.mi_rating);
        TextView textView_estado = (TextView) findViewById(R.id.textView_final);

        float PorcentaAcierto = 0;
        PorcentaAcierto = ((Integer.parseInt(Aciertos)*100)/Integer.parseInt(preguntas));
        mi_rating.setNumStars(5);
        mi_rating.setStepSize(1/10);
        PorcentaAcierto=(PorcentaAcierto*5)/100;

        String msg = Aciertos + " " + getResources().getString(R.string.Idioma_resultados);

        textView_estado.setText(msg);

        ObjectAnimator anim = ObjectAnimator.ofFloat(mi_rating, "rating", 0, PorcentaAcierto);
        anim.setDuration(1000);
        anim.start();

    }


    public void button_volver (View v){
        Intent tarea= new Intent(this,MainActivity.class);
        tarea.putExtra("reinicio", "param2");
        startActivity(tarea);


    }
}
