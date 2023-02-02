package java.co.com.chartsofka.music.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "currentplayers")
public class Artist /*implements Serializable*/ {
    //private static final long serialVersionUID = 1L;
    //@Id
    // @Column ("artistID")
    private String artistID;
    // @Column ("country")
    private String country;
    // @Column ("debutDate")
    private LocalDate debutDate;
    // @Column ("enterprise")
    private String enterprise;
    // @Column ("type")
    private String type;
}
