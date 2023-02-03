package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongServiceImpl songServiceImpl;

    public SongController(SongServiceImpl songServiceImpl) {
        this.songServiceImpl = songServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDTO> getSongById(@PathVariable("id") String artistID) {
        return new ResponseEntity<>(songServiceImpl.getSongById(artistID), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<SongDTO>> getSongs(){
        return new ResponseEntity<>(songServiceImpl.getSongs(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSong(@RequestBody SongDTO artistDTO){
        songServiceImpl.saveSong(artistDTO);
    }

    @PutMapping
    public ResponseEntity<SongDTO> updateSong(@RequestBody SongDTO artistDTO){
        songServiceImpl.updateSong(artistDTO);
        return new ResponseEntity<>(artistDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSong(@PathVariable("id") String artistId) {
        songServiceImpl.deleteSong(artistId);
    }
}
