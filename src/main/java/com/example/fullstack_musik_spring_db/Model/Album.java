package com.example.fullstack_musik_spring_db.Model;

import java.time.LocalDate;

public class Album {
    private int id;
    private String title;
    private String artist;
    private String tracks;
    private LocalDate releaseDate;
    private String company;

    public Album() {

    }
    public Album(int id, String title, String artist, String tracks, LocalDate releaseDate,String company) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.releaseDate = releaseDate;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTracks() {
        return tracks;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
