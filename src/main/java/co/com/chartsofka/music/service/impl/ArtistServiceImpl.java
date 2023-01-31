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
    public List<Artist> getArtist() {
        // return artistRepository.findAll().stream.map(artistDTO -> dtoToEntity(artistDTO)).collect(Collectors.toList());

        return null;
    }

    @Override
    public Artist findArtistById(String artistId) {
        // return dtoToEntity(artistRepository.findById(artistId));
        return null;
    }

    @Override
    public String saveArtist(ArtistDTO artistDTO) {
        //  return artistRepository.save(artistDTO).toString();
        return null;
    }

    @Override
    public Artist updateArtist(ArtistDTO artistDTO) {
        // return dtoToEntity(artistRepository.update(artistDTO));
        return null;
    }

    @Override
    public String deleteArtist(String artistId) {
        // artistRepository.deleteById(artistId);
        return null;
    }
}
