package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,String> {
    List<Song> findAllByAlbum_AlbumID(String albumID);
}
