package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/charts/artists")
public class ArtistController {
    @Autowired
    ArtistServiceImpl artistService;

    @GetMapping
    private ResponseEntity<List<ArtistDTO>> getArtists(){
        return artistService.getArtists().isEmpty() ? ResponseEntity.status(204).body(Collections.emptyList()) : ResponseEntity.ok(artistService.getArtists());
    }

    @GetMapping("/{id}")
    private ResponseEntity<ArtistDTO> getArtist(@PathVariable("id") String albumId){
        return artistService.findArtistById(albumId) == null ? ResponseEntity.status(404).body(new ArtistDTO()) : ResponseEntity.ok(artistService.findArtistById(albumId));
    }

    @PostMapping
    private ResponseEntity<ArtistDTO> saveArtist(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.saveArtist(artistDTO);
        return  artistSaved == null ? ResponseEntity.status(400).body(artistDTO) : ResponseEntity.status(201).body(artistSaved);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteArtist(@PathVariable("id") String albumId){
        artistService.deleteArtist(albumId);
        return ResponseEntity.ok("Artist deleted successfully");
    }

    @PatchMapping
    private ResponseEntity<ArtistDTO> updateArtist(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.updateArtist(artistDTO);
        return  artistSaved == null ? ResponseEntity.status(400).body(artistDTO) : ResponseEntity.status(201).body(artistSaved);
    }

    @GetMapping("/type/{type}")
    private ResponseEntity<List<ArtistDTO>> getByType(@PathVariable("type") String albumType){
        List<ArtistDTO> artistDTOs = artistService.findAllByType(albumType);
        return artistDTOs.isEmpty()
                ? ResponseEntity.status(204).body(Collections.emptyList())
                : ResponseEntity.ok(artistDTOs);
    }

}
