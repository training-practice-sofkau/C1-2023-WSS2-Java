package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;

public interface ISongService {
    Song dtoToEntity(SongDTO songDTO);

    SongDTO entityToDto(Song song);

    List<SongDTO> getSongs();

    SongDTO findSongById();

    String saveSong(SongDTO songDTO);

    String updateSong(SongDTO songDTO);

    String deleteSong(SongDTO songDTO);
}
