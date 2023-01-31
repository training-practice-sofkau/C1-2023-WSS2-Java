package java.co.com.chartsofka.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.com.chartsofka.music.dto.SongDTO;
import java.co.com.chartsofka.music.entity.Song;
import java.co.com.chartsofka.music.repository.SongRepository;
import java.co.com.chartsofka.music.service.ISongService;
import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public Song dtoToEntity(SongDTO songDTO) {
        return new Song(songDTO.getSongID(), songDTO.getName(), songDTO.getDuration(), songDTO.getAlbumID(), songDTO.getPlayed());
    }

    @Override
    public SongDTO entityToDTO(Song song) {
        return new SongDTO(song.getSongID(), song.getName(), song.getDuration(), song.getAlbumID(), song.getPlayed());

    }

    @Override
    public List<Song> getSong() {
        // return songsRepository.findAll().stream.map(songDTO -> dtoToEntity(songDTO)).collect(Collectors.toList());
        return null;
    }

    @Override
    public Song findSongById(String songId) {
        // return dtoToEntity(songsRepository.findById(songId));
        return null;
    }

    @Override
    public String saveSong(SongDTO songDTO) {
        //  return songsRepository.save(songDTO).toString();
        return null;
    }

    @Override
    public Song updateSong(SongDTO songDTO) {
        // return dtoToEntity(songsRepository.update(songDTO));
        return null;
    }

    @Override
    public String deleteSong(String songID) {
        // songsRepository.deleteById(songID);
        return null;
    }
}
