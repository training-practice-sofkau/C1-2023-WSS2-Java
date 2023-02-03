package co.com.chartsofka.music.repository.utils;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;

import java.util.stream.Collectors;

public class DTOToEntity {
    public static Album album(AlbumDTO albumDTO){
        Album r = new Album();
        r.setAlbumID(albumDTO.getAlbumID());
        r.setTitle(albumDTO.getTitle());
        r.setTotalSongs(albumDTO.getTotalSongs());
        r.setYearRelease(albumDTO.getYearRelease());
        r.setGenre(albumDTO.getGenre());
        r.setArtist(albumDTO.getArtist());
        r.setSongs(albumDTO.getSongs());

        return r;
    }

    public static Artist artist(ArtistDTO artistDTO){
        Artist r = new Artist();
        r.setArtistID(artistDTO.getArtistID());
        r.setName(artistDTO.getName());
        r.setCountry(artistDTO.getCountry());
        r.setDebutDate(artistDTO.getDebutDate());
        r.setEnterprise(artistDTO.getEnterprise());
        r.setType(artistDTO.getType());
        r.setAlbums(artistDTO.getAlbumsDTO().stream().map(DTOToEntity::album).collect(Collectors.toList()));
        return r;
    }

    public static Song song(SongDTO songDTO){
        Song song = new Song();

        song.setSongID(songDTO.getSongID());
        song.setName(songDTO.getName());
        song.setDuration(songDTO.getDuration());
        song.setAlbumID(songDTO.getAlbumID());
        song.setPlayed(songDTO.getPlayed());
        song.setAlbum(songDTO.getAlbum());

        return song;
    }
}
