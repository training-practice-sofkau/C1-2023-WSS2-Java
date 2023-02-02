package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
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
    public Album dtoToEntity(AlbumDTO albumDTO) {
        return DTOToEntity.album(albumDTO);

    }

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
    public Optional<AlbumDTO> findAlbumById(String idAlbum) {
        //return entityToDTO(albumRepository.findById(idAlbum).orElseThrow(NoSuchElementException::new));
        return albumRepository.findById(idAlbum).map(EntityToDTO::album);
    }

    @Override
    public AlbumDTO saveAlbum(AlbumDTO albumDTO) {

        return entityToDTO(albumRepository.save(dtoToEntity(albumDTO)));
    }

    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO) {
        Optional<Album> a = albumRepository.findById(albumDTO.getAlbumID());

        if(a.isEmpty()) return null;

        a.get().setTitle(albumDTO.getTitle());
        a.get().setArtist(DTOToEntity.artist(albumDTO.getArtistDTO()));
        a.get().setTotalSongs(albumDTO.getTotalSongs());
        a.get().setYearRelease(albumDTO.getYearRelease());
        a.get().setTitle(albumDTO.getGenre());

        return entityToDTO(albumRepository.save(a.get()));
    }

    @Override
    public String deleteAlbum(String idAlbum) {
        Optional<Album> a = albumRepository.findById(idAlbum);

        if(a.isEmpty()) return null;

        albumRepository.delete(a.get());

        return "Album "+a.get().getTitle()+" was deleted successfully";
    }
}
