package devgraft.dgcinema.presentation.adapter.in.query;

import devgraft.dgcinema.domain.model.Movie;
import devgraft.dgcinema.domain.model.MovieFixture;
import devgraft.dgcinema.domain.port.in.MovieSearchUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.format.DateTimeFormatter;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MovieQueryApiTest {
    private MockMvc mockMvc;
    @InjectMocks
    private MovieQueryApi movieQueryApi;
    @Mock
    private MovieSearchUseCase mockMovieSearchUseCase;
    @Captor
    private ArgumentCaptor<Long> movieIdCaptor;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(movieQueryApi).build();
    }

    @Test
    void searchMovie_status_is_ok() throws Exception {
        BDDMockito.given(mockMovieSearchUseCase.getMovie(anyLong())).willReturn(MovieFixture.anMovie().build());

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{movieId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void searchMovie_return_value() throws Exception {
        final Movie givenMovie = MovieFixture.anMovie().build();
        BDDMockito.given(mockMovieSearchUseCase.getMovie(anyLong())).willReturn(givenMovie);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{movieId}", 1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movieId").value(givenMovie.id()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(givenMovie.title()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(givenMovie.description()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bannerUrl").value(givenMovie.bannerUrl()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value(givenMovie.genre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate").value(givenMovie.releaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.duration").value(givenMovie.duration()))
        ;
    }

    @Test
    void searchMovie_passes_movieId_to_useCase() throws Exception {
        final Long givenMovieId = 1L;
        BDDMockito.given(mockMovieSearchUseCase.getMovie(anyLong())).willReturn(MovieFixture.anMovie().build());

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{movieId}", givenMovieId));

        Mockito.verify(mockMovieSearchUseCase, Mockito.times(1)).getMovie(movieIdCaptor.capture());
        Assertions.assertThat(movieIdCaptor.getValue()).isNotNull();
        Assertions.assertThat(movieIdCaptor.getValue()).isEqualTo(givenMovieId);

    }

    @Test
    void searchMovies_status_is_ok() throws Exception {
        BDDMockito.given(mockMovieSearchUseCase.getMovieList()).willReturn(List.of(MovieFixture.anMovie().build()));

        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void searchMovies_return_value() throws Exception {
        final Movie givenMovie = MovieFixture.anMovie().build();
        BDDMockito.given(mockMovieSearchUseCase.getMovieList()).willReturn(List.of(givenMovie));

        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].movieId").value(givenMovie.id()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].title").value(givenMovie.title()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].description").value(givenMovie.description()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].bannerUrl").value(givenMovie.bannerUrl()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].genre").value(givenMovie.genre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].releaseDate").value(givenMovie.releaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.movies[0].duration").value(givenMovie.duration()))
        ;
    }

    @Test
    void searchMovie_was_call_useCase() throws Exception {
        BDDMockito.given(mockMovieSearchUseCase.getMovieList()).willReturn(List.of(MovieFixture.anMovie().build()));

        mockMvc.perform(MockMvcRequestBuilders.get("/movies"));

        Mockito.verify(mockMovieSearchUseCase, Mockito.times(1)).getMovieList();
    }
}