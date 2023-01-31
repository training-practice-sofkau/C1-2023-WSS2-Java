package java.co.com.chartsofka.music.service;

import java.co.com.chartsofka.music.dto.AlbumDTO;
import java.co.com.chartsofka.music.entity.Album;
import java.util.List;

public interface IAlbumService {

    //To manage the DTO's - Entity dynamic
    Album dtoToEntity (AlbumDTO albumDTO);
    AlbumDTO entityToDTO(Album album);

    //Basic operate
    List<Album> getAlbums();

    Album findAlbumById(String albumId);

    String saveAlbum(AlbumDTO albumDTO);

    Album updateAlbum(AlbumDTO albumDTO);

    String deleteAlbum(String albumId);

}
