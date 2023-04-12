package devgraft.dgcinema.adapter.output

import javax.persistence.*


@Table(name = "movie")
@Entity
internal class MovieEntity(
    @Column(name = "title")
    val title: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "bannerUrl")
    val bannerUrl: String,
    @Column(name = "genre")
    val genre: String,
    @Column(name = "duration")
    val duration: Int,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)