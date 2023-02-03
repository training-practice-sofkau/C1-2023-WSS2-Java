package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import co.com.chartsofka.music.utils.EntityToDTO;
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
        return artistService.findArtistById(idArtist) == null ? ResponseEntity.status(404).body(EntityToDTO.artist(new Artist())) : ResponseEntity.ok(artistService.findArtistById(idArtist));
    }

    @GetMapping("/type/{type}")
    private ResponseEntity<List<ArtistDTO>> obtenerArtistaPorTipo(@PathVariable("type") String type){
        return artistService.getArtistByType(type) == null ? ResponseEntity.status(404).body(Collections.emptyList()) : ResponseEntity.ok(artistService.getArtistByType(type));
    }

    @PostMapping("/")
    private ResponseEntity<ArtistDTO> guardarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.saveArtist(artistDTO);
        return  artistSaved == null ? ResponseEntity.status(400).body(artistDTO) : ResponseEntity.status(201).body(artistSaved);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ArtistDTO> actualizarAtista(
            @PathVariable("id") String id,
            @RequestBody ArtistDTO artistDTO
    ){
        return artistService.updateArtist(id, artistDTO) == null ? ResponseEntity.status(404).build() : ResponseEntity.ok(artistService.updateArtist(id, artistDTO));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> eliminarArtista(@PathVariable("id") String idArtist){
        return artistService.deleteArtist(idArtist) == null ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok("Artist:" + artistService.deleteArtist(idArtist) + " deleted");
    }

}
