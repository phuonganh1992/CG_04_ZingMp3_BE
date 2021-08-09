package com.zingmp3.repository;

import com.zingmp3.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReactionRepository extends JpaRepository<Reaction,Long> {

}
