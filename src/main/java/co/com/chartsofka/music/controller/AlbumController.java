package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.impl.AlbumServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/charts")
public class AlbumController implements Serializable {

    private AlbumServiceImpl service;

    public AlbumController(AlbumServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/albums")
    public List<AlbumDTO> getAlbums(){
        return service.getAlbums();
    }

    @GetMapping("/albums/{albumID}")
    public AlbumDTO getAlbumByID(@PathVariable String albumID){
        return service.getAlbumById(albumID);
    }

    @GetMapping("/albums/songs/{albumID}")
    public List<Song> getAlbumsSongs(@PathVariable String albumID){
        return service.getAlbumsSongs(albumID);
    }

    @PostMapping("/albums")
    public String createAlbum(@RequestBody AlbumDTO albumDTO){
        service.saveAlbum(albumDTO);
        return "Ok";
    }


}
