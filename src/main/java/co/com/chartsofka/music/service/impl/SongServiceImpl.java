package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<SongDTO> tenMostReproduced() {
        return songRepository.findAll()
                .stream().sorted(Comparator.comparingInt(Song::getPlayed).reversed())
                .map(this::entityToDTO)
                .limit(10).collect(Collectors.toList());
    }

    @Override
    public List<SongDTO> getbyAlbum(String idAlbum) {
        List<SongDTO> songDTOS = new ArrayList<>();
        songRepository
                .findAll().stream()
                .map(EntityToDTO::song)
                .collect(Collectors.toList()).stream().forEach(i->{
                    if (i.getAlbumDTO().getAlbumIDDTO().equals(idAlbum)) songDTOS.add(i);
                });
        return songDTOS;
    }

    @Override
    public Optional<SongDTO> findSongById(String idSong) {
        return songRepository.findById(idSong).map(EntityToDTO::song);
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {
        System.out.println(songDTO.getAlbumDTO());
        Optional<AlbumDTO> albumDTO = albumRepository
                .findById(songDTO
                        .getAlbumDTO().getAlbumIDDTO())
                .map(EntityToDTO::album);
        System.out.println(albumDTO);
        return (songDTO.getAlbumDTO() == null || albumDTO==null) ? null:
                entityToDTO(songRepository.save(dtoToEntity(songDTO)));
        //return entityToDTO(songRepository.save(dtoToEntity(songDTO)));
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
