package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArtistDTO {
    private String artistID;
    private String country;
    private LocalDate debutDate;
    private String enterprise;
    private String type;
}
