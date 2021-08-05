package com.zingmp3.service.playlist;

import com.zingmp3.model.Playlist;
import com.zingmp3.service.IGeneralService;

public interface IPlaylistService extends IGeneralService<Playlist> {
    Playlist findByName(String name);
}
