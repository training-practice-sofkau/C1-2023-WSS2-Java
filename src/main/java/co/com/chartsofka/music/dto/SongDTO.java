package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Album;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * A DTO for the {@link co.com.chartsofka.music.entity.Song} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO implements Serializable {
    private String songID;
    private String name;
    private LocalTime duration;
    private Integer played;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Album album;
}