package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    AlbumServiceImpl albumService;

    @GetMapping
    private ResponseEntity<List<AlbumDTO>> obtenerAlbumnes(){
        return albumService.getAlbums().isEmpty() ?
                ResponseEntity.status(204).body(Collections.emptyList()) :
                //ResponseEntity.noContent().build():
                ResponseEntity.ok(albumService.getAlbums());
    }

    @GetMapping("{id}")
    private ResponseEntity<AlbumDTO> obtenerAlbumPorId(@PathVariable("id") String idAlbum){
        return albumService.findAlbumById(idAlbum) == null ? ResponseEntity.status(404).body(new AlbumDTO())
                : ResponseEntity.ok(albumService.findAlbumById(idAlbum));
    }

    @PostMapping
    private ResponseEntity<AlbumDTO> guardarAlbum(@RequestBody AlbumDTO albumDTO){
        AlbumDTO albumDTO1 = albumService.saveAlbum(albumDTO);
        return  albumDTO1 == null ? ResponseEntity.status(400).body(albumDTO) : ResponseEntity.status(201).body(albumDTO1);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteArtist(@PathVariable("id") String idAlbum){
        try{
            albumService.deleteAlbum(idAlbum);
            return ResponseEntity.ok("Entity deleted");
        }
        catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    private ResponseEntity<AlbumDTO> updateArtist(@PathVariable("id") String idAlbum, @RequestBody AlbumDTO albumDetails ){
        AlbumDTO albumUpdate = albumService.findAlbumById(idAlbum);

        albumUpdate.setTitle(albumDetails.getTitle());
        albumUpdate.setGenre(albumDetails.getGenre());
        albumUpdate.setTotalSongs(albumDetails.getTotalSongs());
        albumUpdate.setYearRelease(albumDetails.getYearRelease());
        albumUpdate.setArtistDTO(albumDetails.getArtistDTO());

        albumService.saveAlbum(albumUpdate);

        return ResponseEntity.ok(albumUpdate);
    }
}
