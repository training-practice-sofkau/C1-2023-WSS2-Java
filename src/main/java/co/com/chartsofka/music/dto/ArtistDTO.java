package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.dto.AlbumDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link co.com.chartsofka.music.entity.Artist} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO implements Serializable {
    private String artistID;
    private String name;
    private String country;
    private LocalDate debutDate;
    private String enterprise;
    private String type;
    private List<AlbumDTO> albums;
}