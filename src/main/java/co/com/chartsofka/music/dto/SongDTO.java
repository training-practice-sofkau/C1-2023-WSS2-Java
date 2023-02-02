package co.com.chartsofka.music.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private String songID;
    private String name;
    private LocalTime duration;
    private Integer played;
    private AlbumDTO albumDTO;
}
