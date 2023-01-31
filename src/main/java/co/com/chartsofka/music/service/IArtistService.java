package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;

import java.util.List;

public interface IArtistService {

    //DTOs
    Artist dtoToEntity(ArtistDTO artistDTO);

    ArtistDTO entityToDTO(Artist artist);

    //CRUD
    List<ArtistDTO> findAllArtist();

    ArtistDTO findArtistById();

    String saveArtist();

    ArtistDTO updateArtist();

    String deleteAlbum();

}
