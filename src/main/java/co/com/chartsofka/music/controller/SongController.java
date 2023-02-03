package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/charts")
public class SongController implements Serializable {

    private SongServiceImpl service;

    public SongController(SongServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/songs")
    public ResponseEntity<List<SongDTO>> getSongs(){
        return service.getSongs().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()):
                ResponseEntity.ok(service.getSongs());
    }


    @GetMapping("/songs/top10")
    public List<SongDTO> getTopSongs(){
        return service.getSongsTop();
    }

    @GetMapping("/songs/album/{albumID}")
    public List<SongDTO> getTopSongs(@PathVariable String albumID){
        return service.getSongsByAlbum(albumID);
    }


    @PostMapping("/songs")
    public String createSong(@RequestBody SongDTO songDTO){
        service.saveSong(songDTO);
        return "Ok";
    }



}
