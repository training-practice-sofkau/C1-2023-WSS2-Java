package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        return DTOToEntity.song(songDTO);
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        return EntityToDTO.song(song);
    }

    @Override
    public List<SongDTO> findAllSongs() {
        return songRepository.findAll()
                .stream()
                .map(EntityToDTO::song)
                .collect(Collectors.toList());
    }

    @Override
    public SongDTO findSongById(String idSong) {
        return songRepository.findById(idSong)
                .map(EntityToDTO::song)
                .orElse(null);
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {
        return EntityToDTO.song(songRepository.save(DTOToEntity.song(songDTO)));
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        Song update = DTOToEntity.song(songDTO);
        Song toUpdate = songRepository.findById(update.getSongID()).orElse(null);
        if(toUpdate != null){
            toUpdate.setName(update.getName());
            toUpdate.setAlbumID(update.getAlbumID());
            toUpdate.setDuration(update.getDuration());
            toUpdate.setPlayed(update.getPlayed());
            return EntityToDTO.song(songRepository.save(toUpdate));
        }
        return null;
    }

    @Override
    public void deleteSong(String idSong) {
        songRepository.deleteById(idSong);
    }
}
