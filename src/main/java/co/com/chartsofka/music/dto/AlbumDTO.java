package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link co.com.chartsofka.music.entity.Album} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO implements Serializable {
    private String albumID;
    private String title;
    private Integer totalSongs;
    private String yearRelease;
    private String genre;
    private ArtistDTO artist;
    private List<SongDTO> songs;
}