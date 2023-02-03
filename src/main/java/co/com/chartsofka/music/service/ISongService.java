package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;

public interface ISongService {

    //DTOs
    Song dtoToEntity(SongDTO songDTO);

    SongDTO entityToDTO(Song song);

    //CRUD
    List<SongDTO> findAllSongs();

    SongDTO findSongById(String idSong);

    String saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO songDTO);

    String deleteSong(String idSong);
}
