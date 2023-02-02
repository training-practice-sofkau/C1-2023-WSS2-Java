package co.com.chartsofka.music.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song {
    @GenericGenerator(name="UUID",
            strategy = "co.com.chartsofka.music.utils.UUIDGeneratorTruncated")
    @GeneratedValue(generator = "UUID")
    @Id
    private String songID;
    private String name;
    private LocalTime duration;
    private Integer played;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Album.class)
    @JoinColumn(name="album_id", foreignKey = @ForeignKey(name = "FK_album_id"))
    @JsonBackReference
    private Album album;
}
