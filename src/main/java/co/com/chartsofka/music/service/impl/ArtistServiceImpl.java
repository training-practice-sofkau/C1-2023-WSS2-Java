package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.ArtistRepository;
import co.com.chartsofka.music.service.IArtistService;
import co.com.chartsofka.music.repository.utils.DTOToEntity;
import co.com.chartsofka.music.repository.utils.EntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public ArtistDTO saveArtist(ArtistDTO artistDTO) {
        return entityToDTO(artistRepository.save(dtoToEntity(artistDTO)));
    }

    @Override
    public ArtistDTO updateArtist(String id, ArtistDTO artistDTO) {
        Artist artistToUpdate = artistRepository.findById(id).orElse(new Artist());

        artistToUpdate.setCountry(artistDTO.getCountry());
        artistToUpdate.setDebutDate(artistDTO.getDebutDate());
        artistToUpdate.setEnterprise(artistDTO.getEnterprise());
        artistToUpdate.setName(artistDTO.getName());
        artistToUpdate.setType(artistDTO.getType());

        return entityToDTO(artistRepository.save(artistToUpdate));
    }

    @Override
    public String deleteArtist(String idArtist) {
        Artist artistToDelete = artistRepository.findById(idArtist).orElseThrow();
        artistRepository.delete(artistToDelete);
        return idArtist;
    }
}
