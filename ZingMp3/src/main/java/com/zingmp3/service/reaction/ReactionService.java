package com.zingmp3.service.reaction;

import com.zingmp3.model.Reaction;
import com.zingmp3.repository.IReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReactionService implements IReactionService{
    @Autowired
    IReactionRepository reactionRepository;
    @Override
    public Iterable<Reaction> findAll() {
        return reactionRepository.findAll();
    }

    @Override
    public Optional<Reaction> findById(Long id) {
        return reactionRepository.findById(id);
    }

    @Override
    public Reaction save(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public void delete(Long id) {
        reactionRepository.deleteById(id);
    }
}
