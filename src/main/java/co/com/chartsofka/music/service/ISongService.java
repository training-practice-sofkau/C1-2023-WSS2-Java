package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    //To manage the DTO's - Entity dynamic
    Song dtoToEntity (SongDTO songDTO);
    SongDTO entityToDTO(Song song);

    //Basic operate
    List<SongDTO> getSongs();
    List<SongDTO> getPopularSongs();

    Optional<SongDTO> findSongById(String idSong);
    List<SongDTO> getSongsByAlmbunId(String idAlbum);

    SongDTO saveSong(SongDTO songDTO);

    SongDTO updateSong(String idSong, SongDTO songDTO);

    SongDTO deleteSong(String idSong);
}
