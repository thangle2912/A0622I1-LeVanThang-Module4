package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    Song findById(int id);
    boolean save(Song song);
    boolean update(Song song);
    boolean remove(Song song);
}
