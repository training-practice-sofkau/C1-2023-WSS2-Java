package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/charts/songs")
public class SongController {
    @Autowired
    SongServiceImpl songService;

    @GetMapping("/")
    private ResponseEntity<List<SongDTO>> obtenerCanciones(){
        return songService.getSongs().isEmpty() ? ResponseEntity.status(204).body(Collections.emptyList()) : ResponseEntity.ok(songService.getSongs());
    }

    @GetMapping("/{id}")
    private ResponseEntity<SongDTO> obtenerCancionPorId(@PathVariable("id") String idSong){
        return songService.findSongById(idSong) == null ? ResponseEntity.status(404).body(EntityToDTO.song(new Song())) : ResponseEntity.ok(songService.findSongById(idSong));
    }

    @GetMapping("/played")
    private ResponseEntity<List<SongDTO>> obtenerCancionesMasReproducidas(){
        return songService.getMostReproducedSongs() == null ? ResponseEntity.status(404).body(Collections.emptyList()) : ResponseEntity.ok(songService.getMostReproducedSongs());
    }

    @PostMapping("/")
    private ResponseEntity<SongDTO> guardarCancion(@RequestBody SongDTO songDTO){
        SongDTO songSaved = songService.saveSong(songDTO);
        return  songSaved == null ? ResponseEntity.status(400).body(songDTO) : ResponseEntity.status(201).body(songSaved);
    }

    @PutMapping("/{id}")
    private ResponseEntity<SongDTO> actualizarCancion(
            @PathVariable("id") String id,
            @RequestBody SongDTO songDTO
    ){
        return songService.updateSong(id, songDTO) == null ? ResponseEntity.status(404).build() : ResponseEntity.ok(songService.updateSong(id, songDTO));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> eliminarCancion(@PathVariable("id") String idSong){
        return songService.deleteSong(idSong) == null ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok("Song:" + songService.deleteSong(idSong) + " deleted");
    }

}
