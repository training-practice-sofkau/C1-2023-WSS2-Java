package java.co.com.chartsofka.music.service.impl;

import org.springframework.stereotype.Service;

import java.co.com.chartsofka.music.dto.AlbumDTO;
import java.co.com.chartsofka.music.entity.Album;
import java.co.com.chartsofka.music.service.IAlbumService;
import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    @Override
    public Album dtoToEntity(AlbumDTO albumDTO) {
        return new Album(albumDTO.getAlbumID(), albumDTO.getTitle(), albumDTO.getTotalSongs(), albumDTO.getYearRelease(), albumDTO.getGenre(), albumDTO.getArtistID());
    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        return null;
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
