package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, String> {
}
