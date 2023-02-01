package co.com.chartsofka.music.service;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;

import java.util.List;

public interface IArtistService {
    Artist dtoToEntity (ArtistDTO artistDTO);
    ArtistDTO entityToDTO (Artist artist);

    List<ArtistDTO> getArtists();
    ArtistDTO findByID(String artistID);
    String save(ArtistDTO artistDTO);
    ArtistDTO update(ArtistDTO artistDTO);
    String delete(String artistID);
}
