package com.zingmp3.service.playlist;

import com.zingmp3.model.Playlist;
import com.zingmp3.model.Role;
import com.zingmp3.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private IPlaylistService playlistService;

    @Override
    public Iterable<Playlist> findAll() {
        return playlistService.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistService.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistService.save(playlist);
    }

    @Override
    public void delete(Long id) {
        playlistService.delete(id);
    }

    @Override
    public Playlist findByName(String name) {
        return playlistService.findByName(name);
    }
}
