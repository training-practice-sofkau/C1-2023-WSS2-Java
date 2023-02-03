package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.ArtistRepository;
import co.com.chartsofka.music.service.IArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements IArtistService {


    private ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository repository) {
        this.artistRepository = repository;
    }

    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        artist.setArtistID(artistDTO.getArtistID());
        artist.setCountry(artistDTO.getCountry());
        artist.setDebutDate(artistDTO.getDebutDate());
        artist.setEnterprise(artistDTO.getEnterprise());
        artist.setType(artistDTO.getType());
        return artist;
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setArtistID(artist.getArtistID());
        artistDTO.setCountry(artist.getCountry());
        artistDTO.setDebutDate(artist.getDebutDate());
        artistDTO.setEnterprise(artist.getEnterprise());
        artistDTO.setType(artist.getType());
        return artistDTO;
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
    public String saveArtist(ArtistDTO artistDTO) {
        artistRepository.save(dtoToEntity(artistDTO));
        return "Ok";
    }
    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public String deleteArtist(String idArtist) {
        return null;
    }
}
