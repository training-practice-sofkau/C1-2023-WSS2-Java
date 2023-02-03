package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,String> {

    List<Artist> findAllByType(String type);
}
