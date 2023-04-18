package devgraft.dgcinema.infrastructure.service.query;

import devgraft.dgcinema.domain.model.Movie;
import devgraft.dgcinema.domain.model.MovieFixture;
import devgraft.dgcinema.domain.model.MovieNotFoundException;
import devgraft.dgcinema.domain.port.out.MoviePort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MovieSearchServiceTest {
    @InjectMocks
    private MovieSearchService movieSearchService;
    @Mock
    private MoviePort mockMoviePort;

    @Test
    void getMovie_return_value() {
        final Movie givenMovie = MovieFixture.anMovie().build();
        BDDMockito.given(mockMoviePort.findById(anyLong())).willReturn(Optional.of(givenMovie));

        final Movie result = movieSearchService.getMovie(givenMovie.id());

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.id()).isEqualTo(givenMovie.id());
        Assertions.assertThat(result.title()).isEqualTo(givenMovie.title());
        Assertions.assertThat(result.description()).isEqualTo(givenMovie.description());
        Assertions.assertThat(result.bannerUrl()).isEqualTo(givenMovie.bannerUrl());
        Assertions.assertThat(result.releaseDate()).isEqualTo(givenMovie.releaseDate());
        Assertions.assertThat(result.genre()).isEqualTo(givenMovie.genre());
        Assertions.assertThat(result.duration()).isEqualTo(givenMovie.duration());
    }

    @Test
    void getMovie_passes_movieId_to_port() {
        final Long givenMovieId = 100L;
        final Movie givenMovie = MovieFixture.anMovie().id(givenMovieId).build();
        BDDMockito.given(mockMoviePort.findById(anyLong())).willReturn(Optional.of(givenMovie));

        movieSearchService.getMovie(givenMovieId);

        Mockito.verify(mockMoviePort, Mockito.times(1)).findById(givenMovieId);
    }

    @Test
    void getMovie_throw_movie_not_found_exception() {
        BDDMockito.given(mockMoviePort.findById(anyLong())).willReturn(Optional.empty());

        final MovieNotFoundException exception = Assertions.catchThrowableOfType(
                () -> movieSearchService.getMovie(1L),
                MovieNotFoundException.class);

        Assertions.assertThat(exception).isNotNull();
    }

    @Test
    void getMovieList_return_value() {
        final List<Movie> givenMovieList = new ArrayList<>();
        givenMovieList.add(MovieFixture.anMovie().build());
        givenMovieList.add(MovieFixture.anMovie().id(2L).title("test2").duration(10).build());
        givenMovieList.add(MovieFixture.anMovie().id(3L).title("test100").releaseDate(LocalDate.now()).build());
        BDDMockito.given(mockMoviePort.findAll()).willReturn(givenMovieList);

        List<Movie> result = movieSearchService.getMovieList();

        Assertions.assertThat(result).isNotEmpty();
        for (int i = 0; i < result.size(); i++) {
            final Movie movie = result.get(i);
            final Movie givenMovie = givenMovieList.get(i);

            Assertions.assertThat(movie.id()).isEqualTo(givenMovie.id());
            Assertions.assertThat(movie.title()).isEqualTo(givenMovie.title());
            Assertions.assertThat(movie.description()).isEqualTo(givenMovie.description());
            Assertions.assertThat(movie.bannerUrl()).isEqualTo(givenMovie.bannerUrl());
            Assertions.assertThat(movie.releaseDate()).isEqualTo(givenMovie.releaseDate());
            Assertions.assertThat(movie.genre()).isEqualTo(givenMovie.genre());
            Assertions.assertThat(movie.duration()).isEqualTo(givenMovie.duration());
        }
    }

    @Test
    void getMovieList_was_call_port() {

        movieSearchService.getMovieList();

        Mockito.verify(mockMoviePort, Mockito.times(1)).findAll();
    }
}