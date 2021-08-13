package com.zingmp3.service.song;

import com.zingmp3.model.Song;
import com.zingmp3.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Iterable<Song> findByName(String name) {
        return songRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Song> findAllByNameContaining(String name) {
        return songRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Song> findAll(Sort sort) {
        return songRepository.findAll(sort);
    }

    @Override
    public Iterable<Song> findAllByArtist_id(Long id) {
        return songRepository.findAllByArtist_id(id);
    }
}
