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
        a.setType(artistDTO.getType());
        a.setCountry(artistDTO.getCountry());
        a.setEnterprise(artistDTO.getEnterprise());
        a.setDebutDate(artistDTO.getDebutDate());

        return a;
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        ArtistDTO a = new ArtistDTO();

        a.setArtistId(artist.getArtistId());
        a.setType(artist.getType());
        a.setCountry(artist.getCountry());
        a.setEnterprise(artist.getEnterprise());
        a.setDebutDate(artist.getDebutDate());

        return a;
    }

    @Override
    public List<ArtistDTO> getArtists() {
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
    public String deleteArtist(ArtistDTO idArtist) {
        return null;
    }
}
