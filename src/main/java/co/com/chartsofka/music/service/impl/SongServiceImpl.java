package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public SongDTO updateSong(String id, SongDTO songDTO) {
        Song songToUpdate = songRepository.findById(id).orElse(new Song());

        songToUpdate.setName(songDTO.getName());
        songToUpdate.setDuration(songDTO.getDuration());
        songToUpdate.setPlayed(songDTO.getPlayed());
        songToUpdate.setAlbum(songDTO.getAlbum());

        return entityToDTO(songRepository.save(songToUpdate));
    }

    @Override
    public String deleteSong(String idSong) {
        Song songToDelete = songRepository.findById(idSong).orElseThrow();
        songRepository.delete(songToDelete);
        return idSong;
    }

    public List<SongDTO> getMostReproducedSongs(){
        return (songRepository.findAll(Sort.by(Sort.Direction.DESC, "played"))).stream()
                .map(EntityToDTO::song).toList().subList(0, 10);
    }
}
