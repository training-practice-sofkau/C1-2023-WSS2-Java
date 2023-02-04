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
@RequestMapping("/charts")
public class AlbumController {
    @Autowired
    AlbumServiceImpl albumService;

    @GetMapping("/albums")
    private ResponseEntity<List<AlbumDTO>> obtenerAlbumes(){
        return albumService.getAlbums().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                //ResponseEntity.noContent().build():
                ResponseEntity.ok(albumService.getAlbums());
    }

    @GetMapping("/albums/{id}")
    private ResponseEntity<AlbumDTO> obtenerAlbumPorId(@PathVariable("id") String idAlbum){
        var result = albumService.findAlbumById(idAlbum);
        return result.isEmpty() ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result.get());
    }

    @PostMapping("/albums")
    private ResponseEntity<AlbumDTO> guardarAlbum(@RequestBody AlbumDTO albumDTO){
        AlbumDTO albumSaved = albumService.saveAlbum(albumDTO);
        return  albumSaved == null ? ResponseEntity.status(400).body(albumDTO) : ResponseEntity.status(201).body(albumSaved);
    }

    @PutMapping("/albums/{id}")
    private ResponseEntity<AlbumDTO> actualizarAlbum(@RequestBody AlbumDTO albumDTO){
        AlbumDTO albumSaved = albumService.updateAlbum(albumDTO);
        return  albumSaved == null? ResponseEntity.status(400).body(albumDTO) : ResponseEntity.status(200).body(albumSaved);
    }

    @DeleteMapping("/albums/{id}")
    private ResponseEntity<String> eliminarAlbum(@PathVariable("id") String idAlbum){
        String msg = albumService.deleteAlbum(idAlbum);
        return  msg == null? ResponseEntity.status(400).body("Album non-existent"): ResponseEntity.status(201).body(msg);
    }
}
