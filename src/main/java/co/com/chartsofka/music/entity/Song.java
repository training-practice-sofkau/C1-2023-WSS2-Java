package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private String songId;
    private String name;
    private LocalDate duration;
    private String albumID;
    private Integer played;
}
