package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.service.IAlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {
    @Override
    public Album dtoToEntity(AlbumDTO albumDTO) {
        Album album = new Album();

        album.setAlbumID(albumDTO.getAlbumID());
        album.setTitle(albumDTO.getTitle());
        album.setTotalSongs(albumDTO.getTotalSongs());
        album.setYearRelease(albumDTO.getYearRelease());
        album.setGenre(albumDTO.getGenre());
        album.setArtistID(albumDTO.getArtistID());
        return album;
    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();

        albumDTO.setAlbumID(album.getAlbumID());
        albumDTO.setTitle(album.getTitle());
        albumDTO.setTotalSongs(album.getTotalSongs());
        albumDTO.setYearRelease(album.getYearRelease());
        albumDTO.setGenre(album.getGenre());
        albumDTO.setArtistID(album.getArtistID());
        return albumDTO;
    }

    @Override
    public List<AlbumDTO> getAlbums() {
        return null;
    }

    @Override
    public AlbumDTO findAlbumById(String idAlbum) {
        return null;
    }

    @Override
    public String saveAlbum(AlbumDTO albumDTO) {
        return null;
    }

    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO) {
        return null;
    }

    @Override
    public String deleteAlbum(String idAlbum) {
        return null;
    }
}
