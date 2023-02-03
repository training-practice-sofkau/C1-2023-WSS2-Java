package co.com.chartsofka.music.dto;

import lombok.Data;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import co.com.chartsofka.music.entity.Album;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
    private String artistID;
    private String name;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate debutDate;
    private String enterprise;
    private String type;
    private List<Album> albums = new ArrayList<>();
}
