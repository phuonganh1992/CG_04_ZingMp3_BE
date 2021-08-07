package com.zingmp3.repository;

import com.zingmp3.model.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IArtistRepository extends PagingAndSortingRepository<Artist,Long> {
    Iterable<Artist> findAllByNameContaining(String name);
}
