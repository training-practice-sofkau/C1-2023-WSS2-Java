package co.com.chartsofka.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {
    private String albumID;
    private String title;
    private Integer totalSongs;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearRelease;
    private String genre;
    private ArtistDTO artistDTO;
    private List<SongDTO> songsDTO = new ArrayList<>();

    public void addSongDTO(SongDTO songDTO) {
        songsDTO.add(songDTO);
    }
}
