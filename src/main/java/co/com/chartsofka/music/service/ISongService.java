package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;

public interface ISongService {
    //To manage the DTO's - Entity dynamic
    Song dtoToEntity (SongDTO songDTO);
    SongDTO entityToDTO(Song song);

    //Basic operate
    List<SongDTO> getSong();

    SongDTO findSongById(String idSong);

    String saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO SongDTO);

    String deleteSong(String idSong);
}
