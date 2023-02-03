package co.com.chartsofka.music.utils;

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
        r.setArtist(artist(albumDTO.getArtistDTO()));
        r.setSong(albumDTO.getSongsDTO().stream().map((DTOToEntity::song)).collect(Collectors.toList()));

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
        Song r = new Song();
        r.setSongID(songDTO.getSongID());
        r.setName(songDTO.getName());
        r.setDuration(songDTO.getDuration());
        r.setPlayed(songDTO.getPlayed());
        r.setAlbum(album(songDTO.getAlbumDTO()));
        return r;
    }
}
