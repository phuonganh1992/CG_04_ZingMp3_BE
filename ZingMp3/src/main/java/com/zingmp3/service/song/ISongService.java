package com.zingmp3.service.song;
import com.zingmp3.model.Song;
import com.zingmp3.service.IGeneralService;
import org.springframework.data.domain.Sort;

public interface ISongService extends IGeneralService<Song> {
    Iterable<Song> findByName(String name);
    Iterable<Song> findAllByNameContaining(String name);
    Iterable<Song> findAll(Sort sort);
    Iterable<Song>findAllByArtist_id(Long id);
}
