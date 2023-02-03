package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,String> {
}
