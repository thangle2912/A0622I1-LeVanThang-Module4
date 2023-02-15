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
    private String singer;
    private String musicGenre;
    private String filePath;

    public Song() {
    }

    public Song(int id, String singer, String musicGenre, String filePath) {
        this.id = id;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
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
