package co.com.chartsofka.music.controller;

import java.util.List;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    ArtistServiceImpl service;

    @GetMapping("")
    private List<ArtistDTO> getArtists() {return service.getArtists();}
}
