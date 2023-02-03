package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;

import java.util.List;
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
    public List<SongDTO> getSong() {
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SongDTO findSongById(String songId) {
        return entityToDTO(songRepository.findById(songId).orElse(new Song()));
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {
        return entityToDTO(songRepository.save(dtoToEntity(songDTO)));
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        // return entityToDTO(songsRepository.update(dtoToEntity(songDTO)));
        return null;
    }

    @Override
    public String deleteSong(String songID) {
        // songsRepository.deleteById(songID);
        return null;
    }
}