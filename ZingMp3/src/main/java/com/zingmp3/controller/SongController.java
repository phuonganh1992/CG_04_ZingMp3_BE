package com.zingmp3.controller;

import com.zingmp3.model.Song;
import com.zingmp3.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SongController {
  @Autowired
  ISongService songService;

    @GetMapping("/songs")
    public ResponseEntity<Iterable<Song>> findAllSong() {
        Iterable<Song> songs = songService.findAll();
        return new ResponseEntity(songs, HttpStatus.OK);
    }

    @PostMapping("/songs")
    public ResponseEntity<Void> create(@RequestBody Song song) {
        songService.save(song);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> findOne(@PathVariable Long id) {
        return new ResponseEntity(songService.findById(id).get(), HttpStatus.OK);

    }
    @PutMapping("/songs/{id}")
    public ResponseEntity<Void> create(@PathVariable Long id,@RequestBody Song song) {
        Optional<Song> songOptional = songService.findById(id);
        if (!songOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        song.setId(id);
        songService.save(song);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/songs/{id}")
    public ResponseEntity<Song>deleteSong(@PathVariable Long id){
        Optional<Song> songOptional = songService.findById(id);
        if(!songOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<>(songOptional.get(),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Song>> searchName(@RequestParam String name) {
        Iterable<Song> songs = songService.findAllByNameContaining(name);
        return new ResponseEntity(songs, HttpStatus.OK);
    }

}
