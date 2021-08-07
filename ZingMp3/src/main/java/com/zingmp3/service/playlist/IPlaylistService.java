package com.zingmp3.service.playlist;

import com.zingmp3.model.Playlist;
import com.zingmp3.service.IGeneralService;

import java.util.Optional;

public interface IPlaylistService extends IGeneralService<Playlist> {
    Iterable<Playlist> findByNameContaining(String name);
}
