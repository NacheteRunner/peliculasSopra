package com.movies.model;

public class MovieResponse {

    private int id;

    private String title;

    private String gender;

    private int year;

    private int numOscar;

    private String actors;

    public MovieResponse(){

    }

    public MovieResponse(String title, String gender, int year, int numOscar, String actors) {
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
        return "MovieResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", numOscar=" + numOscar +
                ", actors='" + actors + '\'' +
                '}';
    }
}
