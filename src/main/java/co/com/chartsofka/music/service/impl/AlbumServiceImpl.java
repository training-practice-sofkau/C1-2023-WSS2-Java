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
        album.setName(albumDTO.getName());
        album.setTotalSongs(albumDTO.getTotalSongs());
        album.setYearRelease(albumDTO.getYearRelease());
        album.setArtistID(albumDTO.getArtistID());
        album.setGenre(albumDTO.getGenre());

        return album;
    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();

        albumDTO.setAlbumID(album.getAlbumID());
        albumDTO.setName(album.getName());
        albumDTO.setTotalSongs(album.getTotalSongs());
        albumDTO.setYearRelease(album.getYearRelease());
        albumDTO.setArtistID(album.getArtistID());
        albumDTO.setGenre(album.getGenre());

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
