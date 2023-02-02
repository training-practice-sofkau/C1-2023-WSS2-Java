package co.com.chartsofka.music.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "co.com.chartsofka.music.utils.UUIDGeneratorTruncated")
    private String albumID;
    @Column
    private String name;
    @Column
    private Integer totalSongs;
    @Column
    private String yearRelease;
    @Column
    private String genre;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Artist.class)
    @JoinColumn(name="artist_id", foreignKey = @ForeignKey(name = "FK_artist_id"))
    private Artist artist;

    @JsonBackReference
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, targetEntity = Song.class)
    private List<Song> songs = new ArrayList<>();
}