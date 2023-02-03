package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.ExceptionsHandler;
import org.springframework.http.HttpStatus;
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
        song.setPlayed(songDTO.getPlayed());
        song.setAlbum(songDTO.getAlbum());
        return song;
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setSongID(song.getSongID());
        songDTO.setTitle(song.getTitle());
        songDTO.setDuration(song.getDuration());
        songDTO.setPlayed(song.getPlayed());
        songDTO.setAlbum(song.getAlbum());
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
    public SongDTO saveSong(SongDTO songDTO) {
        return entityToDTO(songRepository.save(dtoToEntity(songDTO))) ;
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO, String songID) {
        Optional<Song> response = songRepository.findById(songID);
        if (response.isEmpty()) {
            throw new ExceptionsHandler("Song not found", HttpStatus.NOT_FOUND);
        }
        SongDTO oldSongDTO = entityToDTO(response.get());
        oldSongDTO.setTitle(songDTO.getTitle());
        oldSongDTO.setTitle(songDTO.getTitle());
        oldSongDTO.setDuration(songDTO.getDuration());
        oldSongDTO.setPlayed(songDTO.getPlayed());
        oldSongDTO.setAlbum(songDTO.getAlbum());
        return entityToDTO(songRepository.save(dtoToEntity(oldSongDTO)));
    }

    @Override
    public String deleteSong(String songID) {
        Optional<Song> response = songRepository.findById(songID);
        if (response.isEmpty()) {
            throw new ExceptionsHandler("Song not found", HttpStatus.NOT_FOUND);
        }
        songRepository.deleteById(songID);
        return ("The song with ID: " +songID+ " has been deleted.");
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

}
