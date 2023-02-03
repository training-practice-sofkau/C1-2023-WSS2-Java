package co.com.chartsofka.music.utils;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;

import java.util.stream.Collectors;

public class EntityToDTO {

    public static AlbumDTO album(Album album) {
        System.out.println("entered the album");
        AlbumDTO r = new AlbumDTO();
        r.setAlbumID(album.getAlbumID());
        r.setTitle(album.getTitle());
        r.setTotalSongs(album.getTotalSongs());
        r.setYearRelease(album.getYearRelease());
        r.setGenre(album.getGenre());
        r.setArtistDTO(artist(album.getArtist()));
        //r.setSongsDTO(album.getSong().stream().map(EntityToDTO::song).collect(Collectors.toList()));
        return r;
    }

    public static ArtistDTO artist(Artist artist) {
        System.out.println("entered the artist");
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

    public static SongDTO song(Song song) {
        SongDTO r = new SongDTO();
        r.setSongID(song.getSongID());
        r.setName(song.getName());
        r.setDuration(song.getDuration());
        r.setPlayed(song.getPlayed());
        r.setAlbumDTO(album(song.getAlbum()));
        return r;
    }
}
