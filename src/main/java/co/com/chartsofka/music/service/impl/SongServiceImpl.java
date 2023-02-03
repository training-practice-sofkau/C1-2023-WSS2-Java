package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.mapper.DTOToEntity;
import co.com.chartsofka.music.utils.mapper.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public Optional<SongDTO> findSongById(String idSong) {
        return this.songRepository.findById(idSong).map(EntityToDTO::song);
    }

    @Override
    public Song saveSong(SongDTO songDTO) {
        return this.songRepository.save(dtoToEntity(songDTO));
    }

    @Override
    public SongDTO updateSong(SongDTO artistDTO) {
        return null;
    }

    @Override
    public String deleteSong(String idArtist) {
        return null;
    }
}
