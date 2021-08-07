package com.zingmp3.service.artist;

import com.zingmp3.model.Artist;
import com.zingmp3.service.IGeneralService;

import java.util.Optional;

public interface IArtistService extends IGeneralService<Artist> {
    Iterable<Artist> findAllByName(String name);
}
