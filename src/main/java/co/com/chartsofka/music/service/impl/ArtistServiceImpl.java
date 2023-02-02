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
import java.util.Optional;
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
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {

        Optional<Artist> a = artistRepository.findById(artistDTO.getArtistID());

        if(a.isEmpty()) return null;

        a.get().setName(artistDTO.getName());
        a.get().setCountry(artistDTO.getCountry());
        a.get().setDebutDate(artistDTO.getDebutDate());
        a.get().setEnterprise(artistDTO.getEnterprise());
        a.get().setType(artistDTO.getType());

        return entityToDTO(artistRepository.save(a.get()));
    }

    @Override
    public String deleteArtist(String idArtist) {

        Optional<Artist> a = artistRepository.findById(idArtist);

        if(a.isEmpty()) return null;

        artistRepository.delete(a.get());

        return "Artis "+a.get().getName()+" was deleted from our system";
    }
}
