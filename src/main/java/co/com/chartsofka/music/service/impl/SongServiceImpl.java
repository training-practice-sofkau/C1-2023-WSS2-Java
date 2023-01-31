package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.service.ISongService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class SongServiceImpl implements ISongService {

    private ModelMapper modelMapper;

    public SongServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        return modelMapper.map(songDTO, Song.class);
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        return modelMapper.map(song, SongDTO.class);
    }

    @Override
    public List<SongDTO> getSongs() {
        return null;
    }

    @Override
    public SongDTO findSongById(String songID) {
        return null;
    }

    @Override
    public String saveSong(SongDTO songDTO) {
        return null;
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        return null;
    }

    @Override
    public String deleteSong(String songID) {
        return null;
    }
}
