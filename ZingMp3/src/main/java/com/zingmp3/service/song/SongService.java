package com.zingmp3.service.song;

import com.zingmp3.model.Song;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SongService implements ISongService{
    @Autowired
    private  ISongService songService;
    @Override
    public Iterable<Song> findAll() {
        return songService.findAll() ;
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songService.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songService.save(song);
    }

    @Override
    public void delete(Long id) {
        songService.delete(id);

    }

    @Override
    public Song findByName(String name) {
        return songService.findByName(name);
    }
}
