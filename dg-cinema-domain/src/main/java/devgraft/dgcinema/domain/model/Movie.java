package devgraft.dgcinema.domain.model;

import java.time.LocalDate;

public record Movie(
        Long id,
        String title,
        String description,
        String bannerUrl,
        String genre,
        LocalDate releaseDate,
        Integer duration
) {
}
