package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private String songID;
    private String title;
    private Duration duration;
    private Integer played;
    private AlbumDTO albumDTO;
}
