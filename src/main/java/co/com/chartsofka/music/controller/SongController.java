package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    ISongService songService;

    @GetMapping("/")
    private ResponseEntity<List<SongDTO>> getSongs(){
        return songService.findAllSongs().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                //ResponseEntity.noContent().build():
                ResponseEntity.ok(songService.findAllSongs());
    }

    @GetMapping("/{id}")
    private ResponseEntity<SongDTO> getSongById(@PathVariable("id") String songId){
        var result = songService.findSongById(songId);
        return result == null ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result);
    }

    @PostMapping("/")
    private ResponseEntity<SongDTO> saveSong(@RequestBody SongDTO songDTO){
        SongDTO songDTO1 = songService.saveSong(songDTO);
        return  songDTO1 == null ? ResponseEntity.status(400).body(songDTO) : ResponseEntity.status(201).body(songDTO1);
    }

    @PutMapping("/")
    private ResponseEntity<SongDTO> updateSong(@RequestBody SongDTO songDTO){
        return songService.findSongById(songDTO.getSongID()) == null ? ResponseEntity.status(204).body(songDTO) :
                ResponseEntity.ok().body(songService.updateSong(songDTO));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<SongDTO> deleteSong(@PathVariable("id") String songId){
        return songService.findSongById(songId) == null ? ResponseEntity.status(204).build():
                ResponseEntity.status(200).build();
    }
}
