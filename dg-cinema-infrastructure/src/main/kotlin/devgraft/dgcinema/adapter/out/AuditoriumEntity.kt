package devgraft.dgcinema.adapter.out

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "auditorium")
@Entity
class AuditoriumEntity(
    @Column(name = "theaterId", nullable = false)
    val theaterId : Long,
    @Column(name = "name", nullable = false)
    val name : String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AuditoriumEntity

        if (theaterId != other.theaterId) return false
        if (name != other.name) return false
        return id == other.id
    }

    override fun hashCode(): Int {
        var result = theaterId.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }
}
