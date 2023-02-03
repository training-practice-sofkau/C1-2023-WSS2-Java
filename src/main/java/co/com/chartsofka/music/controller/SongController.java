package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
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

    @GetMapping
    private ResponseEntity<List<SongDTO>> getSongs() {
        List<SongDTO> songs = songService.getSongs();
        return songs.isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                ResponseEntity.ok(songs);
    }

    @GetMapping("/{id}")
    private ResponseEntity<SongDTO> getSong(@PathVariable("id") String songId) {
        SongDTO song = songService.findSongById(songId);
        return song.getSongID() != null ? ResponseEntity.ok(song) : ResponseEntity.status(404).build();
    }

    @PostMapping
    private ResponseEntity<SongDTO> saveSong(@RequestBody SongDTO songDTO) {
        SongDTO responseSong = songService.saveSong(songDTO);
        return responseSong.getSongID() != null ? ResponseEntity.ok(responseSong) : ResponseEntity.status(400).build();
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteSong (@PathVariable("id") String songId){
        songService.deleteSong(songId);
        return ResponseEntity.ok("Song deleted successfully");
    }
    @PatchMapping
    private ResponseEntity<SongDTO> updateSong (@RequestBody SongDTO songDTO){
        SongDTO responseSong = songService.updateSong(songDTO);
        return responseSong.getSongID() != null ? ResponseEntity.ok(responseSong) : ResponseEntity.status(400).build();
    }
    @GetMapping("/top")
    private ResponseEntity<List<SongDTO>> getTopSongs() {
        List<SongDTO> songs = songService.getTopSongs();
        return songs.isEmpty()
                ? ResponseEntity.status(204).body(Collections.emptyList())
                : ResponseEntity.ok(songs);
    }
    @GetMapping("/albums")
    private ResponseEntity<List<SongDTO>> getSongsFromAlbum(@RequestBody AlbumDTO albumDTO) {
        List<SongDTO> songs = songService.getSongsFromAlbum(albumDTO);
        return songs.isEmpty()
                ? ResponseEntity.status(204).body(Collections.emptyList())
                : ResponseEntity.ok(songs);
    }

}
