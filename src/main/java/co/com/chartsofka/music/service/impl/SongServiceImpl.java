package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

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
        return songRepository.findAll().stream().map(this::entityToDTO).toList();
    }

    @Override
    public SongDTO findSongById(String idSong) {

        Optional<Song> s = songRepository.findById(idSong);

        return s.map(this::entityToDTO).orElse(null);

    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {

        return entityToDTO(songRepository.save(dtoToEntity(songDTO)));

    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        Optional<Song> s = songRepository.findById(songDTO.getSongID());
        Optional<Album> album = albumRepository.findById(songDTO.getAlbumID().getAlbumID());

        if(s.isEmpty() || album.isEmpty()) return null;

        s.get().setName(songDTO.getName());
        s.get().setAlbumID(album.get());
        s.get().setDuration(songDTO.getDuration());
        s.get().setPlayed(songDTO.getPlayed());

        return entityToDTO(songRepository.save(s.get()));
    }

    @Override
    public String deleteSong(String idSong) {

        Optional<Song> s = songRepository.findById(idSong);

        if(s.isEmpty()) return null;

        songRepository.delete(s.get());

        return "Song "+s.get().getName()+" was deleted";
    }

}
