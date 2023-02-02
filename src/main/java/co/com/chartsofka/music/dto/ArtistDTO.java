package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO {
    private String artistIDDTO;
    private String nameDTO;
    private String countryDTO;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate debutDateDTO;

    private String enterpriseDTO;
    private String typeDTO;

    private List<AlbumDTO> albumsDTO = new ArrayList<>();

}
