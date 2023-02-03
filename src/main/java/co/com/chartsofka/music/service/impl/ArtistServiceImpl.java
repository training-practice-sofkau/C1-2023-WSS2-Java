package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.ArtistRepository;
import co.com.chartsofka.music.service.IArtistService;
import co.com.chartsofka.music.utils.ExceptionsHandler;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements IArtistService {


    private ArtistRepository artistRepository;
    private ModelMapper modelMapper;

    public ArtistServiceImpl(ArtistRepository repository, ModelMapper modelMapper) {
        this.artistRepository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        artist.setArtistID(artistDTO.getArtistID());
        artist.setName(artistDTO.getName());
        artist.setCountry(artistDTO.getCountry());
        artist.setDebutDate(artistDTO.getDebutDate());
        artist.setEnterprise(artistDTO.getEnterprise());
        artist.setType(artistDTO.getType());
        //return artist;
        return modelMapper.map(artistDTO, Artist.class);
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setArtistID(artist.getArtistID());
        artistDTO.setName(artist.getName());
        artistDTO.setCountry(artist.getCountry());
        artistDTO.setDebutDate(artist.getDebutDate());
        artistDTO.setEnterprise(artist.getEnterprise());
        artistDTO.setType(artist.getType());
        //return artistDTO;
        return modelMapper.map(artist, ArtistDTO.class);
    }

    @Override
    public List<ArtistDTO> getArtists() {
        return artistRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArtistDTO> getArtistsByType(String type){
        return artistRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .filter(artistDTO -> artistDTO.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public ArtistDTO findArtistById(String idArtist) {
        return null;
    }

    @Override
    public ArtistDTO saveArtist(ArtistDTO artistDTO) {
        return entityToDTO(artistRepository.save(dtoToEntity(artistDTO)));

    }



    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO, String artistID) {
        Optional<Artist> response = artistRepository.findById(artistID);
        if (response.isEmpty()) {
            throw new ExceptionsHandler("Artist not found", HttpStatus.NOT_FOUND);
        }
        ArtistDTO oldArtistDTO = entityToDTO(response.get());
        oldArtistDTO.setName(artistDTO.getName());
        oldArtistDTO.setCountry(artistDTO.getCountry());
        oldArtistDTO.setDebutDate(artistDTO.getDebutDate());
        oldArtistDTO.setEnterprise(artistDTO.getEnterprise());
        oldArtistDTO.setType(artistDTO.getType());
        oldArtistDTO.setAlbums(artistDTO.getAlbums());

        return entityToDTO(artistRepository.save(dtoToEntity(oldArtistDTO)));
    }

    @Override
    public String deleteArtist(String artistID) {
        Optional<Artist> response = artistRepository.findById(artistID);
        if (response.isEmpty()) {
            throw new ExceptionsHandler("Artist not found", HttpStatus.NOT_FOUND);
        }
        artistRepository.deleteById(artistID);
        return ("The artist with ID: " +artistID+ " has been deleted.");
    }
}
