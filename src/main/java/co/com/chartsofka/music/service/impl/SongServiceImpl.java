package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements ISongService {

    private SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        Song song = new Song();
        song.setSongID(songDTO.getSongID());
        song.setTitle(songDTO.getTitle());
        song.setDuration(songDTO.getDuration());
        song.setAlbum(songDTO.getAlbum());
        song.setPlayed(songDTO.getPlayed());
        return song;
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setSongID(song.getSongID());
        songDTO.setTitle(song.getTitle());
        songDTO.setDuration(song.getDuration());
        songDTO.setAlbum(song.getAlbum());
        songDTO.setPlayed(song.getPlayed());
        return songDTO;
    }

    @Override
    public List<SongDTO> getSongs() {
        return songRepository.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public SongDTO findSongById(String idSong) {
        return null;
    }

    @Override
    public String saveSong(SongDTO songDTO) {

        songRepository.save(dtoToEntity(songDTO));
        return "Ok";
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        return null;
    }

    @Override
    public String deleteSong(String idSong) {
        return null;
    }

    @Override
    public List<SongDTO> getSongsTop() {
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .sorted((song1, song2)->song2.getPlayed().compareTo(song1.getPlayed()))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public List<SongDTO> getSongsByAlbum(String albumID){
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .filter(song -> song.getAlbum().getAlbumID() == albumID)
                .collect(Collectors.toList());
    }
}
