package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class SongDTO {
    String songID;
    String name;
    LocalTime duration;
    String albumID;
    Integer played;
}
