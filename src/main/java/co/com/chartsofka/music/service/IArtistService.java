package co.com.chartsofka.music.service;



import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;

import java.util.List;

public interface IArtistService {

    //To manage the DTO's - Entity dynamic
    Artist dtoToEntity (ArtistDTO artistDTO);
    ArtistDTO entityToDTO(Artist artist);

    //Basic operate
    List<ArtistDTO> getArtists();

    ArtistDTO findArtistById(String idArtist);

    ArtistDTO saveArtist(ArtistDTO artistDTO);

    ArtistDTO updateArtist(ArtistDTO artistDTO, String artistID);

    String deleteArtist(String idArtist);
}
