CREATE TABLE IF NOT EXISTS "user"
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE INDEX idx_user_email ON "user" (email);

CREATE TABLE IF NOT EXISTS "movie"
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    bannerUrl   VARCHAR(255) NOT NULL,
    genre       VARCHAR(255) NOT NULL,
    duration    INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS "theater"
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS "seat"
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    theaterId INT          NOT NULL,
    seatRow       VARCHAR(255) NOT NULL,
    seatColumn    INT          NOT NULL
);

CREATE INDEX idx_seat_theater ON "seat" (theaterId);
CREATE INDEX idx_seat_row_column ON "seat" (seatRow, seatColumn);

CREATE TABLE IF NOT EXISTS "showing"
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    movieId   INT            NOT NULL,
    theaterId INT            NOT NULL,
    showDate  date           NOT NULL,
    startTime time           NOT NULL,
    endTime   time           NOT NULL,
    price     decimal(10, 2) NOT NULL
);

CREATE INDEX idx_showing_movie ON "showing" (movieId);
CREATE INDEX idx_showing_theater ON "showing" (theaterId);
CREATE INDEX idx_showing_date ON "showing" (showDate);

CREATE TABLE IF NOT EXISTS "reservation"
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    userId    INT       NOT NULL,
    showingId INT       NOT NULL,
    seatId    INT       NOT NULL,
    createAt  timestamp NOT NULL
);

CREATE INDEX idx_reservation_user ON "reservation" (userId);
CREATE INDEX idx_reservation_showing ON "reservation" (showingId);
CREATE INDEX idx_reservation_seat ON "reservation" (seatId);

CREATE TABLE IF NOT EXISTS "payment"
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    reservationId   INT            NOT NULL,
    status          VARCHAR(255)   NOT NULL,
    amount          decimal(10, 2) NOT NULL,
    paymentMethod   VARCHAR(255)   NOT NULL,
    createAt        timestamp      NOT NULL,
    paymentExpireAt timestamp      NOT NULL,
    completedAt     timestamp
);

CREATE INDEX idx_payment_reservation ON "payment" (reservationId);
