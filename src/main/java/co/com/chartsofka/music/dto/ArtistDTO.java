package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link co.com.chartsofka.music.entity.Artist} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO implements Serializable {
    private String artistID;
    private String name;
    private String country;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate debutDate;

    private String enterprise;
    private String type;
    private List<AlbumDTO> albums;
}