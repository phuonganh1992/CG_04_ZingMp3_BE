package com.zingmp3.repository;

import com.zingmp3.model.Playlist;
import com.zingmp3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository<Role,Long> {
    Playlist findByName(String name);
}
