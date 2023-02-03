package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/charts")
public class SongController {

    @Autowired
    SongServiceImpl songService;

    @GetMapping("/songs")
    private ResponseEntity<List<SongDTO>> getSongs() {
        List<SongDTO> songs = songService.getSong();
        return songs.isEmpty() ? ResponseEntity.status(204).body(Collections.emptyList()):ResponseEntity.ok(songs);
    }

}
