package co.com.chartsofka.music.service.impl;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.exceptions.ToDoExceptions;
import co.com.chartsofka.music.repository.SongRepository;

@Service
public class SongServiceImpl implements ISongService {

    private final ModelMapper modelMapper;
    private final SongRepository songRepository;

    public SongServiceImpl(ModelMapper modelMapper, SongRepository songRepository) {
        this.modelMapper = modelMapper;
        this.songRepository = songRepository;
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
    public SongDTO getSongById(String songID) {
        Optional<Song> response = songRepository.findById(songID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Song not found", HttpStatus.NOT_FOUND);
        }
        return entityToDTO(response.get());
    }

    @Override
    public List<SongDTO> getTopTenSongs() {
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .sorted((song1, song2)->song2.getPlayed().compareTo(song1.getPlayed()))
                .limit(10)
                .toList();
    }

    @Override
    public List<SongDTO> getSongs() {
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .toList();
    }

    @Override
    public void saveSong(SongDTO songDTO) {
        songRepository.save(dtoToEntity(songDTO));
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        String songID = songDTO.getSongID();
        Optional<Song> response = songRepository.findById(songID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Song not found", HttpStatus.NOT_FOUND);
        }
        songRepository.save(dtoToEntity(songDTO));
        return songDTO;
    }

    @Override
    public void deleteSong(String songID) {
        Optional<Song> response = songRepository.findById(songID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Song not found", HttpStatus.NOT_FOUND);
        }
        songRepository.deleteById(songID);
    }
}
