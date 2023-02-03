package co.com.chartsofka.music.utils;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;

import java.util.Optional;
import java.util.stream.Collectors;

public class DTOToEntity {
    public static Album album(AlbumDTO albumDTO){
        Album r = new Album();
        r.setAlbumID(albumDTO.getAlbumIDDTO());
        r.setTitle(albumDTO.getTitleDTO());
        r.setTotalSongs(albumDTO.getTotalSongsDTO());
        r.setYearRelease(albumDTO.getYearReleaseDTO());
        r.setGenre(albumDTO.getGenreDTO());
        r.setArtist(artist(albumDTO.getArtistDTO()));
        r.setSongs(albumDTO
                .getSongsDTO()
                .stream()
                .map(DTOToEntity::song)
                .collect(Collectors
                        .toList()));

        return r;
    }

    public static Artist artist(ArtistDTO artistDTO){
        Artist r = new Artist();
        r.setArtistID(artistDTO.getArtistIDDTO());
        r.setName(artistDTO.getNameDTO());
        r.setCountry(artistDTO.getCountryDTO());
        r.setDebutDate(artistDTO.getDebutDateDTO());
        r.setEnterprise(artistDTO.getEnterpriseDTO());
        r.setType(artistDTO.getTypeDTO());
        r.setAlbums(artistDTO
                .getAlbumsDTO()
                .stream()
                .map(DTOToEntity::album)
                .collect(Collectors
                        .toList()));
        return r;
    }

    public static Song song(SongDTO songDTO) {
        Song r = new Song();

        r.setSongID(songDTO.getSongIDDTO());
        r.setName(songDTO.getNameDTO());
        r.setDuration(songDTO.getDurationDTO());
        r.setAlbum(album(songDTO.getAlbumDTO()));
        r.setPlayed(songDTO.getPlayedDTO());
        return r;
    }
}
