package devgraft.dgcinema.domain.model

fun anTheater(): TheaterBuilder {
    return TheaterBuilder()
        .id(1L)
        .name("name")
}

class TheaterBuilder {
    private var id: Long = 0
    private lateinit var name: String
    fun id(id: Long) = apply { this.id = id }
    fun name(name: String) = apply { this.name = name }

    fun build(): Theater {
        return Theater(
            id = id,
            name = name
        )
    }
}
