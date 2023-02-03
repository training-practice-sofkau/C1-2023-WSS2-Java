package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO implements Serializable {
    private String songID;
    private String title;
    private LocalTime duration;
    private Integer played;
    private Album album;
}