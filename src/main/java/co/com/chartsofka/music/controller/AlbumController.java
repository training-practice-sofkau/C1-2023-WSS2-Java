package co.com.chartsofka.music.controller;

import java.util.List;
import co.com.chartsofka.music.dto.SongDTO;
import org.springframework.http.HttpStatus;
import co.com.chartsofka.music.dto.AlbumDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumServiceImpl albumServiceImpl;

    public AlbumController(AlbumServiceImpl albumServiceImpl) {
        this.albumServiceImpl = albumServiceImpl;
    }

    @GetMapping("{id}")
    public ResponseEntity<AlbumDTO> getAlbumById(@PathVariable("id") String albumID) {
        return new ResponseEntity<>(albumServiceImpl.getAlbumById(albumID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AlbumDTO>> getAlbums(){
        return new ResponseEntity<>(albumServiceImpl.getAlbums(), HttpStatus.OK);
    }

    @GetMapping("/songs/{albumID}")
    public ResponseEntity<List<SongDTO>> getSongs(@PathVariable("albumID") String albumID){
        return new ResponseEntity<>(albumServiceImpl.getSongs(albumID), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAlbum(@RequestBody AlbumDTO albumDTO){
        albumServiceImpl.saveAlbum(albumDTO);
    }

    @PutMapping
    public ResponseEntity<AlbumDTO> updateAlbum(@RequestBody AlbumDTO albumDTO){
        albumServiceImpl.updateAlbum(albumDTO);
        return new ResponseEntity<>(albumDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable("id") String albumId){
        albumServiceImpl.deleteAlbum(albumId);
    }

}
