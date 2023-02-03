package co.com.chartsofka.music.service;


import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Song dtoToEntity (SongDTO songDTO);
    SongDTO entityToDTO(Song song);
    List<SongDTO> getAllSongs();

    Optional<SongDTO> findSongById(String idSong);

    SongDTO saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO artistDTO);

    String deleteSong(String idArtist);
}
