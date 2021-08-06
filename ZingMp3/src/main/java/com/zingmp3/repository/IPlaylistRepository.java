package com.zingmp3.repository;

import com.zingmp3.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Long> {
    Iterable<Playlist> findByNameContaining(String name);
}
