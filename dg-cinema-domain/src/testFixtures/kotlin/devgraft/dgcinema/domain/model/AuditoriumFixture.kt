package devgraft.dgcinema.domain.model

fun anAuditorium(): AuditoriumBuilder {
    return AuditoriumBuilder()
        .id(1L)
        .theaterId(1L)
        .name("1관-1층")
}

class AuditoriumBuilder {
    private var id: Long = 0
    private var theaterId: Long = 0
    private lateinit var name: String

    fun id(id: Long) = apply { this.id = id }
    fun theaterId(theaterId: Long) = apply { this.theaterId = theaterId }
    fun name(name: String) = apply { this.name = name }

    fun build(): Auditorium {
        return Auditorium(
            id = id,
            theaterId = theaterId,
            name = name
        )
    }
}
