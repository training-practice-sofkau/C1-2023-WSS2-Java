package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.ArtistRepository;
import co.com.chartsofka.music.service.IArtistService;
import co.com.chartsofka.music.utils.DTOToEntity;
import co.com.chartsofka.music.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements IArtistService {
    @Autowired
    ArtistRepository artistRepository;


    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return DTOToEntity.artist(artistDTO);
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        return EntityToDTO.artist(artist);
    }

    @Override
    public List<ArtistDTO> getArtists() {
        return artistRepository.findAll()
                .stream().map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArtistDTO findArtistById(String idArtist) {
        return entityToDTO(artistRepository.findById(idArtist).orElse(new Artist()));
    }

    public List<ArtistDTO> findArtistByType(String typeArtist){
        return artistRepository.findAll()
                .stream()
                .filter(artist -> Objects.equals(artist.getType(), typeArtist))
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArtistDTO saveArtist(ArtistDTO artistDTO) {
        return entityToDTO(artistRepository.save(dtoToEntity(artistDTO)));
    }

    @Override
    public ArtistDTO updateArtist(String idArtist, ArtistDTO artistDTO) {
        var artistBody = artistRepository.findById(idArtist)
                .map(artist -> {
                    artist.setName(artistDTO.getName());
                    artist.setCountry(artistDTO.getCountry());
                    artist.setDebutDate(artistDTO.getDebutDate());
                    artist.setEnterprise(artistDTO.getEnterprise());
                    artist.setType(artistDTO.getType());
                    return artistRepository.save(artist);
                }).orElse(new Artist());
        return entityToDTO(artistBody);
    }

    @Override
    public ArtistDTO deleteArtist(String idArtist) {
        var artist = artistRepository.findById(idArtist).orElse(new Artist());
        artistRepository.delete(artist);
        return entityToDTO(artist);
    }
}
