package co.com.chartsofka.music.entity;

import lombok.Data;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "co.com.chartsofka.music.utils.UUIDGeneratorTruncated")
    private String songID;
    private String title;
    private LocalTime duration;
    private Integer played;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Album.class)
    @JoinColumn(name="album_id", foreignKey = @ForeignKey(name = "FK_album_id"))
    private Album album;
}
