package co.com.chartsofka.music.entity;

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
@Table(name = "artists")
public class Artist {
    @GenericGenerator(name="UUID",
            strategy = "co.com.chartsofka.music.utils.UUIDGeneratorTruncated")
    @GeneratedValue(generator = "UUID")
    @Id
    private String artistID;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate debutDate;

    @Column
    private String enterprise;

    @Column
    private String type;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL,
            targetEntity = Album.class)
    @JsonManagedReference
    private List<Album> albums = new ArrayList<>();
}
