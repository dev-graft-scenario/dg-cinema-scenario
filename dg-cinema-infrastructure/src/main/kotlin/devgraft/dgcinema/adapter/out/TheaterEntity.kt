package devgraft.dgcinema.adapter.out

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "theater")
@Entity
class TheaterEntity(
    @Column(name = "name", nullable = false)
    val name: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
)
