use GLaSalaHotelDB;

-- For each query, include:
	
	-- The query itself
	-- The results of the query in a comment under the query
    
-- returns a list of reservations that end in July 2023, including the name of the guest, the room number(s), and the reservation dates.
SELECT
	reservations.start_date,
    reservations.end_date,
    reservations.guest_id,
    reservations.room_id,
	guests.guest_name,
    rooms.room_num
FROM reservations
inner join guests on reservations.guest_id = guests.guest_id
inner join rooms on reservations.room_id = rooms.rooms_id
Where end_date between  '2023-07-01' and '2023-08-01';
-- start_date, end_date, guest_id, room_id, guest_name, room_num
-- 2023-06-28	2023-07-02	1	5	Gerrid La Sala	205
-- 2023-07-13	2023-07-14	9	4	Walter Holaway	204
-- 2023-07-18	2023-07-21	10	17	Wilfred Vise	401
-- 2023-07-28	2023-07-29	3	11	Bettyann Seery	303


-- returns a list of all reservations for rooms with a jacuzzi, displaying the guest's name, the room number, and the dates of the reservation.
SELECT
	reservations.start_date,
    reservations.end_date,
    reservations.guest_id,
    reservations.room_id,
	guests.guest_name,
    rooms.room_num,
    amentities.amentities_id
FROM reservations
inner join guests on reservations.guest_id = guests.guest_id
inner join rooms on reservations.room_id = rooms.rooms_id
inner join amentities on rooms.rooms_id =  amentities.amentities_id
Where amentities_id = 3;
-- start_date, end_date, guest_id, room_id, guest_name, room_num, amentities_id
-- 2023-02-05	2023-02-10	3	3	Bettyann Seery	203	3
-- 2023-09-13	2023-09-15	5	3	Karie Yang	203	3


--  returns all the rooms reserved for a specific guest, including the guest's name, the room(s) reserved, the starting date of the reservation, and how many people were included in the reservation. (Choose a guest's name from the existing data.)
SELECT
	reservations.start_date,
    reservations.end_date,
    reservations.guest_id,
    reservations.room_id,
    reservations.num_adults,
    reservations.num_children,
    (reservations.num_adults + reservations.num_children) AS totalOccupants,
	guests.guest_name,
    rooms.room_num
FROM reservations
inner join guests on reservations.guest_id = guests.guest_id
inner join rooms on reservations.room_id = rooms.rooms_id
Where guest_name = 'Gerrid La Sala';

-- start_date, end_date, guest_id, room_id, num_adults, num_children, totalOccupants, guest_name, room_num
-- 2023-03-17	2023-03-20	1	15	1	1	2	Gerrid La Sala	307
-- 2023-06-28	2023-07-02	1	5	2	0	2	Gerrid La Sala	205
-- 2023-09-16	2023-09-17	1	8	2	0	2	Gerrid La Sala	208

-- returns a list of rooms, reservation ID, and per-room cost for each reservation. The results should include all rooms, whether or not there is a reservation associated with the room.
SELECT
	rooms.room_num,
    reservations.reservation_id,
    reservations.room_id,
    reservations.total_cost
FROM rooms
left outer join reservations on rooms.rooms_id = reservations.room_id;

-- room_num, reservation_id, room_id, total_cost
-- 201	4	1	200
-- 202	7	2	350
-- 203	2	3	1000
-- 203	21	3	400
-- 204	16	4	185
-- 205	15	5	700
-- 206	12	6	600
-- 206	23	6	450
-- 208	13	8	600
-- 208	20	8	150
-- 301	9	9	800
-- 301	24	9	600
-- 302	6	10	925
-- 302	25	10	700
-- 303	18	11	200
-- 304	8	12	875
-- 304	14	12	185
-- 305	19	13	350
-- 306			
-- 308	1	16	300
-- 401	17	17	1260
-- 402	

		
-- returns all rooms with a capacity of three or more and that are reserved on any date in April 2023.
SELECT
	roomdata.room_id,
    roomdata.min_Occ,
    rooms.room_num,
    reservations.start_date,
    reservations.end_date
From roomdata
	inner join rooms on roomdata.room_id = rooms.rooms_id
	inner join reservations on roomdata.room_id = reservations.room_id
Where min_Occ > 2 and end_date between  '2023-04-01' and '2023-05-01';

-- room_id, min_Occ, room_num, start_date, end_date



-- returns a list of all guest names and the number of reservations per guest, sorted starting with the guest with the most reservations and then by the guest's last name.
SELECT 
	guests.guest_name as 'Guest',
    count(reservations.guest_id) as 'Number of Reservations'
From reservations 
inner join guests 
on reservations.guest_id = guests.guest_id
group by reservations.guest_id;

-- Guest, Number of Reservations
-- 'Gerrid La Sala', '3'
-- 'Mack Simmer', '3'
-- 'Bettyann Seery', '3'
-- 'Duane Cullison', '2'
-- 'Karie Yang', '2'
-- 'Aurore Lipton', '2'
-- 'Zachery Luechtefeld', '1'
-- 'Jeremiah Pendergrass', '1'
-- 'Walter Holaway', '2'
-- 'Wilfred Vise', '3'
-- 'Maritza Tilton', '3'
  


-- displays the name, address, and phone number of a guest based on their phone number. (Choose a phone number from the existing data.)
SELECT
	guests.guest_name,
    guests.guest_add,
    guests.phone_num
FROM guests
WHERE
	phone_num = '(291) 553-0508'

-- guest_name, guest_add, phone_num
-- Gerrid La Sala	123 Sesame Street	(291) 553-0508
-- Mack Simmer	379 Old Shore Street	(291) 553-0508