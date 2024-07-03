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

insert into guests(id, first_name, last_name, event_id) values
        (300, 'Dayo', 'Akinyemi', 200),
        (301, 'Tolu', 'Akinyemi', 200),
        (302, 'Tobi', 'Akinyemi', 200),
        (303, 'Abbey', 'Akinyemi', 200),
        (304, 'Bali', 'Akinyemi', 200),
        (305, 'Chichi', 'Akinyemi', 200),
        (306, 'Chichi', 'Akinyemi', 203),
        (307, 'Chichi', 'Akinyemi', 203);

insert into tickets(id, type, price, event_id) values
        (400, 'REGULAR', 5000, 201),
        (401, 'VIP', 15000, 201),
        (402, 'VVIP', 50000, 201);