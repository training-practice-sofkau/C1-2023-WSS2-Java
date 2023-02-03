package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/charts/albums")
public class AlbumController {
    @Autowired
    AlbumServiceImpl albumService;

    @GetMapping
    private ResponseEntity<List<AlbumDTO>> getAlbums(){
        return albumService.getAlbums().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                //ResponseEntity.noContent().build():
                ResponseEntity.ok(albumService.getAlbums());
    }

    @GetMapping("{id}")
    private ResponseEntity<AlbumDTO> getAlbum(@PathVariable("id") String albumId){
        AlbumDTO album = albumService.findAlbumById(albumId);
        return album.getAlbumID()!=null ? ResponseEntity.ok(album):ResponseEntity.status(404).build();
    }

    @PostMapping
    private ResponseEntity<AlbumDTO> saveAlbum(@RequestBody AlbumDTO albumDTO){
        AlbumDTO responseAlbum = albumService.saveAlbum(albumDTO);
        return  responseAlbum.getAlbumID() != null ? ResponseEntity.status(201).body(responseAlbum) : ResponseEntity.status(400).body(albumDTO);
    }
}
