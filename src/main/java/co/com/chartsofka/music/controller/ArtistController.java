package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/charts")
public class ArtistController {
    @Autowired
    ArtistServiceImpl artistService;

    @GetMapping("/artists")
    private ResponseEntity<List<ArtistDTO>> obtenerArtistas(){
        var result = artistService.getArtists();
        return result.isEmpty() ?
                ResponseEntity.status(204).body(result) :
                ResponseEntity.ok(result);
    }

    @GetMapping("/artists/{id}")
    private ResponseEntity<ArtistDTO> obtenerArtistaPorId(@PathVariable("id") String idArtist){
        var result = artistService.findArtistById(idArtist);
        return result.isEmpty() ?
                ResponseEntity.status(404).build() :
                ResponseEntity.ok(result.get());
    }

    @PostMapping("/artists")
    private ResponseEntity<ArtistDTO> guardarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.saveArtist(artistDTO);
        return  artistSaved == null ?
                ResponseEntity.status(400).body(null) :
                ResponseEntity.status(201).body(artistSaved);
    }

    @PutMapping("/artists")
    private ResponseEntity<ArtistDTO> actualizarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistDTO1 = artistService.updateArtist(artistDTO);
        return artistDTO1 == null ?
                ResponseEntity.status(400).body(artistDTO):
                ResponseEntity.status(201).body(artistDTO1);
    }

    @DeleteMapping("/artists/{id}")
    private ResponseEntity<String> borrarArtista(@PathVariable("id") String idArtista){
        String s = artistService.deleteArtist(idArtista);
        return s == null ?
                new ResponseEntity<>("There is not album with id: " + idArtista, HttpStatus.CONFLICT):
                new ResponseEntity<>(s, HttpStatus.ACCEPTED);

    }

}
