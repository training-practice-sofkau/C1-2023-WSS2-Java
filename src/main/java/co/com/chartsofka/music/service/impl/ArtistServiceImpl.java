package java.co.com.chartsofka.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.co.com.chartsofka.music.dto.ArtistDTO;
import java.co.com.chartsofka.music.entity.Artist;
import java.co.com.chartsofka.music.repository.ArtistRepository;
import java.co.com.chartsofka.music.service.IArtistService;
import java.util.List;

@Service
public class ArtistServiceImpl implements IArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return new Artist(artistDTO.getArtistID(), artistDTO.getCountry(), artistDTO.getDebutDate(), artistDTO.getEnterprise(), artistDTO.getType());
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        return new ArtistDTO(artist.getArtistID(), artist.getCountry(), artist.getDebutDate(), artist.getEnterprise(), artist.getType());

    }

    @Override
    public List<ArtistDTO> getArtist() {
        // return artistRepository.findAll().stream.map(artist -> entityToDTO(artist)).collect(Collectors.toList());

        return null;
    }

    @Override
    public ArtistDTO findArtistById(String artistId) {
        // return entityToDTO(artistRepository.findById(artistId));
        return null;
    }

    @Override
    public String saveArtist(Artist artist) {
        //  return artistRepository.save(dtoToEntity(artist)).toString();
        return null;
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        // return entityToDTO(artistRepository.update(dtoToEntity(artistDTO)));
        return null;
    }

    @Override
    public String deleteArtist(String artistId) {
        // artistRepository.deleteById(artistId);
        return null;
    }
}
