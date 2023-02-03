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
    public ArtistDTO updateArtist(ArtistDTO artistDTO, String artistID) {
        ArtistDTO artist = entityToDTO(artistRepository.findById(artistID).orElse(new Artist()));

        if (artist.getArtistID() == null){
            return artist;
        }
        else {
            artist.setName(artistDTO.getName());
            artist.setCountry(artistDTO.getCountry());
            artist.setDebutDate(artistDTO.getDebutDate());
            artist.setEnterprise(artistDTO.getEnterprise());
            artist.setType(artistDTO.getType());
            artist.setAlbumsDTO(artistDTO.getAlbumsDTO());

            artistRepository.save(dtoToEntity(artist));

            return artist;
        }

    }

    @Override
    public String deleteArtist(String idArtist) {
        try {
            artistRepository.deleteById(idArtist);
            return "Deleted";
        }
        catch (Exception e){
            System.out.println(e);
            return "Unsuccessful";
        }
    }
}
