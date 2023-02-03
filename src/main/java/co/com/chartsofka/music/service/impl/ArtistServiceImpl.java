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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements IArtistService {

    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

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

    /*@Override
    public List<ArtistDTO> findArtistByName(String artistName) {
        return artistRepository.findByName(artistName);
    }*/

    @Override
    public ArtistDTO saveArtist(ArtistDTO artistDTO) {
        /*List<ArtistDTO> artistDTO1 = this.findArtistByName(artistDTO.getNameDTO());
        return artistDTO1.isEmpty() ? entityToDTO(artistRepository.save(dtoToEntity(artistDTO))):
                null;*/
        List<AlbumDTO> albumDTOS = artistDTO.getAlbumsDTO();
        if (!albumDTOS.isEmpty()){
            List<Integer> albumDTONotFound = new ArrayList<>();
            albumDTOS.stream().forEach(i->{
                Optional<AlbumDTO> albumDTO = albumRepository.findById(i.getAlbumIDDTO()).map(EntityToDTO::album);
                if (albumDTO.isEmpty()) albumDTONotFound.add(1);

            });
            if (!albumDTONotFound.isEmpty()) return null;
        }
        return entityToDTO(artistRepository.save(dtoToEntity(artistDTO)));
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        Optional<Artist> artistUpdate =
                artistRepository.findById(artistDTO.getArtistIDDTO());
        List<AlbumDTO> albumDTOS = artistDTO.getAlbumsDTO();
        if (artistUpdate.isEmpty()) return null;
        else if (!albumDTOS.isEmpty()) {
            List<Integer> albumDTONotFound = new ArrayList<>();
            albumDTOS.stream().forEach(i->{
                Optional<AlbumDTO> albumDTO = albumRepository.findById(i.getAlbumIDDTO())
                        .map(EntityToDTO::album); if (albumDTO.isEmpty()) albumDTONotFound.add(1);

            });
            if (!albumDTONotFound.isEmpty()) return null;
        }
        else {
            artistUpdate.get().setName(artistDTO.getNameDTO());
            artistUpdate.get().setCountry(artistDTO.getCountryDTO());
            artistUpdate.get().setDebutDate(artistDTO.getDebutDateDTO());
            artistUpdate.get().setEnterprise(artistDTO.getEnterpriseDTO());
            artistUpdate.get().setType(artistDTO.getTypeDTO());
            artistUpdate.get().
                    setAlbums(artistDTO
                            .getAlbumsDTO()
                            .stream().map(DTOToEntity::album)
                            .collect(Collectors.toList()));
        }
        return entityToDTO(artistRepository.save(artistUpdate.get()));
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
