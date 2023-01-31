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
        Album r = new Album();

        r.setAlbumID(albumDTO.getAlbumID());
        r.setTitle(albumDTO.getTitle());
        r.setGenre(albumDTO.getGenre());
        r.setArtistID(albumDTO.getArtistID());
        r.setTotalSongs(albumDTO.getTotalSongs());
        r.setYearRelease(albumDTO.getYearRelease());

        return r;

    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        AlbumDTO r = new AlbumDTO();

        r.setAlbumID(album.getAlbumID());
        r.setTitle(album.getTitle());
        r.setGenre(album.getGenre());
        r.setArtistID(album.getArtistID());
        r.setTotalSongs(album.getTotalSongs());
        r.setYearRelease(album.getYearRelease());

        return r;
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
