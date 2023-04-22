package devgraft.dgcinema.adapter.out.fixtures

import devgraft.dgcinema.adapter.out.TheaterEntity


fun anTheaterEntity(): TheaterEntityBuilder {
    return TheaterEntityBuilder()
        .id(1L)
        .name("name")
}

class TheaterEntityBuilder {
    private var id: Long = 0
    private lateinit var name: String
    fun id(id: Long) = apply { this.id = id }
    fun name(name: String) = apply { this.name = name }

    fun build(): TheaterEntity {
        return TheaterEntity(
            id = id,
            name = name
        )
    }
}
