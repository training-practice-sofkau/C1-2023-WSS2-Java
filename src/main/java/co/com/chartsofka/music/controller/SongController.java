package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.service.impl.SongServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charts")
public class SongController {

    private SongServiceImpl service;

    public SongController(SongServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/songs")
    public List<SongDTO> getSongs(){
        return service.getSongs();
    }

    @PostMapping("/songs")
    public String createSong(@RequestBody SongDTO songDTO){
        service.saveSong(songDTO);
        return "Ok";
    }

}
