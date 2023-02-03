package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class ArtistController {
    @Autowired
    ArtistServiceImpl artistService;

    @GetMapping("/artists")
    private ResponseEntity<List<ArtistDTO>> obtenerArtistas(){
        return artistService.getArtists().isEmpty()
                ? ResponseEntity.status(204).body(Collections.emptyList())
                : ResponseEntity.ok(artistService.getArtists());
    }

    @GetMapping("/artists/{id}")
    private ResponseEntity<ArtistDTO> obtenerArtistaPorId(@PathVariable("id") String idArtist){
        return artistService.findArtistById(idArtist) == null
                ? ResponseEntity.status(404).body(new ArtistDTO())
                : ResponseEntity.ok(artistService.findArtistById(idArtist));
    }

    @GetMapping("/artists/type/{type}")
    private ResponseEntity<List<ArtistDTO>> obtenerArtistaPorTipo(@PathVariable("type") String typeArtist){
        return artistService.findArtistByType(typeArtist) == null
                ? ResponseEntity.status(404).build()
                : ResponseEntity.ok(artistService.findArtistByType(typeArtist));
    }

    @PostMapping("/artists")
    private ResponseEntity<ArtistDTO> guardarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.saveArtist(artistDTO);
        return  artistSaved == null
                ? ResponseEntity.status(400).body(artistDTO)
                : ResponseEntity.status(201).body(artistSaved);
    }

    @PutMapping("/artists/{id}")
    private ResponseEntity<ArtistDTO> actualizarArtista(@PathVariable("id") String idArtist, @RequestBody ArtistDTO artistDTO){
        ArtistDTO updatedArtist = artistService.updateArtist(idArtist, artistDTO);
        return artistDTO == null
                ? ResponseEntity.status(404).body(updatedArtist)
                : ResponseEntity.status(200).body(updatedArtist);
    }

    @DeleteMapping("/artists/{id}")
    private ResponseEntity<String> borrarArtista(@PathVariable("id") String idArtist){
        ArtistDTO artistDeleted = artistService.deleteArtist(idArtist);
        return artistDeleted == null
                ? ResponseEntity.status(404).build()
                : ResponseEntity.status(204).body(artistDeleted.getArtistID());
    }
}
