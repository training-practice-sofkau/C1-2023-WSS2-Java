package co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    private String artistId;
    private String country;
    private LocalDateTime debutDate;
    private String enterprise;
    private String type;
}
