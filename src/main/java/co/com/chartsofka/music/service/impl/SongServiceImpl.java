package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.mapper.SongDTOToSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    SongRepository songRepository;
    @Autowired
    SongDTOToSong mapper;

    @Override
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public SongDTO findSongById(String idArtist) {
        return null;
    }

    @Override
    public Song saveSong(SongDTO songDTO) {
        Song song = mapper.map(songDTO);
        return this.songRepository.save(song);
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
