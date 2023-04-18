package devgraft.dgcinema.domain.model;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException() {
        super("요청한 영화가 존재하지 않습니다.");
    }
}
