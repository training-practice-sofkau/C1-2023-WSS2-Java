package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    private String artistId;
    private String country;
    private LocalDate debutDate;
    private String enterprise;
    private String type;
}
