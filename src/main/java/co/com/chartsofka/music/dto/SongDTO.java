package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private String songId;
    private String name;
    private LocalTime duration;
    private String albumId;
    private Integer played;
}