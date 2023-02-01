package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.IArtistService;

import java.util.List;

public class ArtistServiceImpl implements IArtistService {
    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO){
        Artist artist = new Artist();

        artist.setArtistID(artistDTO.getArtistID());
        artist.setCountry(artistDTO.getCountry());
        artist.setDebutDate(artistDTO.getDebutDate());
        artist.setEnterprise(artistDTO.getEnterprise());
        artist.setType(artist.getType());

        return artist;
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        ArtistDTO artistDTO = new ArtistDTO();

        artistDTO.setArtistID(artist.getArtistID());
        artistDTO.setCountry(artist.getCountry());
        artistDTO.setDebutDate(artist.getDebutDate());
        artistDTO.setEnterprise(artist.getEnterprise());
        artistDTO.setType(artist.getType());

        return artistDTO;
    }

    @Override
    public List<ArtistDTO> getArtists(){
        return null;
    }

    @Override
    public ArtistDTO findByID(String artistID){return null;}

    @Override
    public String save(ArtistDTO artistDTO){return null;}

    @Override
    public ArtistDTO update(ArtistDTO artistDTO){return null;}

    @Override
    public String delete(String artistID){return null;}
}
