package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    SongServiceImpl songService;

    @PostMapping
    private ResponseEntity<Song> saveSong(@RequestBody SongDTO songDTO){
        Song song = songService.saveSong(songDTO);
        return song == null ? ResponseEntity.status(400).body(song) : ResponseEntity.status(201).body(song);
    }

    @GetMapping
    private ResponseEntity<List<Song>> findAll(){
        return songService.getAllSongs().isEmpty() ?
//                ResponseEntity.status(204).body(Collections.emptyList()) :
                ResponseEntity.noContent().build():
                ResponseEntity.ok(songService.getAllSongs());
    }
}
