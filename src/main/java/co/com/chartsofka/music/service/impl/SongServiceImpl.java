package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.controller.ItemNotFoundException;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    SongRepository songRepository;

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
                .stream().map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public List<SongDTO> getPopularSongs(){
        return songRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Song::getPlayed).reversed())
                .limit(10)
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SongDTO> findSongById(String idSong) {
        return songRepository.findById(idSong).map(this::entityToDTO);
    }

    public List<SongDTO> getSongsByAlmbunId(String idAlbum){
        return songRepository.findAll()
                .stream()
                .filter(song -> Objects.equals(song.getAlbum().getAlbumID(), idAlbum))
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {

        return entityToDTO(songRepository.save(dtoToEntity(songDTO)));
    }

    @Override
    public SongDTO updateSong(String idSong, SongDTO songDTO) {
        var songBody = songRepository.findById(idSong)
                .map(this::entityToDTO)
                .map(song -> {
                    song.setName(songDTO.getName());
                    song.setDuration(songDTO.getDuration());
                    song.setPlayed(songDTO.getPlayed());
                    song.setAlbumDTO(songDTO.getAlbumDTO());
                    return dtoToEntity(song);
                }).orElseThrow(() -> new ItemNotFoundException(idSong));
        songRepository.save(songBody);
        return entityToDTO(songBody);
    }

    @Override
    public SongDTO deleteSong(String idSong) {
        var song = songRepository.findById(idSong).orElseThrow(() -> new ItemNotFoundException(idSong));
        songRepository.delete(song);
        return entityToDTO(song);
    }
}
