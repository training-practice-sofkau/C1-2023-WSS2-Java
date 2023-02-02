package co.com.chartsofka.music.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalTime;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Album.class)
    @JoinColumn(name="album_id", foreignKey = @ForeignKey(name = "FK_album_id"))
    private Album album;
}