package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ArtistDTO {
    String artistID;
    String country;
    LocalDate debutDate;
    String enterprise;
    String type;
}
