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
        r.setAlbumID(album.getAlbumID());
        r.setTitle(album.getTitle());
        r.setTotalSongs(album.getTotalSongs());
        r.setYearRelease(album.getYearRelease());
        r.setGenre(album.getGenre());
        r.setArtistDTO(artist(album.getArtist()));

        return r;
    }

    public static ArtistDTO artist(Artist artist){
        ArtistDTO r = new ArtistDTO();
        r.setArtistID(artist.getArtistID());
        r.setName(artist.getName());
        r.setCountry(artist.getCountry());
        r.setDebutDate(artist.getDebutDate());
        r.setEnterprise(artist.getEnterprise());
        r.setType(artist.getType());
        //r.setAlbumsDTO(artist.getAlbums().stream().map(EntityToDTO::album).collect(Collectors.toList()));
        return r;
    }

    public static SongDTO entityToDTO(Song song) {
        SongDTO result = new SongDTO();
        result.setSongID(song.getSongID());
        result.setAlbumID(song.getAlbumID());
        result.setName(song.getName());
        result.setPlayed(song.getPlayed());
        result.setDuration(song.getDuration());
        return result;
    }
}
