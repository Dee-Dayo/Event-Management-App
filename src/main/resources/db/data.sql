truncate table organizers cascade;
truncate table events cascade;

insert into organizers(id, business_name, phone_number, email, password) values
        (100, 'Zaphire events', '09018291821', 'zaphire@mail.com', '$2a$10$CFL8HSbwMH78nzxlOhsCdOqlzigZP3hBHFuJaG2etZaM2eGzOu80.'),
        (101, 'Goldit events', '09384928374', 'goldit@mail.com', '$2a$10$CFL8HSbwMH78nzxlOhsCdOqlzigZP3hBHFuJaG2etZaM2eGzOu80.'),
        (102, 'RCCG Camp', '08273840593', 'rccg@mail.com', '$2a$10$CFL8HSbwMH78nzxlOhsCdOqlzigZP3hBHFuJaG2etZaM2eGzOu80.'),
        (103, 'Yemolee', '07273847283', 'yemolee@mail.com', '$2a$10$CFL8HSbwMH78nzxlOhsCdOqlzigZP3hBHFuJaG2etZaM2eGzOu80.');


insert into events(id, event_name, description, location, event_date_time, organizer_id) values
        (200, 'EXPERIENCE 2024', 'Gospel concert', 'TBS', '2024-07-03 18:00:00', 100),
        (201, 'CHIVIDO2024', 'Wedding program', 'Oriental Hotel', '2024-07-03 18:00:00', 100),
        (202, 'WWE RAW', 'Wrestling Match', 'Boxing ring', '2024-07-03 18:00:00', 100),
        (203, 'RCCG Convention', 'Church Convention', 'Lagos Ibadan Expressway', '2024-07-03 18:00:00', 103);