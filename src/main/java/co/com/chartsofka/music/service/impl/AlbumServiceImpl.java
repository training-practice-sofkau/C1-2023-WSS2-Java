package java.co.com.chartsofka.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.com.chartsofka.music.dto.AlbumDTO;
import java.co.com.chartsofka.music.entity.Album;
import java.co.com.chartsofka.music.repository.AlbumRepository;
import java.co.com.chartsofka.music.service.IAlbumService;
import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Album dtoToEntity(AlbumDTO albumDTO) {
        return new Album(albumDTO.getAlbumID(), albumDTO.getTitle(), albumDTO.getTotalSongs(), albumDTO.getYearRelease(), albumDTO.getGenre(), albumDTO.getArtistID());
    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        return new AlbumDTO(album.getAlbumID(), album.getTitle(), album.getTotalSongs(), album.getYearRelease(), album.getGenre(), album.getArtistID());

    }

    @Override
    public List<Album> getAlbums() {
        // return albumRepository.findAll().stream.map(albumDTO -> dtoToEntity(albumDTO)).collect(Collectors.toList());
        return null;
    }

    @Override
    public Album findAlbumById(String albumId) {
        // return dtoToEntity(albumRepository.findById(albumId));
        return null;
    }

    @Override
    public String saveAlbum(AlbumDTO albumDTO) {
        //  return albumRepository.save(albumDTO).toString();
        return null;
    }

    @Override
    public Album updateAlbum(AlbumDTO albumDTO) {
        // return dtoToEntity(albumRepository.update(albumDTO));
        return null;
    }

    @Override
    public String deleteAlbum(String albumId) {
        // albumRepository.deleteById(albumId);
        return null;
    }
}
