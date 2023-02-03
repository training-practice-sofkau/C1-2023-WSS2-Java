package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/albums")
public class AlbumController {
    @Autowired
    AlbumServiceImpl albumService;

    @GetMapping("")
    private ResponseEntity<List<AlbumDTO>> obtenerAlbumnes(){
        return albumService.getAlbums().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                ResponseEntity.ok(albumService.getAlbums());
    }

    @GetMapping("/{id}")
    private ResponseEntity obtenerAlbumPorId(@PathVariable("id") String idAlbum){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        try {
            AlbumDTO album = albumService.findAlbumById(idAlbum);
            return new ResponseEntity (album, httpHeaders, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(404).body("No album found with the ID provided");
        }
    }

    @PostMapping
    private ResponseEntity<AlbumDTO> guardarAlbum(@RequestBody AlbumDTO albumDTO){
        AlbumDTO albumDTO1 = albumService.saveAlbum(albumDTO);
        return  albumDTO1 == null ? ResponseEntity.status(400).body(albumDTO) : ResponseEntity.status(201).body(albumDTO1);
    }

    @PutMapping("/{id}")
    private ResponseEntity actualizarAlbum(@PathVariable("id") String idAlbum,
                                                        @RequestBody AlbumDTO albumDTO) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        try {
            AlbumDTO albumUpdated = albumService.updateAlbum(albumDTO, idAlbum);
            return new ResponseEntity (albumUpdated, httpHeaders, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("No album found with the ID provided");
        }

    }

    @DeleteMapping("/{id}")
    private ResponseEntity eliminarAlbumPorId(@PathVariable("id") String idAlbum){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        try {
            AlbumDTO album = albumService.findAlbumById(idAlbum);
            String response = albumService.deleteAlbum(album.getAlbumID());
            return new ResponseEntity (response, httpHeaders, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("No artist found with the ID provided");
        }
    }
}
