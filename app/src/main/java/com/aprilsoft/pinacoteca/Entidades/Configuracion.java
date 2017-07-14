package com.aprilsoft.pinacoteca.Entidades;

/**
 * Created by palgaba on 30/06/2017.
 */

public class Configuracion {

    private int id;
    private int Preguntas;
    private String dificultad;
    private String tiempo;
    private String tipo;
    private String animacion;
    public String getAnimacion() {
        return animacion;
    }

    public void setAnimacion(String animacion) {
        this.animacion = animacion;
    }



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

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}
