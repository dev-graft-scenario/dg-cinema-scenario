INSERT INTO movie(title, description, genre, releaseDate, duration, bannerUrl)
VALUES ('존 윅4', '또와따 존-윅', '액션', DATEADD('DAY', 0, CURRENT_DATE), 120, 'https://user-images.githubusercontent.com/22608825/231777537-3bfd4cae-7741-45bd-9cff-1b410680947a.png'),
       ('더 퍼스트 슬램덩크', '열정감동', '스포츠', DATEADD('DAY', 0, CURRENT_DATE), 180, 'https://user-images.githubusercontent.com/22608825/231777934-03193701-3de6-4460-a3fd-be9073cd8fcb.png'),
       ('스즈메의 문단속', '부탁드리옵니다!', '애니메이션', DATEADD('DAY', 1, CURRENT_DATE), 140, 'https://user-images.githubusercontent.com/22608825/231778099-38b06b77-9c4f-4904-a6f5-7471b099f17e.png'),
       ('옥수역귀신', '여름마다 찾아오는 그것', '공포', DATEADD('DAY', 8, CURRENT_DATE), 150, 'https://user-images.githubusercontent.com/22608825/231778441-9831c841-2713-4109-91cd-e35d56177a69.png'),
       ('킬링 로맨스', '쓱-싹', '액션,로맨스', DATEADD('DAY', 9, CURRENT_DATE), 120, 'https://user-images.githubusercontent.com/22608825/231778527-d301c96a-7960-4144-8231-eaabdb677548.png')
;

INSERT INTO theater(name)
VALUES ('성수 DG시네마'),
       ('홍대 DG시네마'),
       ('양재 DG시네마')
;

INSERT INTO auditorium(theaterId, name)
VALUES (1, '1관-1층'),(1, '2관-1층'),(1, '3관-1층'),
       (2, '1관-5층'),(2, '2관-6층'),(2, '3관-7층'),
       (3, '1관-8층'),(3, '2관-8층')
;

INSERT INTO seat(auditoriumId, seatRow, seatColumn)
--     성수 1관
VALUES (1, 'A', 1),(1, 'A', 2),(1, 'A', 3),(1, 'A', 4),(1, 'A', 5),(1, 'A', 6),(1, 'A', 7),(1, 'A', 8),(1, 'A', 9),(1, 'A', 10),
       (1, 'B', 1),(1, 'B', 2),(1, 'B', 3),(1, 'B', 4),(1, 'B', 5),(1, 'B', 6),(1, 'B', 7),(1, 'B', 8),(1, 'B', 9),(1, 'B', 10),
       (1, 'C', 1),(1, 'C', 2),(1, 'C', 3),(1, 'C', 4),(1, 'C', 5),(1, 'C', 6),(1, 'C', 7),(1, 'C', 8),(1, 'C', 9),(1, 'C', 10),
       (1, 'D', 1),(1, 'D', 2),(1, 'D', 3),(1, 'D', 4),(1, 'D', 5),(1, 'D', 6),(1, 'D', 7),(1, 'D', 8),(1, 'D', 9),(1, 'D', 10),
--     성수 2관
       (2, 'A', 1),(2, 'A', 2),(2, 'A', 3),(2, 'A', 4),(2, 'A', 5),(2, 'A', 6),(2, 'A', 7),(2, 'A', 8),(2, 'A', 9),(2, 'A', 10),
       (2, 'B', 1),(2, 'B', 2),(2, 'B', 3),(2, 'B', 4),(2, 'B', 5),(2, 'B', 6),(2, 'B', 7),(2, 'B', 8),(2, 'B', 9),(2, 'B', 10),
       (2, 'C', 1),(2, 'C', 2),(2, 'C', 3),(2, 'C', 4),(2, 'C', 5),(2, 'C', 6),(2, 'C', 7),(2, 'C', 8),(2, 'C', 9),(2, 'C', 10),
       (2, 'D', 1),(2, 'D', 2),(2, 'D', 3),(2, 'D', 4),(2, 'D', 5),(2, 'D', 6),(2, 'D', 7),(2, 'D', 8),(2, 'D', 9),(2, 'D', 10),
