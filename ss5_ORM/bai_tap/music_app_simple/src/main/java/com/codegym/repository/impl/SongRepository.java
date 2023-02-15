package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        TypedQuery<Song> query = entityManager.createQuery("select s from Song as s",Song.class);
        songList = query.getResultList();
        return songList;
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class,id);
    }

    @Transactional
    @Override
    public boolean save(Song song) {
        entityManager.persist(song);
        return true;
    }
    @Transactional
    @Override
    public boolean update(Song song) {
        Song songUpdate = findById(song.getId());
        songUpdate.setName(song.getName());
        songUpdate.setMusicGenre(song.getMusicGenre());
        songUpdate.setFilePath(song.getFilePath());

        return true;
    }
    @Transactional
    @Override
    public boolean remove(Song song) {
        Song songDelete = findById(song.getId());
       entityManager.remove(songDelete);
            return true;

    }
}
