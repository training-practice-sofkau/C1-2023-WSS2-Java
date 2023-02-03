package co.com.chartsofka.music.utils;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

public class DTOToEntity {

    static ModelMapper modelMapper = new ModelMapper();
    public static Album album(AlbumDTO albumDTO){

        //modelMapper.typeMap(AlbumDTO.class, Album.class)
        //        .addMapping(AlbumDTO::getArtistDTO, Album::setArtist);

        //r.setAlbumID(albumDTO.getAlbumID());
        //r.setTitle(albumDTO.getTitle());
        //r.setTotalSongs(albumDTO.getTotalSongs());
        //r.setYearRelease(albumDTO.getYearRelease());
        //r.setGenre(albumDTO.getGenre());
        //r.setArtist(DTOToEntity.artist(albumDTO.getArtistDTO()));
        //r.setSongs(albumDTO.getSongsDTO().stream().map(DTOToEntity::song).collect(Collectors.toList()));

        return modelMapper.map(albumDTO, Album.class);
    }

    public static Artist artist(ArtistDTO artistDTO){

        //modelMapper.typeMap(ArtistDTO.class, Artist.class)
        //        .addMapping(ArtistDTO::getAlbumsDTO, Artist::setAlbums);
        //Artist r = new Artist();
        //r.setArtistID(artistDTO.getArtistID());
        //r.setName(artistDTO.getName());
        //r.setCountry(artistDTO.getCountry());
        //r.setDebutDate(artistDTO.getDebutDate());
        //r.setEnterprise(artistDTO.getEnterprise());
        //r.setType(artistDTO.getType());
        //r.setAlbums(artistDTO.getAlbumsDTO().stream().map(DTOToEntity::album).collect(Collectors.toList()));
        return modelMapper.map(artistDTO, Artist.class);
    }

    public static Song song(SongDTO songDTO){
        Song song = new Song();

        song.setSongID(songDTO.getSongID());
        song.setName(songDTO.getName());
        song.setDuration(songDTO.getDuration());
        song.setPlayed(songDTO.getPlayed());
        //song.setAlbum(album(songDTO.getAlbumDTO()));

        return song;
    }
}
