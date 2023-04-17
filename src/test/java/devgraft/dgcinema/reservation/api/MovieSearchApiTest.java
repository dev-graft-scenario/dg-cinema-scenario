package devgraft.dgcinema.reservation.api;

import devgraft.dgcinema.reservation.app.MovieSearchResponse;
import devgraft.dgcinema.reservation.app.MovieSearchService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class MovieSearchApiTest {
    private MockMvc mockMvc;
    @InjectMocks
    private MovieSearchApi movieSearchApi;
    @Mock
    private MovieSearchService mockMovieSearchService;
    @Captor
    private ArgumentCaptor<Long> movieIdCaptor;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(movieSearchApi).build();
    }

    @Test
    void searchMovie_status_is_ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{movieId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }

    @Test
    void searchMovie_return_value() throws Exception {
        final MovieSearchResponse givenResponse = MovieSearchResponse.builder()
                .movieId(1L)
                .title("title2")
                .description("description2")
                .bannerUrl("bannerUrl2")
                .genre("genre2")
                .duration(150)
                .build();

        BDDMockito.given(mockMovieSearchService.searchMovie(anyLong())).willReturn(givenResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{movieId}", 1))
                .andExpect(jsonPath("$.movieId").value(givenResponse.getMovieId()))
                .andExpect(jsonPath("$.title").value(givenResponse.getTitle()))
                .andExpect(jsonPath("$.description").value(givenResponse.getDescription()))
                .andExpect(jsonPath("$.bannerUrl").value(givenResponse.getBannerUrl()))
                .andExpect(jsonPath("$.genre").value(givenResponse.getGenre()))
                .andExpect(jsonPath("$.duration").value(givenResponse.getDuration()))
        ;
    }

    @Test
    void searchMovie_passes_movieId_to_service() throws Exception {
        final Long givenMovieId = 100L;

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{movieId}", givenMovieId));

        Mockito.verify(mockMovieSearchService, Mockito.times(1)).searchMovie(movieIdCaptor.capture());
        Assertions.assertThat(movieIdCaptor.getValue()).isNotNull();
        Assertions.assertThat(movieIdCaptor.getValue()).isEqualTo(givenMovieId);
    }
}