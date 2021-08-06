package com.zingmp3.service.song;
import com.zingmp3.model.Song;
import com.zingmp3.service.IGeneralService;

public interface ISongService extends IGeneralService<Song> {
    Iterable<Song> findByName(String name);
    Iterable<Song> findAllByNameContaining(String name);
}
