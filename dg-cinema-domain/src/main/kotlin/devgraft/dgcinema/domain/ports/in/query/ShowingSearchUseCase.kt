package devgraft.dgcinema.domain.ports.`in`.query

import devgraft.dgcinema.domain.model.Showing

interface ShowingSearchUseCase {
    fun getShowing(showingId: Long): Showing
}
