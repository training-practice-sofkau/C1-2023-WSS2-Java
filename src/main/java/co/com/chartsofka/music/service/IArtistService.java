package co.com.chartsofka.music.service;

import java.util.List;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;

public interface IArtistService {

    //To manage the DTOs - Entity dynamic
    Artist dtoToEntity (ArtistDTO artistDTO);
    ArtistDTO entityToDTO(Artist artist);

    //Basic operations
    List<ArtistDTO> getArtists();

    ArtistDTO getArtistById(String artistID);

    void saveArtist(ArtistDTO artistDTO);

    ArtistDTO updateArtist(ArtistDTO artistDTO);

    void deleteArtist(String artistID);

    //Customized operations
    List<ArtistDTO> getArtistsByType(String artistType);
}
