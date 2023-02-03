package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    private String songID;
    private String title;
    private LocalTime duration;
    private Integer played;
    private AlbumDTO album;
}
