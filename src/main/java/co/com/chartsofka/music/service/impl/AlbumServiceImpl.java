package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.service.IAlbumService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements IAlbumService {
    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Album dtoToEntity(AlbumDTO albumDTO) {return DTOToEntity.album(albumDTO);}

    @Override
    public AlbumDTO entityToDTO(Album album) {
        return EntityToDTO.album(album);
    }

    @Override
    public List<AlbumDTO> getAlbums() {
        return albumRepository.findAll()
                .stream().map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlbumDTO findAlbumById(String idAlbum) {
        return entityToDTO(albumRepository.findById(idAlbum).orElse(new Album()));
    }

    @Override
    public AlbumDTO saveAlbum(AlbumDTO albumDTO) {

        return entityToDTO(albumRepository.save(dtoToEntity(albumDTO)));
    }

    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO, String albumID) {
        AlbumDTO album = entityToDTO(albumRepository.findById(albumID).orElse(new Album()));

        if (album.getAlbumID() == null) {
            return album;
        } else {
            album.setTitle(albumDTO.getTitle());
            album.setTotalSongs(albumDTO.getTotalSongs());
            album.setYearRelease(albumDTO.getYearRelease());
            album.setGenre(albumDTO.getGenre());
            album.setArtistDTO(albumDTO.getArtistDTO());

            albumRepository.save(dtoToEntity(album));

            return album;
        }
    }


    @Override
    public String deleteAlbum(String idAlbum) {
        try {
            albumRepository.deleteById(idAlbum);
            return "Deleted";
        }
        catch (Exception e){
            System.out.println(e);
            return "Unsuccessful";
        }
    }
}
