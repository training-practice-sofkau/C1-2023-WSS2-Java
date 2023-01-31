package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Artist {
    private String artistID;
    private String country;
    private LocalDate debutDate;
    private String enterprise;
    private String type;
}
