package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    String artistID;
    String country;
    LocalDate debutDate;
    String enterprise;
    String type;

}
