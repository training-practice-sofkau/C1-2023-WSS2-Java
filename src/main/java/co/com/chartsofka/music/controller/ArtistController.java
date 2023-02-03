package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.*;

@RestController
@RequestMapping("api/artists")
public class ArtistController {
    @Autowired
    ArtistServiceImpl artistService;

    @GetMapping("")
    public ResponseEntity obtenerArtistas() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        List<ArtistDTO> artists = artistService.getArtists();

        if (artists.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        else {
            return new ResponseEntity <List> (artists, httpHeaders, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity obtenerArtistaPorId(@PathVariable("id") String idArtist){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        ArtistDTO artist = artistService.findArtistById(idArtist);

        if (artist.getArtistID() == null) {
            return ResponseEntity.status(404).build();
        }
        else {
            return new ResponseEntity (artist, httpHeaders, HttpStatus.OK);
        }
    }

    @PostMapping("")
    private ResponseEntity<ArtistDTO> guardarArtista(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artistSaved = artistService.saveArtist(artistDTO);
        return  artistSaved == null ? ResponseEntity.status(400).body(artistDTO) : ResponseEntity.status(201).body(artistSaved);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ArtistDTO> actualizarArtista(@PathVariable("id") String idArtist,
                                                        @RequestBody ArtistDTO artistDTO) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        ArtistDTO artistUpdated = artistService.updateArtist(artistDTO, idArtist);

        if (artistUpdated.getArtistID() == null) {
            return ResponseEntity.status(404).build();
        }
        else{
            return new ResponseEntity (artistUpdated, httpHeaders, HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    private ResponseEntity eliminarArtistaPorId(@PathVariable("id") String idArtist){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        ArtistDTO artist = artistService.findArtistById(idArtist);

        if (artist.getArtistID() == null) {
            return ResponseEntity.status(404).body("No artist found with the ID provided");
        }
        else {
            String response = artistService.deleteArtist(artist.getArtistID());
            return new ResponseEntity (response, httpHeaders, HttpStatus.OK);
        }
    }

}
