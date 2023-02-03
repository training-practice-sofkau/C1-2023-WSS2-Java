package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
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
    public Song dtoToEntity(SongDTO songDTO) {return DTOToEntity.song(songDTO);}

    @Override
    public SongDTO entityToDTO(Song song) {
        return EntityToDTO.song(song);
    }

    @Override
    public List<SongDTO> getSongs() {
        return songRepository.findAll()
                .stream().map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SongDTO findSongById(String idSong) {
        return entityToDTO(songRepository.findById(idSong).orElse(new Song()));
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {

        return entityToDTO(songRepository.save(dtoToEntity(songDTO)));
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO, String songID) {
        SongDTO song = entityToDTO(songRepository.findById(songID).orElse(new Song()));

        if (song.getSongID() == null) {
            return song;
        } else {
            song.setTitle(songDTO.getTitle());
            song.setDuration(songDTO.getDuration());
            song.setPlayed(songDTO.getPlayed());
            song.setAlbumDTO(songDTO.getAlbumDTO());

            songRepository.save(dtoToEntity(song));

            return song;
        }
    }

    @Override
    public String deleteSong(String idSong) {
        try {
            songRepository.deleteById(idSong);
            return "Deleted";
        }
        catch (Exception e){
            System.out.println(e);
            return "Unsuccessful";
        }
    }
}
