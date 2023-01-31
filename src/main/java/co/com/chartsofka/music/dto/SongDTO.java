package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private String songId;
    private String name;
    private LocalDate duration;
    private String albumID;
    private Integer played;
}
