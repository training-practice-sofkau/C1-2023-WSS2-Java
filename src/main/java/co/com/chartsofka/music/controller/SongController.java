package co.com.chartsofka.music.controller;


import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/songs")
public class SongController {
    @Autowired
    SongServiceImpl songService;
    @Autowired
    private SongRepository songRepository;

    @GetMapping
    private ResponseEntity<List<SongDTO>> obtenerCanciones(){
        return songService.getSongs().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                ResponseEntity.ok(songService.getSongs());
    }
    @GetMapping("/{id}")
    private ResponseEntity obtenerCancionPorId(@PathVariable("id") String idSong){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        try {
            SongDTO song = songService.findSongById(idSong);
            return new ResponseEntity (song, httpHeaders, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(404).body("No song found with the ID provided");
        }
    }

    @GetMapping("/mostplayed")
    private ResponseEntity obtenerCancionesMas(){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        List<SongDTO> songs = songService.getSongs();

        if (songs.isEmpty()) {
            return ResponseEntity.status(204).body(Collections.emptyList());
        }
        else {
            songs = songs.stream()
                    .sorted(Comparator.comparing(SongDTO::getPlayed).reversed())
                    .limit(10)
                    .toList();

            return new ResponseEntity (songs, httpHeaders, HttpStatus.OK);
        }
    }

    @PostMapping
    private ResponseEntity<SongDTO> guardarCancion(@RequestBody SongDTO songDTO){
        SongDTO songDTO1 = songService.saveSong(songDTO);
        return  songDTO1 == null ? ResponseEntity.status(400).body(songDTO) : ResponseEntity.status(201).body(songDTO1);
    }

    @PutMapping("/{id}")
    private ResponseEntity actualizarCancion(@PathVariable("id") String idSong,
                                           @RequestBody SongDTO songDTO) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        try {
            SongDTO songUpdated = songService.updateSong(songDTO, idSong);
            return new ResponseEntity (songUpdated, httpHeaders, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("No song found with the ID provided");
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity eliminarCancionPorId(@PathVariable("id") String idSong){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        try {
            SongDTO song = songService.findSongById(idSong);
            String response = songService.deleteSong(song.getSongID());
            return new ResponseEntity (response, httpHeaders, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("No song found with the ID provided");
        }
    }
}
