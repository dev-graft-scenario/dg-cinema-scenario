package devgraft.dgcinema.domain.model

fun anMovie(): MovieBuilder {
    return MovieBuilder()
            .id(1)
            .title("title")
            .description("description")
            .bannerUrl("bannerUrl")
            .genre("genre")
            .duration(100)
}

open class MovieBuilder {
    private var id: Long = 0
    private lateinit var title: String
    private lateinit var description: String
    private lateinit var bannerUrl: String
    private lateinit var genre: String
    private var duration: Int = 0

    fun id(id: Long) = apply { this.id = id }
    fun title(title: String) = apply { this.title = title }
    fun description(description: String) = apply { this.description = description }
    fun bannerUrl(bannerUrl: String) = apply { this.bannerUrl = bannerUrl }
    fun genre(genre: String) = apply { this.genre = genre }
    fun duration(duration: Int) = apply { this.duration = duration }
    fun build(): Movie {
        return Movie(id, title, description, bannerUrl, genre, duration)
    }
}
