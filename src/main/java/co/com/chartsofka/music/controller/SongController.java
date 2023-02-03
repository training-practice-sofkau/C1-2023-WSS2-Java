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
    private ResponseEntity<SongDTO> saveSong(@RequestBody SongDTO songDTO){
        SongDTO song = songService.saveSong(songDTO);
        return song == null ? ResponseEntity.status(400).body(songDTO) : ResponseEntity.status(201).body(song);
    }

    @GetMapping
    private ResponseEntity<List<SongDTO>> findAll(){
        return songService.getAllSongs().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
//                ResponseEntity.noContent().build():
                ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("{id}")
    private ResponseEntity<SongDTO> findSongById(@PathVariable("id") String idSong){
        var result = songService.findSongById(idSong);
        return result.isEmpty() ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result.get());
    }
}
