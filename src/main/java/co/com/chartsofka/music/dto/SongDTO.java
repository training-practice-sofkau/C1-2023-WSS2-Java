package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.dto.AlbumDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * A DTO for the {@link co.com.chartsofka.music.entity.Song} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO implements Serializable {
    private String songID;
    private String name;
    private LocalTime duration;
    private AlbumDTO album;
    private Integer played;
}