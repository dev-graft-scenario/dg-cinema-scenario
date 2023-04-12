package devgraft.dgcinema.adapter.out

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "movie")
@Entity
internal class MovieEntity(
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)