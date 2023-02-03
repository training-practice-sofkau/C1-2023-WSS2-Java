package co.com.chartsofka.music.utils;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;
import org.modelmapper.ModelMapper;

public class EntityToDTO {

    static ModelMapper modelMapper = new ModelMapper();



    public static AlbumDTO album(Album album){

        //modelMapper.typeMap(Album.class, AlbumDTO.class)
        //        .addMapping(Album::getArtist, AlbumDTO::setArtistDTO);

        //AlbumDTO r = new AlbumDTO();
        //r.setAlbumID(album.getAlbumID());
        //r.setTitle(album.getTitle());
        //r.setTotalSongs(album.getTotalSongs());
        //r.setYearRelease(album.getYearRelease());
        //r.setGenre(album.getGenre());
        //r.setArtistDTO(EntityToDTO.artist(album.getArtist()));
        //r.setSongsDTO(album.getSongs().stream().map(EntityToDTO::song).collect(Collectors.toList()));
        return modelMapper.map(album, AlbumDTO.class);
    }

    public static ArtistDTO artist(Artist artist){

        //modelMapper.typeMap(Artist.class, ArtistDTO.class)
        //        .addMapping(Artist::getAlbums, ArtistDTO::setAlbumsDTO);
        //ArtistDTO r = new ArtistDTO();
        //r.setArtistID(artist.getArtistID());
        //r.setName(artist.getName());
        //r.setCountry(artist.getCountry());
        //r.setDebutDate(artist.getDebutDate());
        //r.setEnterprise(artist.getEnterprise());
        //r.setType(artist.getType());
        //r.setAlbumsDTO(artist.getAlbums().stream().map(EntityToDTO::album).collect(Collectors.toList()));
        return modelMapper.map(artist, ArtistDTO.class);
    }

    public static SongDTO song(Song song){
        //SongDTO songDTO = song(new Song());
//
        //songDTO.setSongID(song.getSongID());
        //songDTO.setName(song.getName());
        //songDTO.setDuration(song.getDuration());
        //songDTO.setPlayed(song.getPlayed());
        //songDTO.setAlbumDTO(album(song.getAlbum()));

        return null;
    }
}
