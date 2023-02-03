package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/charts")
public class AlbumController {
    AlbumServiceImpl albumService;

    public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    private ResponseEntity<List<AlbumDTO>> obtenerAlbumnes(){
        var result = albumService.getAlbums();
        return result.isEmpty() ?
                ResponseEntity.status(204).body(result) :
                //ResponseEntity.noContent().build():
                ResponseEntity.ok(result);
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
        AlbumDTO albumDTO1 = albumService.saveAlbum(albumDTO);
        return  albumDTO1 == null ?
                ResponseEntity.status(400).body(null) :
                ResponseEntity.status(201).body(albumDTO1);
    }

    @PutMapping("/albums")
    private ResponseEntity<AlbumDTO> actualizarAlbum(@RequestBody AlbumDTO albumDTO){
        AlbumDTO albumDTO1 = albumService.updateAlbum(albumDTO);
        return  albumDTO1 == null ?
                ResponseEntity.status(400).body(albumDTO) :
                ResponseEntity.status(201).body(albumDTO1);
    }

    @DeleteMapping("/albums/{id}")
    private ResponseEntity<String> borrarAlbum(@PathVariable("id") String idAlbum){
        String s = albumService.deleteAlbum(idAlbum);
        return s == null ?
                new ResponseEntity<>("There is not album with id: " + idAlbum, HttpStatus.CONFLICT):
                new ResponseEntity<>(s, HttpStatus.ACCEPTED);

    }
}
