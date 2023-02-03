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

    @GetMapping("/")
    private ResponseEntity<List<ArtistDTO>> obtenerArtistas(){
        return artistService.getArtists().isEmpty() ? ResponseEntity.status(204).body(Collections.emptyList()) : ResponseEntity.ok(artistService.getArtists());
    }

    @GetMapping("/{id}")
    private ResponseEntity<ArtistDTO> obtenerArtistaPorId(@PathVariable("id") String idArtist){
        return artistService.findArtistById(idArtist) == null ? ResponseEntity.status(404).body(new ArtistDTO()) : ResponseEntity.ok(artistService.findArtistById(idArtist));
    }

    @PostMapping("/")
    private ResponseEntity<ArtistDTO> guardarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.saveArtist(artistDTO);
        return  artistSaved == null ? ResponseEntity.status(400).body(artistDTO) : ResponseEntity.status(201).body(artistSaved);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> eliminarArtista(@PathVariable("id") String idArtist){
        return artistService.deleteArtist(idArtist) == null ? ResponseEntity.status(404).build() : ResponseEntity.ok("Artist:" + artistService.deleteArtist(idArtist) + " deleted");
    }

}
