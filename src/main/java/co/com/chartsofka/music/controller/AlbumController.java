package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/charts/albums")
public class AlbumController {

    @Autowired
    AlbumServiceImpl albumService;

    @GetMapping("/")
    private ResponseEntity<List<AlbumDTO>> obtenerAlbumnes(){
        return albumService.getAlbums().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                ResponseEntity.ok(albumService.getAlbums());
    }

    @GetMapping("/{id}")
    private ResponseEntity<AlbumDTO> obtenerAlbumPorId(@PathVariable("id") String idAlbum){
        var result = albumService.findAlbumById(idAlbum);
        return result.isEmpty() ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result.get());
    }

    @PostMapping("/")
    private ResponseEntity<AlbumDTO> guardarAlbum(@RequestBody AlbumDTO albumDTO){
        AlbumDTO albumDTO1 = albumService.saveAlbum(albumDTO);
        return  albumDTO1 == null ? ResponseEntity.status(400).body(albumDTO) : ResponseEntity.status(201).body(albumDTO1);
    }

    @PutMapping("/{id}")
    private ResponseEntity<AlbumDTO> actualizarAlbum(
            @PathVariable("id") String id,
            @RequestBody AlbumDTO albumDTO
    ){
        return albumService.updateAlbum(id, albumDTO) == null ? ResponseEntity.status(404).build() : ResponseEntity.ok(albumService.updateAlbum(id, albumDTO));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> eliminarAlbum(@PathVariable("id") String idAlbum){
        return albumService.deleteAlbum(idAlbum) == null ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok("Album:" + albumService.deleteAlbum(idAlbum) + " deleted");
    }
}
