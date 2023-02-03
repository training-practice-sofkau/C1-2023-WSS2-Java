package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Song;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
}
