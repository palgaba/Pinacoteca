package com.aprilsoft.pinacoteca.Entidades;

/**
 * Created by palgaba on 30/06/2017.
 */

public class Obra {
    private int Id;
    private int idautor;
    private int IdEstilo;
    private String titulo;
    private String autorNombre;
    private String estilo;
    private String imagen;

    public int getIdEstilo() {
        return IdEstilo;
    }
    public void setIdEstilo(int idEstilo) {
        IdEstilo = idEstilo;
    }

    public int getIdautor() {
        return idautor;
    }
    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
