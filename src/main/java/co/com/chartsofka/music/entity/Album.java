package co.com.chartsofka.music.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "albums")
public class Album {
    @GenericGenerator(name="UUID",
            strategy = "co.com.chartsofka.music.utils.UUIDGeneratorTruncated")
    @GeneratedValue(generator = "UUID")
    @Id
    private String albumID;

    @Column
    private String title;

    @Column
    private Integer totalSongs;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearRelease;

    @Column
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Artist.class)
    @JoinColumn(name="artist_id", foreignKey = @ForeignKey(name = "FK_artist_id"))
    @JsonIgnoreProperties("albums")
    private Artist artist;

    @OneToMany(mappedBy = "album",
            targetEntity = Song.class)
    @JsonIgnoreProperties("album")
    private List<Song> song = new ArrayList<>();

}
