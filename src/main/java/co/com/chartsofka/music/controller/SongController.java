package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @GetMapping("/most-played")
    private ResponseEntity<List<SongDTO>> findTenMostPlayed(){
        return songService.getTenMostSongs().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
//                ResponseEntity.noContent().build():
                ResponseEntity.ok(songService.getTenMostSongs());
    }

    @GetMapping("{id}")
    private ResponseEntity<SongDTO> findSongById(@PathVariable("id") String idSong){
        return songService.findSongById(idSong) == null ? ResponseEntity.status(404).body(new SongDTO())
                : ResponseEntity.ok(songService.findSongById(idSong));
    }


    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteSong(@PathVariable("id") String idSong){
        try{
            songService.deleteSong(idSong);
            return ResponseEntity.ok("Entity deleted");
        }
        catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    private ResponseEntity<SongDTO> updateArtist(@PathVariable("id") String idSong, @RequestBody SongDTO songDetails ){
        SongDTO songUpdate = songService.findSongById(idSong);

        songUpdate.setName(songDetails.getName());
        songUpdate.setPlayed(songDetails.getPlayed());
        songUpdate.setDuration(songDetails.getDuration());
        songUpdate.setAlbumDTO(songDetails.getAlbumDTO());

        songService.saveSong(songUpdate);

        return ResponseEntity.ok(songUpdate);

    }
}
