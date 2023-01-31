package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;

import java.util.List;

public interface IArtistService {
    Artist dtoToEntity(ArtistDTO artistDTO);
    ArtistDTO entityToDTO(Artist artist);

    List<ArtistDTO> getArtists();
    ArtistDTO findArtistById(String idArtist);
    String saveArtist(ArtistDTO artistDTO);
    ArtistDTO updateArtist(ArtistDTO artistDTO);
    String deleteArtist(ArtistDTO idArtist);
}
