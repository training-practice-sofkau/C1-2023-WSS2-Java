package java.co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "currentplayers")
public class Album /*implements Serializable*/ {
    //private static final long serialVersionUID = 1L;
    //@Id
    //@Column("albumID")
    private String albumID;
    //@Column("title")
    private String title;
    //@Column("totalSongs")
    private Integer totalSongs;
    //@Column("yearRelease")
    private String yearRelease;
    //@Column("genre")
    private String genre;
    //@Column("artistID")
    private String artistID;


}
