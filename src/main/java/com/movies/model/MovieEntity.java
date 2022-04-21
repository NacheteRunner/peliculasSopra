package com.movies.model;

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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "numOscar", nullable = true)
    private int numOscar;

    @Column(name = "actors", nullable = false)
    private String actors;

    public MovieEntity(){

    }

    public MovieEntity(String title, String gender, int year, int numOscar, String actors) {
        this.title = title;
        this.gender = gender;
        this.year = year;
        this.numOscar = numOscar;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumOscar() {
        return numOscar;
    }

    public void setNumOscar(int numOscar) {
        this.numOscar = numOscar;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", numOscar=" + numOscar +
                ", actors='" + actors + '\'' +
                '}';
    }
}

