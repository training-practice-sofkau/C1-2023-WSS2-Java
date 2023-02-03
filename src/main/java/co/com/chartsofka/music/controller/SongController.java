package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class SongController {
    @Autowired
    SongServiceImpl songService;

    @GetMapping("/songs")
    private ResponseEntity<List<SongDTO>> obtenerCanciones(){
        return songService.getSongs().isEmpty()
                ? ResponseEntity.status(204).body(Collections.emptyList())
                : ResponseEntity.ok(songService.getSongs());
    }

    @GetMapping("/songs/popular")
    private ResponseEntity<List<SongDTO>> obtenerCancionesopulares(){
        return songService.getPopularSongs().isEmpty()
                ? ResponseEntity.status(204).body(Collections.emptyList())
                : ResponseEntity.ok(songService.getPopularSongs());
    }

    @GetMapping("/songs/{id}")
    private ResponseEntity<SongDTO> obtenercancionPorId(@PathVariable("id") String idSong){
        var result = songService.findSongById(idSong);
        return result.isEmpty() ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result.get());
    }

    @GetMapping("/songs/album/{idAlbum}")
    private ResponseEntity<List<SongDTO>> obtenercancionPorAlbumId(@PathVariable("idAlbum") String idAlbum){
        var result = songService.getSongsByAlmbunId(idAlbum);
        return result.isEmpty() ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result);
    }

    @PostMapping("/songs")
    private ResponseEntity<SongDTO> guardarCancion(@RequestBody SongDTO songDTO){
        SongDTO songDTO1 = songService.saveSong(songDTO);
        return  songDTO1 == null
                ? ResponseEntity.status(400).body(songDTO)
                : ResponseEntity.status(201).body(songDTO);
    }

    @PutMapping("/songs/{id}")
    private ResponseEntity<SongDTO> actualizarCancion(@PathVariable("id") String idSong, @RequestBody SongDTO songDTO){
        SongDTO updatedSong = songService.updateSong(idSong, songDTO);
        return updatedSong == null
                ? ResponseEntity.status(404).build()
                : ResponseEntity.status(200).body(updatedSong);
    }

    @DeleteMapping("/songs/{id}")
    private ResponseEntity<SongDTO> borrarCancion(@PathVariable("id") String idSong){
        SongDTO songDeleted = songService.deleteSong(idSong);
        return songDeleted == null
                ? ResponseEntity.status(404).build()
                : ResponseEntity.status(204).body(songDeleted);
    }
}
