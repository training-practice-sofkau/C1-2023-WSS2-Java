package java.co.com.chartsofka.music.service;

import java.co.com.chartsofka.music.dto.ArtistDTO;
import java.co.com.chartsofka.music.entity.Artist;
import java.util.List;

public interface IArtistService {

    Artist dtoToEntity(ArtistDTO artistDTO);
    ArtistDTO entityToDTO(Artist artist);

    List<ArtistDTO> getArtist();

    ArtistDTO findArtistById(String artistId);

    String saveArtist(Artist Artist);

    ArtistDTO updateArtist(ArtistDTO ArtistDTO);

    String deleteArtist(String artistId);

}
