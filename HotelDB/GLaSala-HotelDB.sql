CREATE DATABASE GLaSalaHotelDB;
use GLaSalaHotelDB;

CREATE TABLE Guests (
	guest_id int AUTO_INCREMENT,-- primary 
    guest_name varchar(50),
    guest_add varchar(50),
    city_name varchar(50),
    zip_code varchar(15),
    state_name varchar(5),
    phone_num varchar(15),
    CONSTRAINT PK_Guest PRIMARY KEY (guest_id)
);

CREATE TABLE Amentities (
	amentities_id int NOT NULL AUTO_INCREMENT,-- primary 
    amenity_name varchar(15) NOT NULL,
    CONSTRAINT PK_Amentities PRIMARY KEY (amentities_id)
);

CREATE TABLE Rooms (
	rooms_id int NOT NULL AUTO_INCREMENT,-- primary 
    room_num int NOT NULL,
    CONSTRAINT PK_Rooms PRIMARY KEY (rooms_id)
);

CREATE TABLE RoomType (
	room_type_id int NOT NULL AUTO_INCREMENT,-- primary 
    room_type varchar(10) NOT NULL,
    CONSTRAINT PK_RoomType PRIMARY KEY (room_type_id)
);

CREATE TABLE AmentitiesRoom (
    rooms_id int NOT NULL, -- foriegn
    amentities_id int NOT NULL, -- foriegn
    CONSTRAINT FOREIGN KEY FK_rooms_num (rooms_id)
        REFERENCES Rooms (rooms_id),
	CONSTRAINT FOREIGN KEY FK_ammens_id (amentities_id)
        REFERENCES Amentities (amentities_id)
);

CREATE TABLE RoomData (
	room_id int NOT NULL AUTO_INCREMENT, -- primary 
    rooms_id int NOT NULL, -- foriegn
    room_type_id int NOT NULL, -- foriegn
    room_price int NOT NULL,
    room_add_price int,
    ada_acc boolean NOT NULL,
    min_Occ int NOT NULL,
    max_Occ int NOT NULL,
    CONSTRAINT PK_RoomData PRIMARY KEY (room_id),
    CONSTRAINT FOREIGN KEY FK_RoomsId (rooms_id)
        REFERENCES Rooms (rooms_id),
	CONSTRAINT FOREIGN KEY FK_TypeID (room_type_id)
        REFERENCES RoomType (room_type_id)
);

CREATE TABLE Reservations (
	reservation_id int NOT NULL AUTO_INCREMENT,-- primary 
    room_id int NOT NULL, -- foriegn
    guest_id int NOT NULL, -- foriegn
    num_adults int NOT NULL,
    num_children int NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    total_cost int NOT NULL,
    CONSTRAINT PK_Reservationse PRIMARY KEY (reservation_id),
	CONSTRAINT FOREIGN KEY FK_RoomID (room_id)
        REFERENCES RoomData (room_id),
	CONSTRAINT FOREIGN KEY FK_guestID (guest_id)
        REFERENCES Guests (guest_id)
);