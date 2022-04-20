package com.peliculas.model;

import javax.persistence.*;

@Entity
@Table(name="peliculasDB")
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j*/
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "anno", nullable = false)
    private int anno;

    @Column(name = "numOscar", nullable = true)
    private int numOscar;

    @Column(name = "actores", nullable = false)
    private String actores;

    public MovieEntity(){

    }

    public MovieEntity(String titulo, String genero, int anno, int numOscar, String actores) {
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
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", anno=" + anno +
                ", numOscar=" + numOscar +
                ", actores='" + actores + '\'' +
                '}';
    }
}

