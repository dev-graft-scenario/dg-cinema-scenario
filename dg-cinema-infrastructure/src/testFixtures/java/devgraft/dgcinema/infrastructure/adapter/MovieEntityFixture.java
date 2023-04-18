package devgraft.dgcinema.infrastructure.adapter;

import devgraft.dgcinema.infrastructure.adapter.out.MovieEntity;

import java.time.LocalDate;

public class MovieEntityFixture {
    public static MovieEntity.MovieEntityBuilder anMovieEntity() {
        return MovieEntity.builder()
                .id(1L)
                .title("스즈메의 문단속")
                .description("문단속의 필요성을 강조하는 영화")
                .bannerUrl("bannerUrl")
                .releaseDate(LocalDate.now())
                .genre("판타지")
                .duration(100)
                ;
    }
}
