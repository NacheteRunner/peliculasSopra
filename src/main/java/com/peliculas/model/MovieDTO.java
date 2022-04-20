package com.peliculas.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MovieDTO implements Serializable {
    // En principio estamos trabajando solo con una entidad, quedaria la clase igual


    @NotEmpty
    @NotBlank
    private String titulo;

    @NotEmpty
    @NotBlank
    private String genero;

    @NotNull
    @Min(1800)
    private int anno;

    private int numOscar;

    @NotEmpty
    @NotBlank
    private String actores;

    public MovieDTO(){

    }

    public MovieDTO(String titulo, String genero, int anno, int numOscar, String actores) {
        this.titulo = titulo;
        this.genero = genero;
        this.anno = anno;
        this.numOscar = numOscar;
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

    public int getnumOscar() {
        return numOscar;
    }

    public void setnumOscar(int numOscar) {
        this.numOscar = numOscar;
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
                ", numOscar=" + numOscar +
                ", actores='" + actores + '\'' +
                '}';
    }
}
