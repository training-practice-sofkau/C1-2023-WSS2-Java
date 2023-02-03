package co.com.chartsofka.music.service.impl;


import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import co.com.chartsofka.music.dto.SongDTO;
import org.springframework.http.HttpStatus;
import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import org.springframework.stereotype.Service;
import co.com.chartsofka.music.service.IAlbumService;
import co.com.chartsofka.music.exceptions.ToDoExceptions;
import co.com.chartsofka.music.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements IAlbumService {

    private final ModelMapper modelMapper;
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(ModelMapper modelMapper, AlbumRepository albumRepository) {
        this.modelMapper = modelMapper;
        this.albumRepository = albumRepository;
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
    public AlbumDTO getAlbumById(String albumID) {
        Optional<Album> response = albumRepository.findById(albumID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Album not found", HttpStatus.NOT_FOUND);
        }
        return entityToDTO(response.get());
    }
    @Override
    public List<AlbumDTO> getAlbums() {
        return albumRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .toList();
    }

    @Override
    public List<SongDTO> getSongs(String albumID) {
        Optional<Album> response = albumRepository.findById(albumID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Album not found", HttpStatus.NOT_FOUND);
        }
        return response
                .get()
                .getSongs()
                .stream()
                .map(s -> modelMapper.map(s, SongDTO.class))
                .toList();
    }

    @Override
    public void saveAlbum(AlbumDTO albumDTO) {
        albumRepository.save(dtoToEntity(albumDTO));
    }

    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO) {
        String albumID = albumDTO.getAlbumID();
        Optional<Album> response = albumRepository.findById(albumID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Album not found", HttpStatus.NOT_FOUND);
        }
        albumRepository.save(dtoToEntity(albumDTO));
        return albumDTO;
    }

    @Override
    public void deleteAlbum(String idAlbum) {
        Optional<Album> response = albumRepository.findById(idAlbum);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Album not found", HttpStatus.NOT_FOUND);
        }
        albumRepository.deleteById(idAlbum);
    }
}
