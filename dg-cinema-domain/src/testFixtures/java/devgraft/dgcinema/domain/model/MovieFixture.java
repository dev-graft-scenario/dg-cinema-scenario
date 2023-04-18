package devgraft.dgcinema.domain.model;

import java.time.LocalDate;

public class MovieFixture {
    public static MovieBuilder anMovie() {
        return new MovieBuilder()
                .id(1L)
                .title("스즈메의 문단속")
                .description("문단속의 필요성을 강조하는 영화")
                .bannerUrl("bannerUrl")
                .releaseDate(LocalDate.now())
                .genre("판타지")
                .duration(100)
                ;
    }

    public static class MovieBuilder {
        private Long id;
        private String title;
        private String description;
        private String bannerUrl;
        private String genre;
        private LocalDate releaseDate;
        private Integer duration;

        public MovieBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MovieBuilder title(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder description(String description) {
            this.description = description;
            return this;
        }

        public MovieBuilder bannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
            return this;
        }

        public MovieBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieBuilder duration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Movie build() {
            return new Movie(id, title, description, bannerUrl, genre, releaseDate, duration);
        }
    }
}
