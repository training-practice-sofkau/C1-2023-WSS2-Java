package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import java.util.List;

public interface ISongService {

    Song dtoToEntity(SongDTO songDTO);
    SongDTO entityToDTO(Song song);

    List<SongDTO> getSong();

    SongDTO findSongById(String songId);

    SongDTO saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO songDTO);

    String deleteSong(String songID);
}