package devgraft.dgcinema

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DGCinemaApplication
fun main(args: Array<String>) {
    runApplication<DGCinemaApplication>(*args)
}
