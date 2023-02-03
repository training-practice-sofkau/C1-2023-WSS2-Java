package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.AlbumDTO;
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

    @PostMapping("/albums")
    public String createAlbum(@RequestBody AlbumDTO albumDTO){
        service.saveAlbum(albumDTO);
        return "Ok";
    }


}
