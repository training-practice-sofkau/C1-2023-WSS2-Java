package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;

import java.util.List;
import java.util.Optional;

public interface IAlbumService {

    //To manage the DTO's - Entity dynamic
    Album dtoToEntity (AlbumDTO albumDTO);
    AlbumDTO entityToDTO(Album album);

    //Basic operate
    List<AlbumDTO> getAlbums();

    Optional<AlbumDTO> findAlbumById(String idAlbum);

    AlbumDTO saveAlbum(AlbumDTO albumDTO);

    AlbumDTO updateAlbum(String idArtist, AlbumDTO albumDTO);

    AlbumDTO deleteAlbum(String idAlbum);

}
