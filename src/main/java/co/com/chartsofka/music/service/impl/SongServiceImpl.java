package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.ISongService;

import java.util.List;

public class SongServiceImpl implements ISongService {
    @Override
    public Song dtoToEntity(SongDTO songDTO){
        Song s = new Song();

        s.setSongID(songDTO.getSongID());
        s.setName(songDTO.getName());
        s.setDuration(songDTO.getDuration());
        s.setAlbumID(songDTO.getAlbumID());
        s.setPlayed(songDTO.getPlayed());

        return s;
    }

    @Override
    public SongDTO entityToDto(Song song){
        SongDTO sd = new SongDTO();

        sd.setSongID(song.getSongID());
        sd.setName(song.getName());
        sd.setDuration(song.getDuration());
        sd.setAlbumID(song.getAlbumID());
        sd.setPlayed(song.getPlayed());

        return sd;
    }

    @Override
    public List<SongDTO> getSongs(){return null;}

    @Override
    public SongDTO findSongById(){return null;}
    @Override
    public String saveSong(SongDTO songDTO){return null;}
    @Override
    public String updateSong(SongDTO songDTO){return null;}
    @Override
    public String deleteSong(SongDTO songDTO){return null;}

}