--     성수 3관
       (3, 'A', 1),(3, 'A', 2),(3, 'A', 3),(3, 'A', 4),(3, 'A', 5),(3, 'A', 6),(3, 'A', 7),(3, 'A', 8),(3, 'A', 9),(3, 'A', 10),
       (3, 'B', 1),(3, 'B', 2),(3, 'B', 3),(3, 'B', 4),(3, 'B', 5),(3, 'B', 6),(3, 'B', 7),(3, 'B', 8),(3, 'B', 9),(3, 'B', 10),
       (3, 'C', 1),(3, 'C', 2),(3, 'C', 3),(3, 'C', 4),(3, 'C', 5),(3, 'C', 6),(3, 'C', 7),(3, 'C', 8),(3, 'C', 9),(3, 'C', 10),
       (3, 'D', 1),(3, 'D', 2),(3, 'D', 3),(3, 'D', 4),(3, 'D', 5),(3, 'D', 6),(3, 'D', 7),(3, 'D', 8),(3, 'D', 9),(3, 'D', 10),
--     홍대 1관
       (4, 'A', 1),(4, 'A', 2),(4, 'A', 3),(4, 'A', 4),(4, 'A', 5),(4, 'A', 6),(4, 'A', 7),(4, 'A', 8),(4, 'A', 9),(4, 'A', 10),
       (4, 'B', 1),(4, 'B', 2),(4, 'B', 3),(4, 'B', 4),(4, 'B', 5),(4, 'B', 6),(4, 'B', 7),(4, 'B', 8),(4, 'B', 9),(4, 'B', 10),
       (4, 'C', 1),(4, 'C', 2),(4, 'C', 3),(4, 'C', 4),(4, 'C', 5),(4, 'C', 6),(4, 'C', 7),(4, 'C', 8),(4, 'C', 9),(4, 'C', 10),
       (4, 'D', 1),(4, 'D', 2),(4, 'D', 3),(4, 'D', 4),(4, 'D', 5),(4, 'D', 6),(4, 'D', 7),(4, 'D', 8),(4, 'D', 9),(4, 'D', 10),
--     홍대 2관
       (5, 'A', 1),(5, 'A', 2),(5, 'A', 3),(5, 'A', 4),(5, 'A', 5),(5, 'A', 6),(5, 'A', 7),(5, 'A', 8),(5, 'A', 9),(5, 'A', 10),
       (5, 'B', 1),(5, 'B', 2),(5, 'B', 3),(5, 'B', 4),(5, 'B', 5),(5, 'B', 6),(5, 'B', 7),(5, 'B', 8),(5, 'B', 9),(5, 'B', 10),
       (5, 'C', 1),(5, 'C', 2),(5, 'C', 3),(5, 'C', 4),(5, 'C', 5),(5, 'C', 6),(5, 'C', 7),(5, 'C', 8),(5, 'C', 9),(5, 'C', 10),
       (5, 'D', 1),(5, 'D', 2),(5, 'D', 3),(5, 'D', 4),(5, 'D', 5),(5, 'D', 6),(5, 'D', 7),(5, 'D', 8),(5, 'D', 9),(5, 'D', 10),
--     홍대 3관
       (6, 'A', 1),(6, 'A', 2),(6, 'A', 3),(6, 'A', 4),(6, 'A', 5),(6, 'A', 6),(6, 'A', 7),(6, 'A', 8),(6, 'A', 9),(6, 'A', 10),
       (6, 'B', 1),(6, 'B', 2),(6, 'B', 3),(6, 'B', 4),(6, 'B', 5),(6, 'B', 6),(6, 'B', 7),(6, 'B', 8),(6, 'B', 9),(6, 'B', 10),
       (6, 'C', 1),(6, 'C', 2),(6, 'C', 3),(6, 'C', 4),(6, 'C', 5),(6, 'C', 6),(6, 'C', 7),(6, 'C', 8),(6, 'C', 9),(6, 'C', 10),
       (6, 'D', 1),(6, 'D', 2),(6, 'D', 3),(6, 'D', 4),(6, 'D', 5),(6, 'D', 6),(6, 'D', 7),(6, 'D', 8),(6, 'D', 9),(6, 'D', 10),
