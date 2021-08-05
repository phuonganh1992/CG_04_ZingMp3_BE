package com.zingmp3.service.artist;

import com.zingmp3.model.Artist;
import com.zingmp3.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistService implements IArtistService {
    @Autowired
    private IArtistRepository artistRepository;
    @Override
    public Iterable<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void delete(Long id) {
artistRepository.deleteById(id);
    }

    @Override
    public Iterable<Artist> findAllByName(String name) {
        return artistRepository.findAllByNameContaining(name);
    }
}
