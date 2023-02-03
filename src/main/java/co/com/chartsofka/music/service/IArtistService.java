package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;

import java.util.List;

public interface IArtistService {

    //To manage the DTOs - Entity dynamic
    Artist dtoToEntity (ArtistDTO artistDTO);
    ArtistDTO entityToDTO(Artist artist);

    //Basic operate
    List<ArtistDTO> getArtists();

    ArtistDTO getArtistById(String artistID);

    void saveArtist(ArtistDTO artistDTO);

    ArtistDTO updateArtist(ArtistDTO artistDTO);

    void deleteArtist(String artistID);
}
