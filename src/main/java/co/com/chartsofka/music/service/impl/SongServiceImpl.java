package java.co.com.chartsofka.music.service.impl;

import org.springframework.stereotype.Service;

import java.co.com.chartsofka.music.dto.SongDTO;
import java.co.com.chartsofka.music.entity.Song;
import java.co.com.chartsofka.music.service.ISongService;
import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        return new Song(songDTO.getSongID(), songDTO.getName(), songDTO.getDuration(), songDTO.getAlbumID(), songDTO.getPlayed());
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        return null;
    }

    @Override
    public List<SongDTO> getSong() {
        return null;
    }

    @Override
    public SongDTO findSongById(String songId) {
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
