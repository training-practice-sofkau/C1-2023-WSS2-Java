package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.ISongService;

import java.util.List;

public class SongServiceImpl implements ISongService {
    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        Song s = new Song();

        s.setSongId(songDTO.getSongId());
        s.setName(songDTO.getName());
        s.setPlayed(songDTO.getPlayed());
        s.setDuration(songDTO.getDuration());
        s.setAlbumId(songDTO.getAlbumId());

        return s;
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        SongDTO s = new SongDTO();

        s.setSongId(song.getSongId());
        s.setName(song.getName());
        s.setPlayed(song.getPlayed());
        s.setDuration(song.getDuration());
        s.setAlbumId(song.getAlbumId());

        return s;
    }

    @Override
    public List<SongDTO> getSongs() {
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
    public String deleteSong(SongDTO idSong) {
        return null;
    }
}
