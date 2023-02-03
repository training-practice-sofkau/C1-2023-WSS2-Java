package co.com.chartsofka.music.service;



import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;

import java.util.List;
import java.util.Optional;

public interface IArtistService {

    //To manage the DTO's - Entity dynamic
    Artist dtoToEntity (ArtistDTO artistDTO);
    ArtistDTO entityToDTO(Artist artist);

    //Basic operate
    List<ArtistDTO> getArtists();

    Optional<ArtistDTO> findArtistById(String idArtist);

    ArtistDTO saveArtist(ArtistDTO artistDTO);

    ArtistDTO updateArtist(ArtistDTO artistDTO);

    String deleteArtist(String idArtist);
}
