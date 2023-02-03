package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private String songIDDTO;
    private String nameDTO;
    private LocalTime durationDTO;
    private Integer playedDTO;
    private AlbumDTO albumDTO;
}