--     양재 1관
       (7, 'A', 1),(7, 'A', 2),(7, 'A', 3),(7, 'A', 4),(7, 'A', 5),(7, 'A', 6),(7, 'A', 7),(7, 'A', 8),(7, 'A', 9),(7, 'A', 10),
       (7, 'B', 1),(7, 'B', 2),(7, 'B', 3),(7, 'B', 4),(7, 'B', 5),(7, 'B', 6),(7, 'B', 7),(7, 'B', 8),(7, 'B', 9),(7, 'B', 10),
       (7, 'C', 1),(7, 'C', 2),(7, 'C', 3),(7, 'C', 4),(7, 'C', 5),(7, 'C', 6),(7, 'C', 7),(7, 'C', 8),(7, 'C', 9),(7, 'C', 10),
       (7, 'D', 1),(7, 'D', 2),(7, 'D', 3),(7, 'D', 4),(7, 'D', 5),(7, 'D', 6),(7, 'D', 7),(7, 'D', 8),(7, 'D', 9),(7, 'D', 10),
--     양재 2관
       (8, 'A', 1),(8, 'A', 2),(8, 'A', 3),(8, 'A', 4),(8, 'A', 5),(8, 'A', 6),(8, 'A', 7),(8, 'A', 8),(8, 'A', 9),(8, 'A', 10),
       (8, 'B', 1),(8, 'B', 2),(8, 'B', 3),(8, 'B', 4),(8, 'B', 5),(8, 'B', 6),(8, 'B', 7),(8, 'B', 8),(8, 'B', 9),(8, 'B', 10),
       (8, 'C', 1),(8, 'C', 2),(8, 'C', 3),(8, 'C', 4),(8, 'C', 5),(8, 'C', 6),(8, 'C', 7),(8, 'C', 8),(8, 'C', 9),(8, 'C', 10),
       (8, 'D', 1),(8, 'D', 2),(8, 'D', 3),(8, 'D', 4),(8, 'D', 5),(8, 'D', 6),(8, 'D', 7),(8, 'D', 8),(8, 'D', 9),(8, 'D', 10)
;

