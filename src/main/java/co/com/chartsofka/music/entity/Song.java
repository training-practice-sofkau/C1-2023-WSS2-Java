package java.co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "currentplayers")
public class Song /*implements Serializable*/ {
    //private static final long serialVersionUID = 1L;
    //@Id
    //Column("songID")
    private String songID;
    //Column("name")
    private String name;
    //Column("duration")
    private LocalTime duration;
    //Column("albumID")
    private String albumID;
    //Column("played")
    private Integer played;

}
