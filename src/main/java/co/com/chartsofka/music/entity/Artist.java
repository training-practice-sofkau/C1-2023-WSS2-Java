package co.com.chartsofka.music.entity;

import lombok.Data;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "co.com.chartsofka.music.utils.UUIDGeneratorTruncated")
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

    @JsonManagedReference
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, targetEntity = Album.class)
    private List<Album> albums = new ArrayList<>();
}