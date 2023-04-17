package devgraft.dgcinema.adapter.`in`.query

import devgraft.dgcinema.domain.model.Theater
import devgraft.dgcinema.domain.ports.`in`.query.TheaterSearchUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
class TheaterQueryApi(private val theaterSearchUseCase: TheaterSearchUseCase) {
    @GetMapping("theaters/{theaterId}")
    private fun searchTheater(@PathVariable(name = "theaterId") theaterId: Long): TheaterSearchResponse {
        return toResponse(theaterSearchUseCase.getTheater(theaterId))
    }

    @GetMapping("theaters")
    private fun searchTheaterList(): TheaterSearchListResponse {
        return toResponse(theaterSearchUseCase.getTheaterList())
    }
}

private fun toResponse(theater: Theater): TheaterSearchResponse {
    return TheaterSearchResponse(
        theaterId = theater.id,
        theaterName = theater.name
    )
}

private fun toResponse(theaters: List<Theater>): TheaterSearchListResponse {
    return TheaterSearchListResponse(
        theaters = theaters.stream().map(::toResponse).collect(Collectors.toUnmodifiableList())
    )
}

private data class TheaterSearchResponse(val theaterId: Long, val theaterName: String)
private data class TheaterSearchListResponse(val theaters: List<TheaterSearchResponse>)
