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
        Artist result = new Artist();
        result.setArtistID(artistDTO.getArtistID());
        result.setType(artistDTO.getType());
        result.setCountry(artistDTO.getCountry());
        result.setEnterprise(artistDTO.getEnterprise());
        result.setDebutDate(artistDTO.getDebutDate());
        return result;
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        ArtistDTO result = new ArtistDTO();
        result.setArtistID(artist.getArtistID());
        result.setType(artist.getType());
        result.setCountry(artist.getCountry());
        result.setEnterprise(artist.getEnterprise());
        result.setDebutDate(artist.getDebutDate());
        return result;
    }

    @Override
    public List<ArtistDTO> findAllArtist() {
        return null;
    }

    @Override
    public ArtistDTO findArtistById(String IdArtist) {
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
    public String deleteAlbum(String idArtist) {
        return null;
    }
}
