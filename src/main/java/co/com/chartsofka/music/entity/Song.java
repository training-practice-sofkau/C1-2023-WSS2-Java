package java.co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    String songID;
    String name;
    LocalTime duration;
    String albumID;
    Integer played;

}
