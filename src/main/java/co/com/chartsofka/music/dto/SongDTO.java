package java.co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class SongDTO {
    private String songID;
    private String name;
    private LocalTime duration;
    private String albumID;
    private Integer played;

}
