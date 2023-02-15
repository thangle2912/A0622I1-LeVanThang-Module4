package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        List<Song> songList = new ArrayList<>();
        TypedQuery<Song> query = entityManager.createQuery("from Music", Song.class);
        songList = query.getResultList();
        return songList;
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class,id);
    }

    @Override
    public void save(Song song) {
        entityManager.persist(song);
    }

    @Override
    public void update(Song song) {
        Song songUpdate = findById(song.getId());
        songUpdate.setSinger(song.getSinger());
        songUpdate.setMusicGenre(song.getMusicGenre());
        songUpdate.setFilePath(song.getFilePath());
    }

    @Override
    public void remove(Song song) {
        Song songDelete = findById(song.getId());
        entityManager.remove(songDelete);
    }
}
