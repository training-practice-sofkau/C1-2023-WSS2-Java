package co.com.chartsofka.music.service;


import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Song dtoToEntity (SongDTO songDTO);
    SongDTO entityToDTO(Song song);
    List<Song> getAllSongs();

    Optional<SongDTO> findSongById(String idSong);

    Song saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO artistDTO);

    String deleteSong(String idArtist);
}
