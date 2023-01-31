package co.com.chartsofka.music.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Song {
    private String songId;
    private String name;
    private LocalDateTime duration;
    private String albumId;
    private Integer played;
}
