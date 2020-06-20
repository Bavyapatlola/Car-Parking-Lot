CREATE SCHEMA `dbfp` ;
use dbfp;

create table D_GANE_ADDRESS 
(
	addressid INT AUTO_INCREMENT
    ,LINE1 varchar(100) not null
    ,LINE2 varchar(100) not null
    ,CITY varchar(100) not null
    ,STATE varchar(100) not null
    ,ZIP INT not null
    ,STATUS varchar(100) not null
    ,CREATEDDATE date not null
    ,UPDATEDDATE date not null
    ,constraint ADDRESS_PK primary key(ADDRESSID)
);

create table D_GANE_PARKINGCATEGORY
(
	PARKINGCATEGORYID INT AUTO_INCREMENT
    ,description varchar(100) not null
    ,constraint D_GANE_PARKINGCATEGORY_pk primary key(PARKINGCATEGORYID)
);

create table D_GANE_USERPROFILE 
(
	userid INT AUTO_INCREMENT
    ,firstname varchar(100) not null
    ,lastname varchar(100) not null
    ,addressid INT
    ,username varchar(100) not null
    ,password varchar(100) not null
    ,role varchar(100)
    ,studentid varchar(10) default null
    ,emailid varchar(30) not null
    ,authorized varchar(1) not null
    ,CREATEDDATE date not null
    ,UPDATEDDATE date not null
    ,constraint D_GANE_USERPROFILE_PK primary key(userid)
    ,constraint D_GANE_ADDRESS_FK foreign key(addressid)
    references D_GANE_ADDRESS(addressid)
);


create table D_GANE_PARKINGLOT
(
	PARKINGLOTID INT AUTO_INCREMENT
    ,description varchar(100) not null
    ,noofspace INT not null
    ,PARKINGCATEGORYID INT
    ,addressid INT
    ,status varchar(100) not null
    ,createddate date not null
    ,updateddate date not null
    ,constraint D_GANE_PARKINGLOT_pk primary key(PARKINGLOTID)
    ,constraint D_GANE_PARKINGCATEGORY_fk foreign key (PARKINGCATEGORYID)
    references D_GANE_PARKINGCATEGORY(PARKINGCATEGORYID)
);

create table parkinglotdetails   
(
	PLOTID INT AUTO_INCREMENT
    ,PARKINGLOTID INT
    ,ishandicapped varchar(10)
    ,status varchar(100) not null
    ,createddate date not null
    ,updateddate date not null
    ,constraint parkinglotdetails_pk primary key (PLOTID)
    ,constraint D_GANE_PARKINGLOT_FK foreign key(PARKINGLOTID) 
    references  D_GANE_PARKINGLOT(PARKINGLOTID)
);

create table D_GANE_PARKINGLOT_LOG 
(
	bookingid INT AUTO_INCREMENT
    ,PARKINGLOTID INT
    ,userid INT
    ,price INT
    ,fromdate date
    ,todate date
    ,constraint D_GANE_PARKINGLOT_LOG_PK primary key (bookingid)
    ,constraint D_GANE_USERPROFILE_FK foreign key(userid) references D_GANE_USERPROFILE (userid)
);

COMMIT;

