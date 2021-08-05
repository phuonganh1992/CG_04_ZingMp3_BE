package com.zingmp3.service.song;
import com.zingmp3.model.Song;
import com.zingmp3.service.IGeneralService;

public interface ISongService extends IGeneralService<Song> {
    Song findByName(String name);
}
