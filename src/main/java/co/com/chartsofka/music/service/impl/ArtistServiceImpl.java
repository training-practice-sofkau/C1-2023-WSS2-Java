package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.service.IArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements IArtistService {
    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        return null;
    }

    @Override
    public List<ArtistDTO> findAllArtist() {
        return null;
    }

    @Override
    public ArtistDTO findArtistById() {
        return null;
    }

    @Override
    public String saveArtist() {
        return null;
    }

    @Override
    public ArtistDTO updateArtist() {
        return null;
    }

    @Override
    public String deleteAlbum() {
        return null;
    }
}
