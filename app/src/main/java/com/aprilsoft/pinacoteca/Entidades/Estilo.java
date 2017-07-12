package com.aprilsoft.pinacoteca.Entidades;

/**
 * Created by palgaba on 10/07/2017.
 */

public class Estilo {

    private int IdEstilo;
    private String nombre;
    private String descripcion;
    private String grupo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Estilo() {
    }

    public int getIdEstilo() {
        return IdEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        IdEstilo = idEstilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombnre) {
        this.nombre = nombnre;
    }

}
