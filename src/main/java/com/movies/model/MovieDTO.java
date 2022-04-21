package com.movies.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MovieDTO implements Serializable {
    // En principio estamos trabajando solo con una entidad, quedaria la clase igual


    // NotBlanck The string is not null and the length is greater than zero.
    @NotBlank
    private String title;

    @NotBlank
    private String gender;

    @Min(1800)
    private int year;

    private int numOscar;

    @NotBlank
    private String actors;

    public MovieDTO(){

    }

    public MovieDTO(String title, String gender, int year, int numOscar, String actors) {
        this.title = title;
        this.gender = gender;
        this.year = year;
        this.numOscar = numOscar;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
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
        return "MovieDTO{" +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", numOscar=" + numOscar +
                ", actors='" + actors + '\'' +
                '}';
    }
}
