package devgraft.dgcinema.domain.model

import java.time.LocalDate

fun anMovie(): MovieBuilder {
    return MovieBuilder()
        .id(1)
        .title("스즈메의 문단속")
        .description("문단속의 필요성을 강조하는 영화")
        .bannerUrl("bannerUrl")
        .releaseDate(LocalDate.now())
        .genre("판타지")
        .duration(100)
}

class MovieBuilder {
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
    fun build(): Movie {
        return Movie(
            id = id,
            title = title,
            description = description,
            bannerUrl = bannerUrl,
            genre = genre,
            releaseDate = releaseDate,
            duration = duration
        )
    }
}
