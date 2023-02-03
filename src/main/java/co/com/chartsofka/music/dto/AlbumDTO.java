package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    private ArtistDTO artistDTO;
    private List<SongDTO> songsDTO = new ArrayList<>();
}
