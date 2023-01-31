package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/charts")
public class AlbumController {
    @Autowired
    AlbumServiceImpl service;

    @GetMapping("/album")
    private List<AlbumDTO> obtenerAlbumnes(){
        return service.getAlbums();
    }
}
