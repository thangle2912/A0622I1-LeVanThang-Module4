package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
    @Id //Xác định khoá chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto
    private int id;
    private String name;
    private String musicGenre;
    private String filePath;

    public Song() {
    }

    public Song(int id, String name, String musicGenre, String filePath) {
        this.id = id;
        this.name = name;
        this.musicGenre = musicGenre;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
