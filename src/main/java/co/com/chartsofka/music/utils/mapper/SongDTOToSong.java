package co.com.chartsofka.music.utils.mapper;

import co.com.chartsofka.music.dto.SongDTO;
import co.com.chartsofka.music.entity.Song;
import org.springframework.stereotype.Component;

@Component
public class SongDTOToSong implements IMapper<SongDTO, Song>{
    @Override
    public Song map(SongDTO in) {
        Song s = new Song();
        s.setName(in.getName());
        s.setDuration(in.getDuration());
//        s.setAlbum(in.getAlbum());
        s.setPlayed(in.getPlayed());

        return s;
    }
}
