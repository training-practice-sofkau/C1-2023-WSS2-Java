package co.com.chartsofka.music.service;


import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAllSongs();

    SongDTO findSongById(String idArtist);

    Song saveSong(SongDTO artistDTO);

    SongDTO updateSong(SongDTO artistDTO);

    String deleteSong(String idArtist);
}
