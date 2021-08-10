package com.zingmp3.controller;

import com.zingmp3.model.Playlist;
import com.zingmp3.service.playlist.IPlaylistService;
import com.zingmp3.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    IPlaylistService playlistService;
    @Autowired
    ISongService songService;
//    @GetMapping("/list")
//    public ModelAndView showlist(){
//        return new ModelAndView("/playlist/list");
//    }
    @GetMapping
    public ResponseEntity<Iterable<Playlist>> getList(){
        return new ResponseEntity<>(playlistService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Playlist> save(@RequestBody Playlist playlist){
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> findById(@PathVariable Long id){
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if(!playlistOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playlistOptional.get(),HttpStatus.OK);

    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Playlist>> searchByName(@RequestParam String name){
       Iterable<Playlist> playlists = playlistService.findByNameContaining(name);

        return new ResponseEntity<>(playlists,HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> edit(@PathVariable Long id, @RequestBody Playlist playlist){
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if(!playlistOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        playlistService.save(playlist);
        return new ResponseEntity<>(playlist,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> delete(@PathVariable Long id){
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if(!playlistOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playlistService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
