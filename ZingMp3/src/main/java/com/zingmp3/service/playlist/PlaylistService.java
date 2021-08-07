package com.zingmp3.service.playlist;

import com.zingmp3.model.Playlist;
import com.zingmp3.repository.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private IPlaylistRepository playlistRepository;


    @Override
    public Iterable<Playlist> findAll() {


        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }


    @Override
    public Iterable<Playlist> findByNameContaining(String name) {
        return playlistRepository.findByNameContaining(name);
    }
}
