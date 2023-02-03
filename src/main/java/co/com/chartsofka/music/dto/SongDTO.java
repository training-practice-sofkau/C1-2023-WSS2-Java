package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private String songID;
    private String name;
    private LocalDateTime duration;
    private Integer played;

    private  AlbumDTO albumDTO;
}
