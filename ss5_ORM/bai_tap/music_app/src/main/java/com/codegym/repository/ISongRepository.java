package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void update(Song song);
    void remove(Song song);
}
