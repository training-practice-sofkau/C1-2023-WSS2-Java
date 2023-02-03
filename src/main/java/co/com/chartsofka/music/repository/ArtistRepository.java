package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Artist;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
}
