package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlbumDTO {
    private String albumID;
    private String title;
    private Integer totalSongs;
    private String yearRelease;
    private String genre;
    private String artistID;
}
