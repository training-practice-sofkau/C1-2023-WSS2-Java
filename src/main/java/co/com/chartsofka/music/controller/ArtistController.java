package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/charts")
public class ArtistController {

    ArtistServiceImpl service;

    @GetMapping("/artist")
    private List<ArtistDTO> obtenerArtistas(){
        return service.getArtist();
    }

}
