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
    ISongRepository musicRepository;

    @Override
    public List<Song> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        musicRepository.save(song);
    }

    @Override
    public void update(Song song) {
        musicRepository.update(song);
    }

    @Override
    public void remove(Song song) {
        musicRepository.remove(song);
    }
}
