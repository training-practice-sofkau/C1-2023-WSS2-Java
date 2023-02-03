package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.repository.ArtistRepository;
import co.com.chartsofka.music.service.IAlbumService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements IAlbumService {

    AlbumRepository albumRepository;
    ArtistRepository artistRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

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
        if (albumDTO.getArtistDTO() == null) return null;
        Optional<Artist> artist = artistRepository.findById(albumDTO.getArtistDTO().getArtistIDDTO());
        //System.out.println(artist);
        if (artist.isEmpty()) return null;
        else return entityToDTO(albumRepository.save(dtoToEntity(albumDTO)));
    }

    @Override
    public AlbumDTO updateAlbum(AlbumDTO albumDTO) {
        Optional<Album> albumUpdate = albumRepository
                .findById(albumDTO.getAlbumIDDTO());
        Optional<Artist> artistUpdate = artistRepository
                .findById(albumDTO.getArtistDTO().getArtistIDDTO());
        if (albumUpdate.isEmpty() || artistUpdate.isEmpty()) return null;
        else {
            albumUpdate.get().setTitle(albumDTO.getTitleDTO());
            albumUpdate.get().setTotalSongs(albumDTO.getTotalSongsDTO());
            albumUpdate.get().setYearRelease(albumDTO.getYearReleaseDTO());
            albumUpdate.get().setGenre(albumDTO.getGenreDTO());
            // Me deja cambiar datos del artista, pero al final con el id se sabra que no cambia
            // nd en el registro de artista
            albumUpdate.get().setArtist(DTOToEntity.artist(albumDTO.getArtistDTO()));
            albumUpdate.get().setSongs(albumDTO.getSongsDTO()
                    .stream()
                    .map(i->DTOToEntity.song(i))
                    .collect(Collectors.toList()));
            return entityToDTO(albumRepository.save(albumUpdate.get()));
        }

    }

    @Override
    public String deleteAlbum(String idAlbum) {
        Optional<AlbumDTO> albumDTO = this.findAlbumById(idAlbum);
        if(albumDTO.isEmpty()) return null;
        else {
            albumRepository.deleteById(idAlbum);
            return "Album with id: " + idAlbum + " was deleted successfully";
        }
    }
}
