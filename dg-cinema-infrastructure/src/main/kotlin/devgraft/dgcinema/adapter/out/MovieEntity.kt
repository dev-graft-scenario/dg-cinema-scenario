package devgraft.dgcinema.adapter.out

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "movie")
@Entity
class MovieEntity(
    @Column(name = "title", nullable = false)
    val title: String,
    @Column(name = "description", nullable = false)
    val description: String,
    @Column(name = "bannerUrl", nullable = false)
    val bannerUrl: String,
    @Column(name = "genre", nullable = false)
    val genre: String,
    @Column(name = "duration", nullable = false)
    val duration: Int,
    @Column(name = "releaseDate", nullable = false)
    val releaseDate: LocalDate,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MovieEntity) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (bannerUrl != other.bannerUrl) return false
        if (genre != other.genre) return false
        if (releaseDate != other.releaseDate) return false
        return duration == other.duration
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + bannerUrl.hashCode()
        result = 31 * result + genre.hashCode()
        result = 31 * result + releaseDate.hashCode()
        result = 31 * result + duration
        return result
    }
}