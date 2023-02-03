package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charts")
public class SongController {
    SongServiceImpl songService;

    public SongController(SongServiceImpl songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    private ResponseEntity<List<SongDTO>> obtenerCanciones(){
        var result = songService.getSongs();
        return result.isEmpty() ?
                ResponseEntity.status(204).body(result) :
                ResponseEntity.ok(result);
    }

    @GetMapping("/songs/{id}")
    private ResponseEntity<SongDTO> obtenerSongPorId(@PathVariable("id") String idSong){
        var result = songService.findSongById(idSong);
        return result.isEmpty() ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result.get());
    }

    @PostMapping("/songs")
    private ResponseEntity<SongDTO> guardarSong(@RequestBody SongDTO songDTO){
        SongDTO songDTO1 = songService.saveSong(songDTO);
        return songDTO1 == null ?
                ResponseEntity.status(400).body(null) :
                ResponseEntity.status(201).body(songDTO1);
    }

    @PutMapping("/songs")
    private ResponseEntity<SongDTO> actualizarCancion (@RequestBody SongDTO songDTO){
        SongDTO songDTO1 = songService.updateSong(songDTO);
        return  songDTO1 == null ?
                ResponseEntity.status(400).body(songDTO1) :
                ResponseEntity.status(201).body(songDTO);
    }

    @DeleteMapping("/songs/{id}")
    private ResponseEntity<String> borrarCanciones (@PathVariable("id") String idCancion){
        String s = songService.deleteSong(idCancion);
        return s == null ?
                new ResponseEntity<>("There is not song with id: " + idCancion, HttpStatus.CONFLICT):
                new ResponseEntity<>(s, HttpStatus.ACCEPTED);

    }


}
