package co.com.chartsofka.music.service;

import java.util.List;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.dto.AlbumDTO;

public interface IAlbumService {

    //To manage the DTOs - Entity dynamic
    Album dtoToEntity (AlbumDTO albumDTO);
    AlbumDTO entityToDTO(Album album);

    //Basic operations
    List<AlbumDTO> getAlbums();

    AlbumDTO getAlbumById(String albumID);

    void saveAlbum(AlbumDTO albumDTO);

    AlbumDTO updateAlbum(AlbumDTO albumDTO);

    void deleteAlbum(String albumID);

    //Customized operations
    List<SongDTO> getSongs(String albumID);

}
