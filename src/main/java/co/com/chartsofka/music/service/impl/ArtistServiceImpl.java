package co.com.chartsofka.music.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import co.com.chartsofka.music.exceptions.ToDoExceptions;
import org.modelmapper.ModelMapper;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.com.chartsofka.music.service.IArtistService;
import co.com.chartsofka.music.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements IArtistService{

    private final ModelMapper modelMapper;
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ModelMapper modelMapper, ArtistRepository artistRepository) {
        this.modelMapper = modelMapper;
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return modelMapper.map(artistDTO, Artist.class);
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        return modelMapper.map(artist, ArtistDTO.class);
    }

    @Override
    public ArtistDTO getArtistById(String artistID) {
        Optional<Artist> response = artistRepository.findById(artistID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Artist not found", HttpStatus.NOT_FOUND);
        }
        return entityToDTO(response.get());
    }

    @Override
    public List<ArtistDTO> getArtists() {
        return artistRepository.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public void saveArtist(ArtistDTO artistDTO) {
        artistRepository.save(dtoToEntity(artistDTO));
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        String artistID = artistDTO.getArtistID();
        Optional<Artist> response = artistRepository.findById(artistID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Artist not found", HttpStatus.NOT_FOUND);
        }
        artistRepository.save(dtoToEntity(artistDTO));
        return artistDTO;
    }

    @Override
    public void deleteArtist(String artistID) {
        Optional<Artist> response = artistRepository.findById(artistID);
        if (response.isEmpty()) {
            throw new ToDoExceptions("Artist not found", HttpStatus.NOT_FOUND);
        }
        artistRepository.deleteById(artistID);
    }
}
