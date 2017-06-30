package com.aprilsoft.pinacoteca.Entidades;

/**
 * Created by palgaba on 30/06/2017.
 */

public class Autor {
    private String nombre;
    private int identificador;
    private String estilo;


    public Autor() {
    }

    public Autor( String autor, int identificador, String estilo) {
        this.nombre = autor;
        this.identificador = identificador;
        this.estilo = estilo;
    }

    public String getAutor() {
        return nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getEstilo() {
        return estilo;
    }


    public void setAutor(String autor) {
        this.nombre = autor;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

}