INSERT INTO showing(movieId, auditoriumId, showDate, startTime, endTime, price)
--     첫날
VALUES (1, 1, DATEADD('DAY', 0, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 0, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 0, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 0, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 0, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 0, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 0, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 0, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 0, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 0, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 0, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 0, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 0, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 0, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 0, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 0, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 0, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 0, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 0, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 0, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
--     1일차
       (1, 1, DATEADD('DAY', 1, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 1, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 1, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 1, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 1, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 1, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 1, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 1, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 1, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 1, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 1, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 1, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 1, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 1, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (1, 4, DATEADD('DAY', 1, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 1, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 1, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 1, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 1, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 1, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 1, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 1, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 6, DATEADD('DAY', 1, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 1, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 1, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 1, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 1, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 1, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (2, 7, DATEADD('DAY', 1, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 양재 1관 더 퍼스트 슬램덩크
       (2, 7, DATEADD('DAY', 1, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 1, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 7, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 1, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 8, DATEADD('DAY', 1, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 양재 2관 스즈메의 문단속
       (3, 8, DATEADD('DAY', 1, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 1, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 1, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 8, DATEADD('DAY', 1, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 1, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 1, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     2일차
       (1, 1, DATEADD('DAY', 2, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 2, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 2, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 2, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 2, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 2, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 2, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 2, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 2, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 2, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 2, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 2, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 2, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 2, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 2, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 2, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 2, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (1, 4, DATEADD('DAY', 2, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 2, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 2, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 2, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 2, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 2, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 2, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 2, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 2, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 2, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 6, DATEADD('DAY', 2, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 2, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 2, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 2, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 2, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 2, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 2, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     3일차
       (1, 1, DATEADD('DAY', 3, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 3, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 3, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 3, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 3, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 3, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 3, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 3, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 3, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 3, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 3, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 3, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 3, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 3, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (1, 4, DATEADD('DAY', 3, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 3, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 3, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 3, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 3, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 3, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 3, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 3, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 6, DATEADD('DAY', 3, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 3, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 3, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 3, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 3, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 3, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (2, 7, DATEADD('DAY', 3, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 양재 1관 더 퍼스트 슬램덩크
       (2, 7, DATEADD('DAY', 3, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 3, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 7, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 3, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 8, DATEADD('DAY', 3, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 양재 2관 스즈메의 문단속
       (3, 8, DATEADD('DAY', 3, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 3, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 3, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 8, DATEADD('DAY', 3, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 3, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 3, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     4일차
       (1, 1, DATEADD('DAY', 4, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 4, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 4, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 4, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 4, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 4, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 4, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 4, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 4, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 4, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 4, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 4, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 4, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 4, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 4, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 4, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 4, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (1, 4, DATEADD('DAY', 4, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 4, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 4, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 4, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 4, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 4, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 4, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 4, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 4, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 4, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 6, DATEADD('DAY', 4, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 4, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 4, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 4, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 4, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 4, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 4, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     5일차
       (1, 1, DATEADD('DAY', 5, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 5, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 5, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 5, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 5, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 5, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 5, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 5, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 5, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 5, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 5, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 5, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 5, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 5, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (1, 4, DATEADD('DAY', 5, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 5, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 5, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 5, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 5, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 5, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 5, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 5, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 6, DATEADD('DAY', 5, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 5, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 5, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 5, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 5, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 5, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (2, 7, DATEADD('DAY', 5, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 양재 1관 더 퍼스트 슬램덩크
       (2, 7, DATEADD('DAY', 5, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 5, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 7, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 5, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 8, DATEADD('DAY', 5, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 양재 2관 스즈메의 문단속
       (3, 8, DATEADD('DAY', 5, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 5, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 5, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 8, DATEADD('DAY', 5, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 5, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 5, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     6일차
       (1, 1, DATEADD('DAY', 6, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 6, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 6, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 6, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 6, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 6, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 6, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 6, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 6, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 6, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 6, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 6, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 6, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 6, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 6, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 6, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 6, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (1, 4, DATEADD('DAY', 6, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 6, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 6, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 6, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 6, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 6, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 6, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 6, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 6, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 6, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 6, DATEADD('DAY', 6, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 6, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 6, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 6, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 6, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 6, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 6, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     7일차
       (1, 1, DATEADD('DAY', 7, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 1관 존 윅4
       (1, 1, DATEADD('DAY', 7, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 7, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 1, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 1, DATEADD('DAY', 7, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 7, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 성수 2관 더 퍼스트 슬램덩크
       (2, 2, DATEADD('DAY', 7, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 7, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 2, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 2, DATEADD('DAY', 7, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 7, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 7, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 7, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 7, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 7, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 7, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (1, 4, DATEADD('DAY', 7, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 1관 존 윅4
       (1, 4, DATEADD('DAY', 7, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 7, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (1, 4, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (1, 4, DATEADD('DAY', 7, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 7, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 홍대 2관 더 퍼스트 슬램덩크
       (2, 5, DATEADD('DAY', 7, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 7, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 5, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 5, DATEADD('DAY', 7, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 6, DATEADD('DAY', 7, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 7, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 7, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 7, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 7, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 7, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (2, 7, DATEADD('DAY', 7, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 양재 1관 더 퍼스트 슬램덩크
       (2, 7, DATEADD('DAY', 7, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 7, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 7, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 7, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 8, DATEADD('DAY', 7, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 양재 2관 스즈메의 문단속
       (3, 8, DATEADD('DAY', 7, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 7, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 7, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 8, DATEADD('DAY', 7, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 7, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 7, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     8일차
       (4, 1, DATEADD('DAY', 8, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 성수 1관 옥수역귀신
       (4, 1, DATEADD('DAY', 8, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 1, DATEADD('DAY', 8, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 1, DATEADD('DAY', 8, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 1, DATEADD('DAY', 8, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 1, DATEADD('DAY', 8, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 8, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 8, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 8, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 8, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 8, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 8, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 8, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 8, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 홍대 1관 옥수역귀신
       (4, 4, DATEADD('DAY', 8, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 8, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 8, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 4, DATEADD('DAY', 8, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 4, DATEADD('DAY', 8, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 8, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 8, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 8, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 8, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 8, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 8, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 8, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (2, 7, DATEADD('DAY', 8, CURRENT_DATE), TIME '07:00:00', TIME '10:10:00', 14000.00), -- 양재 1관 더 퍼스트 슬램덩크
       (2, 7, DATEADD('DAY', 8, CURRENT_DATE), TIME '10:30:00', TIME '13:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 8, CURRENT_DATE), TIME '14:00:00', TIME '17:10:00', 14000.00),
       (2, 7, DATEADD('DAY', 8, CURRENT_DATE), TIME '17:30:00', TIME '20:40:00', 14000.00),
       (2, 7, DATEADD('DAY', 8, CURRENT_DATE), TIME '20:00:00', TIME '23:10:00', 14000.00),
       (3, 8, DATEADD('DAY', 8, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 양재 2관 스즈메의 문단속
       (3, 8, DATEADD('DAY', 8, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 8, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 8, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 8, DATEADD('DAY', 8, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 8, DATEADD('DAY', 8, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 8, DATEADD('DAY', 8, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),

--     9일차
       (4, 1, DATEADD('DAY', 9, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 성수 1관 존 옥수역귀신
       (4, 1, DATEADD('DAY', 9, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 1, DATEADD('DAY', 9, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 1, DATEADD('DAY', 9, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 1, DATEADD('DAY', 9, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 1, DATEADD('DAY', 9, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 9, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 2관 킬링로맨스
       (5, 2, DATEADD('DAY', 9, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 9, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 2, DATEADD('DAY', 9, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 9, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 9, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 9, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 9, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 9, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 9, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 9, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 9, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 9, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 홍대 1관 존 옥수역귀신
       (4, 4, DATEADD('DAY', 9, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 9, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 9, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 4, DATEADD('DAY', 9, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 4, DATEADD('DAY', 9, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 9, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 2관 킬링로맨스
       (5, 5, DATEADD('DAY', 9, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 9, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 5, DATEADD('DAY', 9, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 9, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (3, 5, DATEADD('DAY', 9, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 9, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 9, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 9, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 9, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 9, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 9, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),

--     10일차
       (4, 1, DATEADD('DAY', 10, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 성수 1관 존 옥수역귀신
       (4, 1, DATEADD('DAY', 10, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 1, DATEADD('DAY', 10, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 1, DATEADD('DAY', 10, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 1, DATEADD('DAY', 10, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 1, DATEADD('DAY', 10, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 10, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 2관 킬링로맨스
       (5, 2, DATEADD('DAY', 10, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 10, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 2, DATEADD('DAY', 10, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 10, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (3, 3, DATEADD('DAY', 10, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 성수 3관 스즈메의 문단속
       (3, 3, DATEADD('DAY', 10, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 10, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 10, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 3, DATEADD('DAY', 10, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 3, DATEADD('DAY', 10, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 3, DATEADD('DAY', 10, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 10, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 홍대 1관 존 옥수역귀신
       (4, 4, DATEADD('DAY', 10, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 10, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 10, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 4, DATEADD('DAY', 10, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 4, DATEADD('DAY', 10, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 10, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 2관 킬링로맨스
       (5, 5, DATEADD('DAY', 10, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 10, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 5, DATEADD('DAY', 10, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 10, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (3, 5, DATEADD('DAY', 10, CURRENT_DATE), TIME '07:00:00', TIME '09:20:00', 14000.00), -- 홍대 3관 스즈메의 문단속
       (3, 6, DATEADD('DAY', 10, CURRENT_DATE), TIME '09:40:00', TIME '12:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 10, CURRENT_DATE), TIME '12:20:00', TIME '14:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 10, CURRENT_DATE), TIME '15:00:00', TIME '17:20:00', 14000.00),
       (3, 6, DATEADD('DAY', 10, CURRENT_DATE), TIME '17:40:00', TIME '18:00:00', 14000.00),
       (3, 6, DATEADD('DAY', 10, CURRENT_DATE), TIME '18:20:00', TIME '20:40:00', 14000.00),
       (3, 6, DATEADD('DAY', 10, CURRENT_DATE), TIME '21:00:00', TIME '23:20:00', 14000.00),
--     11일차
       (4, 1, DATEADD('DAY', 11, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 성수 1관 옥수역귀신
       (4, 1, DATEADD('DAY', 11, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 1, DATEADD('DAY', 11, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 1, DATEADD('DAY', 11, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 1, DATEADD('DAY', 11, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 1, DATEADD('DAY', 11, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 11, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 2관 킬링로맨스
       (5, 2, DATEADD('DAY', 11, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 11, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 2, DATEADD('DAY', 11, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 11, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 11, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 홍대 1관 옥수역귀신
       (4, 4, DATEADD('DAY', 11, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 11, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 11, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 4, DATEADD('DAY', 11, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 4, DATEADD('DAY', 11, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 11, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 2관 킬링로맨스
       (5, 5, DATEADD('DAY', 11, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 11, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 5, DATEADD('DAY', 11, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 11, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),

--     12일차
       (4, 1, DATEADD('DAY', 12, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 성수 1관 옥수역귀신
       (4, 1, DATEADD('DAY', 12, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 1, DATEADD('DAY', 12, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 1, DATEADD('DAY', 12, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 1, DATEADD('DAY', 12, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 1, DATEADD('DAY', 12, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 12, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 2관 킬링로맨스
       (5, 2, DATEADD('DAY', 12, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 12, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 2, DATEADD('DAY', 12, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 12, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 12, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 홍대 1관 옥수역귀신
       (4, 4, DATEADD('DAY', 12, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 12, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 12, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 4, DATEADD('DAY', 12, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 4, DATEADD('DAY', 12, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 12, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 2관 킬링로맨스
       (5, 5, DATEADD('DAY', 12, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 12, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 5, DATEADD('DAY', 12, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 12, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
--     13일차
       (4, 1, DATEADD('DAY', 13, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 성수 1관 옥수역귀신
       (4, 1, DATEADD('DAY', 13, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 1, DATEADD('DAY', 13, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 1, DATEADD('DAY', 13, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 1, DATEADD('DAY', 13, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 1, DATEADD('DAY', 13, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 13, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 2관 킬링로맨스
       (5, 2, DATEADD('DAY', 13, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 13, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 2, DATEADD('DAY', 13, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 13, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 13, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 홍대 1관 옥수역귀신
       (4, 4, DATEADD('DAY', 13, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 13, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 13, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 4, DATEADD('DAY', 13, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 4, DATEADD('DAY', 13, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 13, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 2관 킬링로맨스
       (5, 5, DATEADD('DAY', 13, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 13, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 5, DATEADD('DAY', 13, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 13, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
--     14일차
       (4, 1, DATEADD('DAY', 14, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 성수 1관 옥수역귀신
       (4, 1, DATEADD('DAY', 14, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 1, DATEADD('DAY', 14, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 1, DATEADD('DAY', 14, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 1, DATEADD('DAY', 14, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 1, DATEADD('DAY', 14, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 14, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 성수 2관 킬링로맨스
       (5, 2, DATEADD('DAY', 14, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 14, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 2, DATEADD('DAY', 14, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 2, DATEADD('DAY', 14, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 14, CURRENT_DATE), TIME '07:00:00', TIME '09:30:00', 14000.00), -- 홍대 1관 옥수역귀신
       (4, 4, DATEADD('DAY', 14, CURRENT_DATE), TIME '09:50:00', TIME '12:20:00', 14000.00),
       (4, 4, DATEADD('DAY', 14, CURRENT_DATE), TIME '12:40:00', TIME '15:10:00', 14000.00),
       (4, 4, DATEADD('DAY', 14, CURRENT_DATE), TIME '15:30:00', TIME '18:00:00', 14000.00),
       (4, 4, DATEADD('DAY', 14, CURRENT_DATE), TIME '18:20:00', TIME '20:50:00', 14000.00),
       (4, 4, DATEADD('DAY', 14, CURRENT_DATE), TIME '21:10:00', TIME '23:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 14, CURRENT_DATE), TIME '10:00:00', TIME '12:10:00', 14000.00), -- 홍대 2관 킬링로맨스
       (5, 5, DATEADD('DAY', 14, CURRENT_DATE), TIME '12:30:00', TIME '14:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 14, CURRENT_DATE), TIME '15:00:00', TIME '17:10:00', 14000.00),
       (5, 5, DATEADD('DAY', 14, CURRENT_DATE), TIME '17:30:00', TIME '19:40:00', 14000.00),
       (5, 5, DATEADD('DAY', 14, CURRENT_DATE), TIME '20:00:00', TIME '22:10:00', 14000.00)
;
