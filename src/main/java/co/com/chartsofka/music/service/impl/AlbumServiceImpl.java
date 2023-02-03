package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.service.IAlbumService;
import co.com.chartsofka.music.utils.ExceptionsHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements IAlbumService {

    private AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album dtoToEntity(AlbumDTO albumDTO) {
        Album album = new Album();

        album.setAlbumID(albumDTO.getAlbumID());
        album.setName(albumDTO.getName());
        album.setTotalSongs(albumDTO.getTotalSongs());
        album.setYearRelease(albumDTO.getYearRelease());
        album.setGenre(albumDTO.getGenre());
        album.setArtist(albumDTO.getArtist());
        album.setSongs(albumDTO.getSongs());
        return album;
    }

    @Override
    public AlbumDTO entityToDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();

        albumDTO.setAlbumID(album.getAlbumID());
        albumDTO.setName(album.getName());
        albumDTO.setTotalSongs(album.getTotalSongs());
        albumDTO.setYearRelease(album.getYearRelease());
        albumDTO.setGenre(album.getGenre());
        albumDTO.setArtist(album.getArtist());
        albumDTO.setSongs(album.getSongs());
        return albumDTO;
    }

    @Override
    public List<AlbumDTO> getAlbums() {
        return albumRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public  List<Song> getAlbumsSongs(String albumID){

        return albumRepository.findById(albumID)
                .map(this::entityToDTO)
                .get()
                .getSongs();
    }
    @Override
    public AlbumDTO getAlbumById(String idAlbum) {

        return albumRepository.findById(idAlbum).map(this::entityToDTO).get();
    }

    @Override
    public AlbumDTO saveAlbum(AlbumDTO albumDTO) {
        return entityToDTO(albumRepository.save(dtoToEntity(albumDTO)));
    }


    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO, String albumID) {

        Optional<Album> response = albumRepository.findById(albumID);
        if (response.isEmpty()) {
            throw new ExceptionsHandler("Album not found", HttpStatus.NOT_FOUND);
        }
        AlbumDTO oldAlbum = entityToDTO(response.get());
        oldAlbum.setName(albumDTO.getName());
        oldAlbum.setTotalSongs(albumDTO.getTotalSongs());
        oldAlbum.setYearRelease(albumDTO.getYearRelease());
        oldAlbum.setGenre(albumDTO.getGenre());
        oldAlbum.setArtist(albumDTO.getArtist());
        oldAlbum.setSongs(albumDTO.getSongs());
        return entityToDTO(albumRepository.save(dtoToEntity(oldAlbum)));

    }

    @Override
    public String deleteAlbum(String idAlbum) {
        Optional<Album> response = albumRepository.findById(idAlbum);
        if (response.isEmpty()) {
            throw new ExceptionsHandler("Album not found", HttpStatus.NOT_FOUND);
        }
        albumRepository.deleteById(idAlbum);
        return ("The album with ID: "+idAlbum+ " has been deleted.");
    }

}
