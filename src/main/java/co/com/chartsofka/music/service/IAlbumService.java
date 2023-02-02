package java.co.com.chartsofka.music.service;

import java.co.com.chartsofka.music.dto.AlbumDTO;
import java.co.com.chartsofka.music.entity.Album;
import java.util.List;

public interface IAlbumService {

    //To manage the DTO's - Entity dynamic
    Album dtoToEntity (AlbumDTO albumDTO);
    AlbumDTO entityToDTO(Album album);

    //Basic operate
    List<AlbumDTO> getAlbums();

    AlbumDTO findAlbumById(String albumId);

    String saveAlbum(AlbumDTO albumDTO);

    AlbumDTO updateAlbum(AlbumDTO album);

    String deleteAlbum(String albumId);

}
