package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        Song result = new Song();
        result.setSongID(songDTO.getSongID());
        result.setAlbumID(songDTO.getAlbumID());
        result.setName(songDTO.getName());
        result.setPlayed(songDTO.getPlayed());
        result.setDuration(songDTO.getDuration());
        return result;
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        SongDTO result = new SongDTO();
        result.setSongID(song.getSongID());
        result.setAlbumID(song.getAlbumID());
        result.setName(song.getName());
        result.setPlayed(song.getPlayed());
        result.setDuration(song.getDuration());
        return result;
    }

    @Override
    public List<SongDTO> findAllSongs() {
        return null;
    }

    @Override
    public SongDTO findSongById(String idSong) {
        return null;
    }

    @Override
    public String saveSong(SongDTO songDTO) {
        return null;
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        return null;
    }

    @Override
    public String deleteSong(String idSong) {
        return null;
    }
}
