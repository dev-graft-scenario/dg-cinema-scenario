package devgraft.dgcinema.infrastructure.adapter.out;

import devgraft.dgcinema.domain.model.Movie;
import devgraft.dgcinema.infrastructure.adapter.MovieEntityFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MovieAdapterTest {
    @InjectMocks
    private MovieAdapter movieAdapter;
    @Mock
    private MovieRepository mockMovieRepository;
    @Captor
    private ArgumentCaptor<Long> movieIdCaptor;

    @Test
    void findById_return_value() {
        final MovieEntity givenMovieEntity = MovieEntityFixture.anMovieEntity().build();
        BDDMockito.given(mockMovieRepository.findById(anyLong())).willReturn(Optional.of(givenMovieEntity));

        Optional<Movie> resultOpt = movieAdapter.findById(1L);

        Assertions.assertThat(resultOpt).isNotEmpty();
        final Movie movie = resultOpt.get();
        Assertions.assertThat(movie.id()).isEqualTo(givenMovieEntity.getId());
        Assertions.assertThat(movie.title()).isEqualTo(givenMovieEntity.getTitle());
        Assertions.assertThat(movie.description()).isEqualTo(givenMovieEntity.getDescription());
        Assertions.assertThat(movie.bannerUrl()).isEqualTo(givenMovieEntity.getBannerUrl());
        Assertions.assertThat(movie.releaseDate()).isEqualTo(givenMovieEntity.getReleaseDate());
        Assertions.assertThat(movie.genre()).isEqualTo(givenMovieEntity.getGenre());
        Assertions.assertThat(movie.duration()).isEqualTo(givenMovieEntity.getDuration());
    }

    @Test
    void findById_passes_movieId_to_repository() {
        final long givenMovieId = 1L;

        movieAdapter.findById(givenMovieId);

        Mockito.verify(mockMovieRepository, Mockito.times(1)).findById(movieIdCaptor.capture());
        Assertions.assertThat(movieIdCaptor.getValue()).isNotNull();
        Assertions.assertThat(movieIdCaptor.getValue()).isEqualTo(givenMovieId);
    }

    @Test
    void findAll_return_value() {
        final List<MovieEntity> givenMovieEntityList = new ArrayList<>();
        givenMovieEntityList.add(MovieEntityFixture.anMovieEntity().build());
        givenMovieEntityList.add(MovieEntityFixture.anMovieEntity().id(2L).title("test2").duration(10).build());
        givenMovieEntityList.add(MovieEntityFixture.anMovieEntity().id(3L).title("test100").releaseDate(LocalDate.now()).build());
        BDDMockito.given(mockMovieRepository.findAll()).willReturn(givenMovieEntityList);

        List<Movie> result = movieAdapter.findAll();

        Assertions.assertThat(result).isNotEmpty();
        for (int i = 0; i < result.size(); i++) {
            final Movie movie = result.get(i);
            final MovieEntity givenMovieEntity = givenMovieEntityList.get(i);

            Assertions.assertThat(movie.id()).isEqualTo(givenMovieEntity.getId());
            Assertions.assertThat(movie.title()).isEqualTo(givenMovieEntity.getTitle());
            Assertions.assertThat(movie.description()).isEqualTo(givenMovieEntity.getDescription());
            Assertions.assertThat(movie.bannerUrl()).isEqualTo(givenMovieEntity.getBannerUrl());
            Assertions.assertThat(movie.releaseDate()).isEqualTo(givenMovieEntity.getReleaseDate());
            Assertions.assertThat(movie.genre()).isEqualTo(givenMovieEntity.getGenre());
            Assertions.assertThat(movie.duration()).isEqualTo(givenMovieEntity.getDuration());
        }
    }

    @Test
    void findAll_was_call_repository() {
        movieAdapter.findAll();

        Mockito.verify(mockMovieRepository, Mockito.times(1)).findAll();
    }
}