package com.peliculas.modelo;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PeliculaDTO implements Serializable {
    // En principio estamos trabajando solo con una entidad, quedaria la clase igual


    @NotEmpty
    private String titulo;
    @NotEmpty
    private String genero;
    @NotEmpty
    private int anno;

    private int num_oscar;
    @NotEmpty
    private String actores;

    public PeliculaDTO(){

    }

    public PeliculaDTO(String titulo, String genero, int anno, int num_oscar, String actores) {
        this.titulo = titulo;
        this.genero = genero;
        this.anno = anno;
        this.num_oscar = num_oscar;
        this.actores = actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getNum_oscar() {
        return num_oscar;
    }

    public void setNum_oscar(int num_oscar) {
        this.num_oscar = num_oscar;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "PeliculaDTO{" +
                //"id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", anno=" + anno +
                ", num_oscar=" + num_oscar +
                ", actores='" + actores + '\'' +
                '}';
    }
}
