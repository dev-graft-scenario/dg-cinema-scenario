package devgraft.dgcinema.domain.model

import java.time.LocalDate

data class Movie(
    val id: Long,
    val title: String,
    val description: String,
    val bannerUrl: String,
    val genre: String,
    val releaseDate: LocalDate,
    val duration: Int
)
