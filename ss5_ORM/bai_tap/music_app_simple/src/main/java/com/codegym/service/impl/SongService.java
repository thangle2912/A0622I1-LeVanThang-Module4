package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public boolean save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public boolean update(Song song) {
        return songRepository.update(song);
    }

    @Override
    public boolean remove(Song song) {
         return songRepository.remove(song);
    }
}
