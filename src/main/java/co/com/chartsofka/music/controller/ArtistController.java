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
        return artistService.getArtists().isEmpty() ? ResponseEntity.status(204).body(Collections.emptyList()) : ResponseEntity.ok(artistService.getArtists());
    }

    @GetMapping("/artists/filter")
    private ResponseEntity<List<ArtistDTO>> obtenerArtistasPorTipo(@RequestParam String type){
        List<ArtistDTO> a = artistService.findArtistsByType(type);
        return a.isEmpty() ? ResponseEntity.status(404).body(a) : ResponseEntity.ok(a);
    }

    @GetMapping("/artists/{id}")
    private ResponseEntity<ArtistDTO> obtenerArtistaPorId(@PathVariable("id") String idArtist){
        return artistService.findArtistById(idArtist) == null ? ResponseEntity.status(404).body(new ArtistDTO()) : ResponseEntity.ok(artistService.findArtistById(idArtist));
    }

    @PostMapping("/artists")
    private ResponseEntity<ArtistDTO> guardarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.saveArtist(artistDTO);
        return  artistSaved == null ? ResponseEntity.status(400).body(artistDTO) : ResponseEntity.status(201).body(artistSaved);
    }

    @PutMapping("/artists")
    private ResponseEntity<ArtistDTO> actualizarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.updateArtist(artistDTO);
        return  artistSaved == null ? ResponseEntity.status(400).body(artistDTO) : ResponseEntity.ok().body(artistSaved);
    }

    @DeleteMapping("/artists/{id}")
    private ResponseEntity<String> borrarArtista(@PathVariable("id") String idArtist){
        String s = artistService.deleteArtist(idArtist);
        return  s == null ? ResponseEntity.status(400).body("Artist is not in our system") : ResponseEntity.ok().body(s);
    }

}
