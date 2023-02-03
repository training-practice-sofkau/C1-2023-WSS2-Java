package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/charts")
public class ArtistController implements Serializable {

    private ArtistServiceImpl service;

    public ArtistController(ArtistServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/artists")
    public List<ArtistDTO> getArtists(){
        return service.getArtists();
    }

    @PostMapping("/artists")
    public String createArtist(@RequestBody ArtistDTO artistDTO){
        service.saveArtist(artistDTO);
        return "Ok";
    }
}
