package co.com.chartsofka.music.utils;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;

import java.util.stream.Collectors;

public class EntityToDTO {
    public static AlbumDTO album(Album album){
        AlbumDTO r = new AlbumDTO();
        r.setAlbumIDDTO(album.getAlbumID());
        r.setTitleDTO(album.getTitle());
        r.setTotalSongsDTO(album.getTotalSongs());
        r.setYearReleaseDTO(album.getYearRelease());
        r.setGenreDTO(album.getGenre());
        r.setArtistDTO(artist(album.getArtist()));
        /*r.setSongsDTO(album
                .getSongs()
                .stream()
                .map(EntityToDTO::song)
                .collect(Collectors.toList()));*/

        return r;
    }

    public static ArtistDTO artist(Artist artist){
        ArtistDTO r = new ArtistDTO();
        r.setArtistIDDTO(artist.getArtistID());
        r.setNameDTO(artist.getName());
        r.setCountryDTO(artist.getCountry());
        r.setDebutDateDTO(artist.getDebutDate());
        r.setEnterpriseDTO(artist.getEnterprise());
        r.setTypeDTO(artist.getType());
        /*r.setAlbumsDTO(artist
                .getAlbums()
                .stream()
                .map(EntityToDTO::album)
                .collect(Collectors.toList()));*/
        return r;
    }

    public static SongDTO song(Song song) {
        SongDTO r = new SongDTO();

        r.setSongIDDTO(song.getSongID());
        r.setNameDTO(song.getName());
        r.setDurationDTO(song.getDuration());
        r.setPlayedDTO(song.getPlayed());
        r.setAlbumDTO(album(song.getAlbum()));

        return r;
    }
}
