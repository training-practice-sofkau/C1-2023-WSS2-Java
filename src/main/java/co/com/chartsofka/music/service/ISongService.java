package co.com.chartsofka.music.service;

import java.util.List;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;

public interface ISongService {

    //To manage the DTOs - Entity dynamic
    Song dtoToEntity (SongDTO songDTO);
    SongDTO entityToDTO(Song song);

    //Basic operations
    List<SongDTO> getSongs();

    SongDTO getSongById(String songID);

    void saveSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO songDTO);

    void deleteSong(String songID);

    //Customized operations
    List<SongDTO> getTopTenSongs();

}
