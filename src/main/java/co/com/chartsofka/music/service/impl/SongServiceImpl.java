package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        Song song = new Song();

        song.setSongID(songDTO.getSongID());
        song.setName(songDTO.getName());
        song.setDuration(songDTO.getDuration());
        song.setAlbumID(songDTO.getAlbumID());
        song.setPlayed(songDTO.getPlayed());
        return song;
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        SongDTO songDTO = new SongDTO();

        songDTO.setSongID(song.getSongID());
        songDTO.setName(song.getName());
        songDTO.setDuration(song.getDuration());
        songDTO.setAlbumID(song.getAlbumID());
        songDTO.setPlayed(song.getPlayed());

        return songDTO;
    }

    @Override
    public List<SongDTO> getSongs() {
        return null;
    }

    @Override
    public SongDTO findSongById(String songID) {
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
    public String deleteSong(String songID) {
        return null;
    }
}
