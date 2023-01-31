package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String albumID;
    private String title;
    private Integer totalSongs;
    private String yearRelease;
    private String genre;
    private String artistID;


}
