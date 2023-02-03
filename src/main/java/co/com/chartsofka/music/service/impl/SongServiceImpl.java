package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
    public List<Song> getSongs() {
        return songRepository.findAll()
                ;
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
    public SongDTO updateSong(SongDTO songDTO) {

        return entityToDTO(songRepository.save(dtoToEntity(songDTO)));
    }

    @Override
    public String deleteSong(String idSong) {
        Optional<Song> d = songRepository.findById(idSong);
        if(d.isEmpty())return null;


        else {
            songRepository.deleteById(idSong);
            return "Song deleted";


        //return songRepository.delete(songRepository.findById(idSong));
        }
    }
    @Override
    public List<Song> getSongsTop() {
        return songRepository.findAll().stream().sorted(Comparator.comparing(Song::getPlayed).reversed()).limit(10).collect(Collectors.toList());
    }
    @Override
    public List<Song> getSongsByAlbumID(String albumID) {
        return songRepository.findAllById(albumID));
    }
}
