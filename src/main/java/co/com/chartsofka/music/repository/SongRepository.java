package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, String> {
}
