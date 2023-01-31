package co.com.chartsofka.music.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SongDTO {
    private String songId;
    private String name;
    private LocalDateTime duration;
    private String albumId;
    private Integer played;
}
