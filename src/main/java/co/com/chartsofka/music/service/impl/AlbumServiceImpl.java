package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.service.IAlbumService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlbumDTO> findAlbumById(String idAlbum) {
        return albumRepository.findById(idAlbum).map(EntityToDTO::album);
    }

    @Override
    public AlbumDTO saveAlbum(AlbumDTO albumDTO) {
        return entityToDTO(albumRepository.save(dtoToEntity(albumDTO)));
    }

    @Override
    public AlbumDTO updateAlbum(String id, AlbumDTO albumDTO) {
        Album albumToUpdate = albumRepository.findById(id).orElse(new Album());

        albumToUpdate.setTitle(albumDTO.getTitle());
        albumToUpdate.setTotalSongs(albumDTO.getTotalSongs());
        albumToUpdate.setYearRelease(albumDTO.getYearRelease());
        albumToUpdate.setGenre(albumDTO.getGenre());
        albumToUpdate.setArtist(albumDTO.getArtist());
        albumToUpdate.setSongs(albumDTO.getSongs());

        return entityToDTO(albumRepository.save(albumToUpdate));
    }

    @Override
    public String deleteAlbum(String idAlbum) {
        Album albumToDelete = albumRepository.findById(idAlbum).orElseThrow();
        albumRepository.delete(albumToDelete);
        return idAlbum;
    }
}
