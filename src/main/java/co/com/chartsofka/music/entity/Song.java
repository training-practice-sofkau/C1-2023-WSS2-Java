package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private String songId;
    private String name;
    private LocalTime duration;
    private String albumId;
    private Integer played;
}
