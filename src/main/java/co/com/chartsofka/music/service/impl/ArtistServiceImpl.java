package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.service.IArtistService;

import java.util.List;

public class ArtistServiceImpl implements IArtistService {
    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        Artist a = new Artist();

        a.setArtistId(artistDTO.getArtistId());
        a.setCountry(artistDTO.getCountry());
        a.setDebutDate(artistDTO.getDebutDate());
        a.setDebutDate(artistDTO.getDebutDate());
        a.setEnterprise(artistDTO.getEnterprise());
        a.setType(artistDTO.getType());

        return a;
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        ArtistDTO a = new ArtistDTO();

        a.setArtistId(artist.getArtistId());
        a.setCountry(artist.getCountry());
        a.setDebutDate(artist.getDebutDate());
        a.setDebutDate(artist.getDebutDate());
        a.setEnterprise(artist.getEnterprise());
        a.setType(artist.getType());

        return a;
    }

    @Override
    public List<ArtistDTO> getArtist() {
        return null;
    }

    @Override
    public ArtistDTO findArtistById(String idArtist) {
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
    public String deleteArtist(String idArtist) {
        return null;
    }
}
