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
    private String albumIDDTO;
    private String titleDTO;
    private Integer totalSongsDTO;
    private String yearReleaseDTO;
    private String genreDTO;
    private ArtistDTO artistDTO;
    private List<SongDTO> songsDTO = new ArrayList<>();
}
