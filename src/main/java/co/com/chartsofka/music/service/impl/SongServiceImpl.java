package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    MapperUtil mapperUtil;

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        return mapperUtil.dtoToSongWithAlbum().apply(songDTO);
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        return mapperUtil.songToDTOWithAlbum().apply(song);
    }

    @Override
    public List<SongDTO> findAllSongs() {
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SongDTO findSongById(String idSong) {
        return songRepository.findById(idSong)
                .map(this::entityToDTO)
                .orElse(null);
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {
        return entityToDTO(songRepository.save(dtoToEntity(songDTO)));
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        Song update = dtoToEntity(songDTO);
        Song toUpdate = songRepository.findById(update.getSongID()).orElse(null);
        if(toUpdate != null){
            toUpdate.setName(update.getName());
            toUpdate.setAlbum(update.getAlbum());
            toUpdate.setDuration(update.getDuration());
            toUpdate.setPlayed(update.getPlayed());
            return entityToDTO(songRepository.save(toUpdate));
        }
        return null;
    }

    @Override
    public void deleteSong(String idSong) {
        songRepository.deleteById(idSong);
    }
}
