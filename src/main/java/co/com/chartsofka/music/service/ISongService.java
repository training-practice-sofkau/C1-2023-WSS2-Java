package co.com.chartsofka.music.service;

import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.dto.SongDTO;

import java.util.*;

public interface ISongService {
    Song dtoToEntity (SongDTO songDTO);
    SongDTO entityToDTO (Song song);

    List<SongDTO> getSongs();
    SongDTO findByID(String songID);
    String save(SongDTO songDTO);
    SongDTO update(SongDTO songDTO);
    String delete(String songID);
}
