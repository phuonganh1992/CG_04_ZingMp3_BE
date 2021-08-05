package com.zingmp3.repository;

import com.zingmp3.model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song,Long> {
   Optional<Song> findByName(String songname);
}
