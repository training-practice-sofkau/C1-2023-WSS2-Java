package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Artist;
import co.com.chartsofka.music.entity.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
    private String albumID;
    private String title;
    private Integer totalSongs;
    private String yearRelease;
    private String genre;
    private Artist artist;
    private List<Song> songs;
}
