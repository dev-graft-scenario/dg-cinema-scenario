CREATE TABLE IF NOT EXISTS member
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone    VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE INDEX idx_member_email ON member (email);
CREATE INDEX idx_member_phone ON member (phone);

CREATE TABLE IF NOT EXISTS movie
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    bannerUrl   VARCHAR(255) NOT NULL,
    genre       VARCHAR(255) NOT NULL,
    releaseDate date         NOT NULL,
    duration    INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS theater
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS auditorium
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    theaterId BIGINT       NOT NULL,
    name      VARCHAR(255) NOT NULL
);

CREATE INDEX idx_auditorium_theater ON auditorium (theaterId);

CREATE TABLE IF NOT EXISTS seat
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    auditoriumId BIGINT       NOT NULL,
    seatRow      VARCHAR(255) NOT NULL,
    seatColumn   INT          NOT NULL
);

CREATE INDEX idx_seat_auditorium ON seat (auditoriumId);
CREATE INDEX idx_seat_row_column ON seat (seatRow, seatColumn);

CREATE TABLE IF NOT EXISTS showing
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    movieId      BIGINT         NOT NULL,
    auditoriumId BIGINT         NOT NULL,
    showDate     date           NOT NULL,
    startTime    time           NOT NULL,
    endTime      time           NOT NULL,
    price        decimal(10, 2) NOT NULL
);

CREATE INDEX idx_showing_movie ON showing (movieId);
CREATE INDEX idx_showing_auditorium ON showing (auditoriumId);
CREATE INDEX idx_showing_date ON showing (showDate);

CREATE TABLE IF NOT EXISTS reservation
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    memberId  BIGINT    NOT NULL,
    showingId BIGINT    NOT NULL,
    seatId    BIGINT    NOT NULL,
    createdAt timestamp NOT NULL
);

CREATE INDEX idx_reservation_member ON reservation (memberId);
CREATE INDEX idx_reservation_showing ON reservation (showingId);
CREATE INDEX idx_reservation_seat ON reservation (seatId);

CREATE TABLE IF NOT EXISTS payment
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    reservationId   BIGINT         NOT NULL,
    status          VARCHAR(255)   NOT NULL,
    amount          decimal(10, 2) NOT NULL,
    paymentMethod   VARCHAR(255)   NOT NULL,
    createAt        timestamp      NOT NULL,
    paymentExpireAt timestamp      NOT NULL,
    completedAt     timestamp
);

CREATE INDEX idx_payment_reservation ON payment (reservationId);
