package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Album;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SongDTO {
    private String songID;
    private String name;
    private LocalDateTime duration;
    //    @Column
//    private Album album;
    private Integer played;
}
