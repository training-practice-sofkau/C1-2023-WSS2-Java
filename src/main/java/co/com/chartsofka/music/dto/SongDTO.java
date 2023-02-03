package co.com.chartsofka.music.dto;

import lombok.Data;
import java.time.LocalTime;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import co.com.chartsofka.music.entity.Album;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
    private String songID;
    private String title;
    private LocalTime duration;
    private Integer played;
    private Album album;
}
