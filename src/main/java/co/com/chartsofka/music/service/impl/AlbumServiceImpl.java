package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.controller.AlbumController;
import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.service.IAlbumService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {
    @Override
    public Album dtoToEntity(AlbumDTO albumDTO) {
        Album r = new Album();

        r.setAlbumID(albumDTO.getAlbumID());
        r.setName(albumDTO.getName());
        r.setTotalSongs(albumDTO.getTotalSongs());
        r.setYearRelease(albumDTO.getYearRelease());
        r.setArtistID(albumDTO.getArtistID());
        r.setGenre(albumDTO.getGenre());

        return r;

    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        AlbumDTO d = new AlbumDTO();

        d.setAlbumID(album.getAlbumID());
        d.setName(album.getName());
        d.setTotalSongs(album.getTotalSongs());
        d.setYearRelease(album.getYearRelease());
        d.setArtistID(album.getArtistID());
        d.setGenre(album.getGenre());

        return d;
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
    public String saveAlbum(AlbumDTO albumDTO) {return null;}


    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO) {
        return null;
    }

    @Override
    public String deleteAlbum(String idAlbum) {
        return null;
    }
}
