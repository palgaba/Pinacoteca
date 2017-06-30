package com.aprilsoft.pinacoteca.Entidades;

/**
 * Created by palgaba on 30/06/2017.
 */

public class Configuracion {

    private int id;
    private int Preguntas;
    private String dificultad;
    private String opcion1;
    private String opcion2;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreguntas() {
        return Preguntas;
    }

    public void setPreguntas(int preguntas) {
        Preguntas = preguntas;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }



}
