package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/charts")
public class SongController {

    @Autowired
    SongServiceImpl songService;

    @GetMapping("/songs")
    private ResponseEntity<List<SongDTO>> obtenerTodasCanciones(){
        return ResponseEntity.ok(songService.getSongs());
    }

    @GetMapping("/songs/filter")
    private ResponseEntity<List<SongDTO>> obtenerCancionesPorAlbum(@RequestParam String titleAlbum){
        List<SongDTO> s =  songService.findSongsByAlbumId(titleAlbum);
        return s == null ? ResponseEntity.status(404).body(null) : ResponseEntity.ok(s);

    }

    @GetMapping("/songs/{id}")
    private ResponseEntity<SongDTO> obtenerCancionPorId(@PathVariable("id") String idSong){
        SongDTO s = songService.findSongById(idSong);
        return s == null ? ResponseEntity.status(404).body(null) : ResponseEntity.ok(s);
    }

    @PostMapping("/songs")
    private ResponseEntity<SongDTO> guardarCancion(@RequestBody SongDTO songDTO){
        SongDTO s = songService.saveSong(songDTO);
        return  s == null ? ResponseEntity.status(400).body(songDTO) : ResponseEntity.status(201).body(s);
    }

    @PutMapping("/songs")
    private ResponseEntity<SongDTO> actualizarCancion(@RequestBody SongDTO songDTO){
        SongDTO s = songService.updateSong(songDTO);
        return  s == null ? ResponseEntity.status(400).body(songDTO) : ResponseEntity.ok().body(s);
    }

    @DeleteMapping("/songs/{id}")
    private ResponseEntity<String> borrarCancion(@PathVariable("id") String idSong){
        String s = songService.deleteSong(idSong);
        return  s == null ? ResponseEntity.status(400).body("Song is not in our system") : ResponseEntity.ok().body(s);
    }
}
