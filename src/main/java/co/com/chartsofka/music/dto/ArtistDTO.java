package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Album;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class ArtistDTO {
    private String artistID;
    private String name;
    private String country;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate debutDate;

    private String enterprise;
    private String type;

    private List<AlbumDTO> albumsDTO = new ArrayList<>();

}
