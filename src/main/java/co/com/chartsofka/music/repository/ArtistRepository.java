package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,String> {

    List<Artist> findByType(String type);
}
