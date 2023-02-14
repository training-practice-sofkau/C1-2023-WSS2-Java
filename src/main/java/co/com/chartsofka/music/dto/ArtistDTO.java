package co.com.chartsofka.music.dto;

import co.com.chartsofka.music.entity.Album;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
    private String artistID;
    private String name;
    private String country;
    private LocalDate debutDate;
    private String enterprise;
    private Integer age;
    private String type;
    private String pic_url;
    private List<Album> albums = new ArrayList<>();
}