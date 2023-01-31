package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String albumID;
    private String name;
    private Integer totalSongs;
    private String yearRelease;
    private String artistID;
    private String genre;
}
