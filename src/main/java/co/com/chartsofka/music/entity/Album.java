package co.com.chartsofka.music.entity;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Artist.class)
    @JoinColumn(name="artist_id", foreignKey = @ForeignKey(name = "FK_artist_id"))
    private Artist artist;

    @JsonManagedReference
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, targetEntity = Song.class)
    private List<Song> songs = new ArrayList<>();
}