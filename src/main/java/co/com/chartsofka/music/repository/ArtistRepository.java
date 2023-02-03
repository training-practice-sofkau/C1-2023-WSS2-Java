package co.com.chartsofka.music.repository;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArtistRepository extends JpaRepository<Artist,String> {
    /*@Query(value = "SELECT * FROM artists u WHERE u.name = ?1", nativeQuery = true)
    List<ArtistDTO> findByName(String artistName);*/
}
