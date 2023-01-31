package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.service.IAlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
AlbumServiceImpl implements IAlbumService {

    private ModelMapper modelMapper;

    public AlbumServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public Album dtoToEntity(AlbumDTO albumDTO) {
        return modelMapper.map(albumDTO, Album.class);
    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        return modelMapper.map(album, AlbumDTO.class);
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
