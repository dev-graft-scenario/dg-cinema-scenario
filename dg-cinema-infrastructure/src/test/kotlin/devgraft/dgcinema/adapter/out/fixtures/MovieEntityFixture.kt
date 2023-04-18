package devgraft.dgcinema.adapter.out.fixtures

import devgraft.dgcinema.adapter.out.MovieEntity
import devgraft.dgcinema.domain.model.Movie
import org.assertj.core.api.Assertions
import java.time.LocalDate


fun anMovieEntity() : MovieEntityBuilder {
    return MovieEntityBuilder()
        .id(1L)
        .title("title")
        .description("description")
        .bannerUrl("bannerUrl")
        .genre("genre")
        .releaseDate(LocalDate.now())
        .duration(100)
}

fun assertThatMovie(actual:Movie, expected: MovieEntity) {
    Assertions.assertThat(actual.id).isEqualTo(expected.id)
    Assertions.assertThat(actual.title).isEqualTo(expected.title)
    Assertions.assertThat(actual.description).isEqualTo(expected.description)
    Assertions.assertThat(actual.bannerUrl).isEqualTo(expected.bannerUrl)
    Assertions.assertThat(actual.genre).isEqualTo(expected.genre)
    Assertions.assertThat(actual.releaseDate).isEqualTo(expected.releaseDate)
}

class MovieEntityBuilder {
    private var id: Long = 0
    private lateinit var title: String
    private lateinit var description: String
    private lateinit var bannerUrl: String
    private lateinit var genre: String
    private lateinit var releaseDate: LocalDate
    private var duration: Int = 0

    fun id(id: Long) = apply { this.id = id }
    fun title(title: String) = apply { this.title = title }
    fun description(description: String) = apply { this.description = description }
    fun bannerUrl(bannerUrl: String) = apply { this.bannerUrl = bannerUrl }
    fun genre(genre: String) = apply { this.genre = genre }
    fun releaseDate(releaseDate: LocalDate) = apply { this.releaseDate = releaseDate }
    fun duration(duration: Int) = apply { this.duration = duration }
    fun build(): MovieEntity {
        return MovieEntity(
            id=id,
            title = title,
            description = description,
            bannerUrl = bannerUrl,
            genre = genre,
            releaseDate = releaseDate,
            duration = duration
        )
    }
}
