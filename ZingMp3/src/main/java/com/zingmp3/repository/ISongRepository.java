package com.zingmp3.repository;

import com.zingmp3.model.Song;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song,Long> {
   Iterable<Song> findAllByNameContaining(String name);
//  List<Song> findAll(Sort sort);
}
