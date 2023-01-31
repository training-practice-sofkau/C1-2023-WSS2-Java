package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.service.IArtistService;


import java.util.List;


public class ArtistServiceImpl implements IArtistService {
    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        Artist a = new Artist();

        a.setArtistID(artistDTO.getArtistID());
        a.setCountry(artistDTO.getCountry());
        a.setDebutDate(artistDTO.getDebutDate());
        a.setEnterprise(artistDTO.getEnterprise());
        a.setType(artistDTO.getType());

        return a;


    }
    public ArtistDTO entityToDTO(Artist artist){
        ArtistDTO ad = new ArtistDTO();

        ad.setArtistID(artist.getArtistID());
        ad.setCountry(artist.getCountry());
        ad.setDebutDate(artist.getDebutDate());
        ad.setEnterprise(artist.getEnterprise());
        ad.setType(artist.getType());

        return ad;
    }



    @Override
    public List<ArtistDTO> getArtists() {
        return null;
    }

    @Override
    public ArtistDTO findArtistById() {
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
