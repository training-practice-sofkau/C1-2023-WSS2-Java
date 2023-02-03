package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;
import java.util.stream.Stream;

public interface ISongService {
    //DTOs
    Song dtoToEntity(SongDTO songDTO);

    SongDTO entityToDTO(Song song);

    //CRUD
    List<SongDTO> findAllSongs();

    SongDTO findSongById(String idSong);

    SongDTO saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO songDTO);

    void deleteSong(String idSong);

    List<SongDTO> findMostPlayedSongs();

    List<SongDTO> findAllByAlbum(String albumId);
}
