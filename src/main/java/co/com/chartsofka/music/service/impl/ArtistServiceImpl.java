package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.AlbumDTO;
import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.repository.AlbumRepository;
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
    @Autowired
    private AlbumRepository albumRepository;


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
    public Optional<ArtistDTO> findArtistById(String idArtist) {
        return artistRepository.findById(idArtist).map(EntityToDTO::artist);
    }

    @Override
    public ArtistDTO saveArtist(ArtistDTO artistDTO) {
        List<AlbumDTO> dtoList = artistDTO.getAlbumsDTO();
        if (dtoList.stream().anyMatch(i->albumRepository.findById(i.getAlbumIDDTO()).isEmpty()))
            return null;
        else return entityToDTO(artistRepository.save(dtoToEntity(artistDTO)));
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        Optional<Artist> artistUpdate =
                artistRepository.findById(artistDTO.getArtistIDDTO());
        List<AlbumDTO> albumDTOS = artistDTO.getAlbumsDTO();
        if (artistUpdate.isEmpty() || albumDTOS.stream()
                .anyMatch(i->albumRepository.findById(i.getAlbumIDDTO()).isEmpty()))
        return null;
        else {
            artistUpdate.get().setName(artistDTO.getNameDTO());
            artistUpdate.get().setCountry(artistDTO.getCountryDTO());
            artistUpdate.get().setDebutDate(artistDTO.getDebutDateDTO());
            artistUpdate.get().setEnterprise(artistDTO.getEnterpriseDTO());
            artistUpdate.get().setType(artistDTO.getTypeDTO());
            artistUpdate.get().setAlbums(artistDTO.getAlbumsDTO().stream()
                    .map(i->DTOToEntity.album(i))
                    .collect(Collectors.toList()));
            return entityToDTO(artistRepository.save(artistUpdate.get()));
        }
    }

    @Override
    public String deleteArtist(String idArtist) {
        Optional<ArtistDTO> artistDTO = this.findArtistById(idArtist);
        if (artistDTO.isEmpty()) return null;
        else {
            artistRepository.deleteById(idArtist);
            return "Artist with id: " + idArtist + " was deleted successfully";
        }
    }
}
