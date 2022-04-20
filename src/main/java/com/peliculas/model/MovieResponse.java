package com.peliculas.model;

public class MovieResponse {

    private int id;

    private String titulo;

    private String genero;

    private int anno;

    private int numOscar;

    private String actores;

    public MovieResponse(){

    }

    public MovieResponse(String titulo, String genero, int anno, int numOscar, String actores) {
        this.titulo = titulo;
        this.genero = genero;
        this.anno = anno;
        this.numOscar = numOscar;
        this.actores = actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "PeliculaResponse{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", anno=" + anno +
                ", numOscar=" + numOscar +
                ", actores='" + actores + '\'' +
                '}';
    }
}
