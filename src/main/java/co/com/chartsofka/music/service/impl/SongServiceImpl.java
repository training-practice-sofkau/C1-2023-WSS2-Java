package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.entity.Album;
import co.com.chartsofka.music.repository.AlbumRepository;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.repository.SongRepository;
import co.com.chartsofka.music.service.ISongService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return songRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SongDTO findSongById(String songId) {
        return entityToDTO(songRepository.findById(songId).orElse(new Song()));
    }

    @Override
    public SongDTO saveSong(SongDTO songDTO) {
        Optional<Album> album = albumRepository.findById(songDTO.getAlbumDTO().getAlbumID());
        if(album.isEmpty())return new SongDTO();
        Song r = dtoToEntity(songDTO);
        return entityToDTO(songRepository.save(r));
    }

    @Override
    public SongDTO updateSong(SongDTO songDTO) {
        return entityToDTO(songRepository.save(dtoToEntity(songDTO)));
    }

    @Override
    public void deleteSong(String songID) {
        songRepository.deleteById(songID);
    }
    @Override
    public List<SongDTO> getTopSongs(){
        List<SongDTO> songs = getSongs();
        if(songs.size()>10) {
            return songs.stream().sorted(Comparator.comparingLong(song->-song.getPlayed())).toList().subList(0, 10);
        }else{
            return songs.stream().sorted(Comparator.comparingLong(song->-song.getPlayed())).toList();
        }
    }
    @Override
    public List<SongDTO> getSongsFromAlbum(AlbumDTO albumDTO){
        return songRepository.findAllByAlbum(DTOToEntity.partialAlbum(albumDTO))
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}