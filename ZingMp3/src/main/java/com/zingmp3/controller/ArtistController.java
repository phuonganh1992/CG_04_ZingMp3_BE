package com.zingmp3.controller;

import com.zingmp3.model.Artist;
import com.zingmp3.service.artist.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/artist")
public class ArtistController {
    @Autowired
    private IArtistService artistService;

    @GetMapping
    public ResponseEntity<Iterable<Artist>> findAllArtist() {
        List<Artist> artistList = (List<Artist>) artistService.findAll();
        if (artistList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(artistList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> findArtistById(@PathVariable Long id) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artistOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> saveArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.save(artist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Optional<Artist> artistOptional = artistService.findById(id);
        if (!artistOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        artist.setId(artistOptional.get().getId());
        return new ResponseEntity<>(artistService.save(artist), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Artist>deleteArtist(@PathVariable Long id){
        Optional<Artist>artistOptional=artistService.findById(id);
        if(!artistOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        artistService.delete(id);
        return new ResponseEntity<>(artistOptional.get(),HttpStatus.NO_CONTENT);
    }

    @PostMapping("/search")
    public ResponseEntity<Iterable<Artist>>searchArtist(@RequestParam String name){
List<Artist> artists= (List<Artist>) artistService.findAllByName(name);
if(artists.isEmpty()){
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
return new ResponseEntity<>(artists,HttpStatus.OK);
    }
}
