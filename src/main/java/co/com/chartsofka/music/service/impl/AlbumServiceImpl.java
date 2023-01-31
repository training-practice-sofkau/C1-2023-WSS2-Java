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
        Album result = new Album();
        result.setAlbumID(albumDTO.getAlbumID());
        result.setTitle(albumDTO.getTitle());
        result.setGenre(albumDTO.getGenre());
        result.setArtistID(albumDTO.getArtistID());
        result.setTotalSongs(albumDTO.getTotalSongs());
        result.setYearRelease(albumDTO.getYearRelease());
        return result;
    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        AlbumDTO result = new AlbumDTO();
        result.setAlbumID(album.getAlbumID());
        result.setTitle(album.getTitle());
        result.setGenre(album.getGenre());
        result.setArtistID(album.getArtistID());
        result.setTotalSongs(album.getTotalSongs());
        result.setYearRelease(album.getYearRelease());
        return result;
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
