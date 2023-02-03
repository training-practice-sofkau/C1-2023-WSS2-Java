package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
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
    private ResponseEntity<List<Song>> obtenerCanciones(){
        return songService.getSongs().isEmpty() ? ResponseEntity.status(204).body(Collections.emptyList()) :
        ResponseEntity.ok(songService.getSongs());
    }

    @GetMapping("/songs/{id}")
    private ResponseEntity<SongDTO> obtenerCancionPorId(@PathVariable("id") String idSong){
        return songService.findSongById(idSong) == null ? ResponseEntity.status(404).body(new SongDTO()) :
                ResponseEntity.ok(songService.findSongById(idSong));
    }

    @PostMapping("/songs")
    private ResponseEntity<SongDTO> crearCancion(@RequestBody SongDTO songDTO){
        SongDTO songSaved = songService.saveSong(songDTO);
        return songSaved == null? ResponseEntity.status(404).body(songDTO) :
                ResponseEntity.status(201).body(songSaved);
    }

    @PutMapping("/songs")
    private ResponseEntity<SongDTO> actualizarCancion(@RequestBody SongDTO songDTO){
        SongDTO songUpdated = songService.updateSong(songDTO);
        return songUpdated == null? ResponseEntity.status(404).body(songDTO) :
                ResponseEntity.status(200).body(songUpdated);
    }

    @DeleteMapping("/songs/{id}")
    private ResponseEntity<String> eliminarCancion(@PathVariable("id") String idSong){
        String msg = songService.deleteSong(idSong);
        return msg == null? ResponseEntity.status(404).body("Song non-existent") : ResponseEntity.status(201).body(msg);   }

    @GetMapping("/songs/Top")
    private ResponseEntity<List<Song>> obtenerTop(){
        return ResponseEntity.ok(songService.getSongsTop());
    }

    @GetMapping("/songs/filter")
    private ResponseEntity<List<Song>> obtenerCancionesAlbum(@RequestParam String id){
        return ResponseEntity.ok(songService.getSongsByAlbumID(id));
    }


}
