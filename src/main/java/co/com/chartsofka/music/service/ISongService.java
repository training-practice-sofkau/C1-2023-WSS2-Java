package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Song dtoToEntity (SongDTO songDTO);
    SongDTO entityToDTO(Song song);

    //Basic operate
    List<SongDTO> getSongs();

    List<SongDTO> tenMostReproduced();

    List<SongDTO> getbyAlbum(String idAlbum);

    Optional<SongDTO> findSongById(String idSong);

    SongDTO saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO songDTO);

    String deleteSong(String idSong);
}
