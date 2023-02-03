package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    Optional<Album> findByTitle(String title);
}
