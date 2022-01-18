insert into customer(customer_id, name) values (500, 'Robert');
insert into customer(customer_id, name) values (501, 'Steven');
insert into customer(customer_id, name) values (502, 'Brandon');
insert into customer(customer_id, name) values (503, 'Nahom');

insert into transaction(id, description, total, save_date, customer_id) values (1001, 'Purchase 1', 100, '2021-10-17 10:20:10', 500);
insert into transaction(id, description, total, save_date, customer_id) values (1002, 'Purchase 2', 50, '2021-10-01 10:20:10', 500);
insert into transaction(id, description, total, save_date, customer_id) values (1003, 'Purchase 3', 120, '2021-10-10 10:20:10', 500);
insert into transaction(id, description, total, save_date, customer_id) values (1004, 'Purchase 10', 175.32, '2021-11-07 10:20:10', 500);
insert into transaction(id, description, total, save_date, customer_id) values (1005, 'Purchase 20', 65.75, '2021-11-05 10:20:10', 500);

insert into transaction(id, description, total, save_date, customer_id) values (1006, 'Purchase 30', 210.50, '2021-10-03 10:20:10', 502);
insert into transaction(id, description, total, save_date, customer_id) values (1009, 'Purchase 31', 42.80, '2021-10-18 17:10:10', 502);

insert into transaction(id, description, total, save_date, customer_id) values (1200, 'Purchase 200', 25.60, '2021-10-01 12:20:10', 503);
insert into transaction(id, description, total, save_date, customer_id) values (1201, 'Purchase 201', 80.50, '2021-10-05 15:00:10', 503);
insert into transaction(id, description, total, save_date, customer_id) values (1202, 'Purchase 202', 116.14, '2021-10-10 11:30:10', 503);

insert into transaction(id, description, total, save_date, customer_id) values (1008, 'Purchase 5', 200, '2021-10-17 10:20:10', 501);