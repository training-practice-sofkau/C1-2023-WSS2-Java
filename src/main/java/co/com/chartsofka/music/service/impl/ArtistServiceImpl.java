package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.ArtistRepository;
import co.com.chartsofka.music.service.IArtistService;
import co.com.chartsofka.music.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements IArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return mapperUtil.dtoToArtist().apply(artistDTO);
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        return mapperUtil.artistToDTO().apply(artist);
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
        Artist update = dtoToEntity(artistDTO);
        Artist toUpdate = artistRepository.findById(update.getArtistID()).orElse(null);
        if(toUpdate != null){
            toUpdate.setName(update.getName());
            toUpdate.setType(update.getType());
            toUpdate.setCountry(update.getCountry());
            toUpdate.setEnterprise(update.getEnterprise());
            toUpdate.setDebutDate(update.getDebutDate());
            return entityToDTO(artistRepository.save(toUpdate));
        }
        return null;
    }

    @Override
    public void deleteArtist(String idArtist) {
        artistRepository.deleteById(idArtist);
    }
}
