package co.com.chartsofka.music.controller;

import org.springframework.http.HttpStatus;
import co.com.chartsofka.music.dto.ArtistDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistServiceImpl artistServiceImpl;

    public ArtistController(ArtistServiceImpl artistServiceImpl) {
        this.artistServiceImpl = artistServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getArtistById(@PathVariable("id") String artistID) {
        return new ResponseEntity<>(artistServiceImpl.getArtistById(artistID), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ArtistDTO>> getArtists(){
        return new ResponseEntity<>(artistServiceImpl.getArtists(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveArtist(@RequestBody ArtistDTO artistDTO){
        artistServiceImpl.saveArtist(artistDTO);
    }

    @PutMapping
    public ResponseEntity<ArtistDTO> updateArtist(@RequestBody ArtistDTO artistDTO){
        artistServiceImpl.updateArtist(artistDTO);
        return new ResponseEntity<>(artistDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable("id") String artistId){
        artistServiceImpl.deleteArtist(artistId);
    }
}
