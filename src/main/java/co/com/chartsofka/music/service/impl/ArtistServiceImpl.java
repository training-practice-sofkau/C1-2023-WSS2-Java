package co.com.chartsofka.music.service.impl;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.service.IArtistService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ArtistServiceImpl implements IArtistService{

    private ModelMapper modelMapper;

    public ArtistServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return modelMapper.map(artistDTO, Artist.class);
    }

    @Override
    public ArtistDTO entityToDTO(Artist artist) {
        return modelMapper.map(artist, ArtistDTO.class);
    }

    @Override
    public List<ArtistDTO> getArtists() {
        return null;
    }

    @Override
    public ArtistDTO findArtistById(String artistID) {
        return null;
    }

    @Override
    public String saveArtist(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public String deleteArtist(String artistID) {
        return null;
    }
}
