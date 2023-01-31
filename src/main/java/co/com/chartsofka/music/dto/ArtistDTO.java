package co.com.chartsofka.music.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ArtistDTO {
    private String artistID;
    private String country;
    private LocalDate debutDate;
    private String enterprise;
    private String type;

}
