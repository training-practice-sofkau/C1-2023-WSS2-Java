package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Song;

import java.util.List;

public interface IAlbumService {

    //To manage the DTO's - Entity dynamic
    Album dtoToEntity (AlbumDTO albumDTO);
    AlbumDTO entityToDTO(Album album);

    //Basic operate
    List<AlbumDTO> getAlbums();

    List<Song> getAlbumsSongs(String albumID);

    AlbumDTO getAlbumById(String albumID);

    AlbumDTO saveAlbum(AlbumDTO albumDTO);

    AlbumDTO updateAlbum(AlbumDTO albumDTO);

    String deleteAlbum(String idAlbum);

}
