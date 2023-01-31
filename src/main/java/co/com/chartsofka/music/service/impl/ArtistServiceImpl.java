package java.co.com.chartsofka.music.service.impl;

import org.springframework.stereotype.Service;

import java.co.com.chartsofka.music.dto.ArtistDTO;
import java.co.com.chartsofka.music.entity.Artist;
import java.co.com.chartsofka.music.service.IArtistService;
import java.util.List;

@Service
public class ArtistServiceImpl implements IArtistService {

    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return new Artist(artistDTO.getArtistID(), artistDTO.getCountry(), artistDTO.getDebutDate(), artistDTO.getEnterprise(), artistDTO.getType());
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        return null;
    }

    @Override
    public List<ArtistDTO> getArtist() {
        return null;
    }

    @Override
    public ArtistDTO findArtistById(String artistId) {
        return null;
    }

    @Override
    public String saveArtist(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public String deleteArtist(String artistId) {
        return null;
    }
}
