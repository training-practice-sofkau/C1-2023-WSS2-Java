package java.co.com.chartsofka.music.service;

import java.co.com.chartsofka.music.dto.ArtistDTO;
import java.co.com.chartsofka.music.entity.Artist;
import java.util.List;

public interface IArtistService {

    Artist dtoToEntity(ArtistDTO artistDTO);
    ArtistDTO entityToDTO(Artist artist);

    List<Artist> getArtist();

    Artist findArtistById(String artistId);

    String saveArtist(ArtistDTO artistDTO);

    Artist updateArtist(ArtistDTO artistDTO);

    String deleteArtist(String artistId);

}
