package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO {
    private String artistId;
    private String country;
    private LocalDateTime debutDate;
    private String enterprise;
    private String type;
}
