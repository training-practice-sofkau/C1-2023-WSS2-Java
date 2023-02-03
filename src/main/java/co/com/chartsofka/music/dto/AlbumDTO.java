package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Artist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link co.com.chartsofka.music.entity.Album} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO implements Serializable {
    private  String albumID;
    private  String title;
    private  Integer totalSongs;
    private  String yearRelease;
    private  String genre;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Artist artist;

    private  List<SongDTO> songs;
}