package co.com.chartsofka.music.dto;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import co.com.chartsofka.music.entity.Song;
import co.com.chartsofka.music.entity.Artist;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private String albumID;
    private String name;
    private Integer totalSongs;
    private String yearRelease;
    private String genre;
    private Artist artist;
    private List<Song> songs = new ArrayList<>();
}
