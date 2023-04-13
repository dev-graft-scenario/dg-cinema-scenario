package devgraft.dgcinema.domain.model

class Movie(
    val id: Long,
    val title: String,
    val description: String,
    val bannerUrl: String,
    val genre: String,
    val duration: Int
)
