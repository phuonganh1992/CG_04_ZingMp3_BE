package com.zingmp3.controller;

import com.zingmp3.model.Reaction;
import com.zingmp3.service.reaction.IReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reactions")
public class ReactionController {
    @Autowired
    IReactionService reactionService;

    @GetMapping
    public ResponseEntity<Iterable<Reaction>> getListReaction() {
        return new ResponseEntity<>(reactionService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reaction> createReaction(@RequestBody Reaction reaction) {
        return new ResponseEntity<>(reactionService.save(reaction), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reaction> findById(@PathVariable Long id) {
        Optional<Reaction> reactionOptional = reactionService.findById(id);
        if (!reactionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reactionOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reaction> editReaction(@PathVariable Long id, @RequestBody Reaction reaction) {
        Optional<Reaction> reactionOptional = reactionService.findById(id);
        if (!reactionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        reactionService.save(reaction);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reaction> deleteReaction(@PathVariable Long id) {
        Optional<Reaction> reactionOptional = reactionService.findById(id);
        if (!reactionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        reactionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
