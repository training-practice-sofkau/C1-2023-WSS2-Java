package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements ISongService {
    private SongRepository songRepository;
    private AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        return DTOToEntity.song(songDTO);
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        return EntityToDTO.song(song);
    }

    @Override
    public List<SongDTO> getSongs() {
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SongDTO> findSongById(String idSong) {
        return songRepository.findById(idSong).map(EntityToDTO::song);
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {
        return songDTO.getAlbumDTO() == null ? null:
                entityToDTO(songRepository.save(dtoToEntity(songDTO)));
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        Optional<Song> songUpdate =
                songRepository.findById(songDTO.getSongIDDTO());
        Optional<Album> albumUpdate =
                albumRepository.findById(songDTO.getAlbumDTO().getAlbumIDDTO());
        if (songUpdate.isEmpty()||albumUpdate.isEmpty()) return null;
        else {
            songUpdate.get().setName(songDTO.getNameDTO());
            songUpdate.get().setDuration(songDTO.getDurationDTO());
            songUpdate.get().setPlayed(songDTO.getPlayedDTO());
            songUpdate.get().setAlbum(DTOToEntity.album(songDTO.getAlbumDTO()));
        }
        return entityToDTO(songRepository.save(songUpdate.get()));
    }

    @Override
    public String deleteSong(String idSong) {
        Optional<SongDTO> songDTO = this.findSongById(idSong);
        if (songDTO.isEmpty()) return null;
        else {
            songRepository.deleteById(idSong);
            return "Song with id: " + idSong + " was deleted successfully";
        }

    }
}
