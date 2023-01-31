package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImp implements ISongService {

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        return null;
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        return null;
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
    public String saveSong(SongDTO SongDTO) {
        return null;
    }

    @Override
    public SongDTO updateArtist(SongDTO SongDTO) {
        return null;
    }

    @Override
    public String deleteSong(String idSong) {
        return null;
    }

}
