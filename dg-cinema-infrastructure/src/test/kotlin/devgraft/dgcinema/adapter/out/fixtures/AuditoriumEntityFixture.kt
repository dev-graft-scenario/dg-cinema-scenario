package devgraft.dgcinema.adapter.out.fixtures

import devgraft.dgcinema.adapter.out.AuditoriumEntity

fun anAuditoriumEntity(): AuditoriumEntityBuilder {
    return AuditoriumEntityBuilder()
            .id(1L)
            .theaterId(1L)
            .name("1관-1층")
}

class AuditoriumEntityBuilder {
    private var id: Long = 0
    private var theaterId: Long = 0
    private lateinit var name: String
    fun id(id: Long) = apply { this.id = id }
    fun theaterId(theaterId: Long) = apply { this.theaterId = theaterId }
    fun name(name: String) = apply { this.name = name }

    fun build(): AuditoriumEntity {
        return AuditoriumEntity(
                id = id,
                theaterId = theaterId,
                name = name
        )
    }
}
