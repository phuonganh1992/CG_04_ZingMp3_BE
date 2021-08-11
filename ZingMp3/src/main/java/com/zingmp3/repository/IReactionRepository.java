package com.zingmp3.repository;

import com.zingmp3.model.Reaction;
import com.zingmp3.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReactionRepository extends JpaRepository<Reaction,Long> {
    Iterable<Reaction> findAllBySong(Song song);
}
