create database ABCHospitalDatabase;

--Create person table
CREATE TABLE Person(
	PersonID int identity(1,1) primary key,
	FirstName NVARCHAR(100) NOT NULL,
	LastName NVARCHAR(100) not null,
	Gender char(1) not null,
	DateOfBirth DATE not null,
	Phone NVARCHAR(30),
	Email NVARCHAR(150),
	Street NVARCHAR(200),
	City NVARCHAR(100),
	Country NVARCHAR(100)
);
select * from Person;

--Insert into Person table(Start insert 100 records)
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Matthew', 'Griffin', 'M', '1986-06-21', '+33 6 12 34 56 01', 'matthew.griffin81@outlook.com', '8181 Pinewood Rd', 'Yonkers', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Benjamin', 'Lewis', 'M', '1985-01-08', '+1 202 555 0113', 'benjamin.lewis13@icloud.com', '1313 Chestnut St', 'Sacramento', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Ella', 'Brooks', 'F', '1994-10-18', '+234 801 234 5616', 'ella.brooks56@hotmail.com', '5656 Teak St', 'Hialeah', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Paisley', 'Flores', 'F', '1996-04-26', '+229 90 11 01 12', 'paisley.flores72@hotmail.com', '7272 Manzanita Rd', 'Jacksonville', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Aiden', 'Edwards', 'M', '1985-07-14', '+44 20 7946 0113', 'aiden.edwards33@outlook.com', '3333 Ivy Ct', 'Detroit', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Andrew', 'Coleman', 'M', '1997-11-23', '+229 90 11 01 05', 'andrew.coleman65@outlook.com', '6565 Fig St', 'Fort Lauderdale', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Emma', 'Carter', 'F', '1992-07-22', '+1 202 555 0102', 'emma.carter2@yahoo.com', '202 Oak St', 'Denver', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Grayson', 'Ward', 'M', '1987-04-28', '+234 801 234 5609', 'grayson.ward49@outlook.com', '4949 Rosewood Ave', 'Jersey City', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Noah', 'Bennett', 'M', '1988-11-05', '+1 202 555 0103', 'noah.bennett3@outlook.com', '303 Pine Rd', 'Seattle', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Julian', 'Cox', 'M', '1993-03-03', '+234 801 234 5607', 'julian.cox47@gmail.com', '4747 Quince Dr', 'Wichita', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Elizabeth', 'Perez', 'F', '1991-11-28', '+44 20 7946 0106', 'elizabeth.perez26@gmail.com', '2626 Elm Ct', 'Salt Lake City', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Bella', 'Foster', 'F', '1991-08-16', '+229 90 11 01 16', 'bella.foster76@yahoo.com', '7676 Neem Dr', 'Norfolk', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('William', 'Thompson', 'M', '1979-12-25', '+1 202 555 0107', 'william.thompson7@hotmail.com', '707 Spruce St', 'Phoenix', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Emily', 'Carter', 'F', '1994-06-30', '+44 20 7946 0104', 'emily.carter24@hotmail.com', '2424 Cypress St', 'Pittsburgh', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Olivia', 'Mitchell', 'F', '1995-01-30', '+1 202 555 0104', 'olivia.mitchell4@gmail.com', '404 Elm Blvd', 'Chicago', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Samuel', 'Rogers', 'M', '1988-01-13', '+44 20 7946 0117', 'samuel.rogers37@gmail.com', '3737 Locust Blvd', 'Albuquerque', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Owen', 'Parker', 'M', '1992-02-20', '+44 20 7946 0111', 'owen.parker31@gmail.com', '3131 Holly Ave', 'Cincinnati', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Avery', 'James', 'F', '1997-03-06', '+234 801 234 5614', 'avery.james54@icloud.com', '5454 Sycamore Blvd', 'Garland', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Elijah', 'Mitchell', 'M', '1987-09-16', '+44 20 7946 0105', 'elijah.mitchell25@outlook.com', '2525 Dogwood Rd', 'San Antonio', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Aurora', 'Gray', 'F', '1992-05-11', '+234 801 234 5612', 'aurora.gray52@yahoo.com', '5252 Silver Birch Ln', 'Durham', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Leo', 'Ramirez', 'M', '1989-06-30', '+234 801 234 5613', 'leo.ramirez53@gmail.com', '5353 Spruce Ct', 'Scottsdale', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Alexander', 'Scott', 'M', '1986-04-04', '+1 202 555 0119', 'alexander.scott19@gmail.com', '1919 Mesquite Blvd', 'Kansas City', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Luna', 'Russell', 'F', '1992-12-03', '+229 90 11 01 20', 'luna.russell80@hotmail.com', '8080 Palm Ct', 'Lubbock', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Isabella', 'Lopez', 'F', '1987-04-19', '+1 202 555 0110', 'isabella.lopez10@outlook.com', '1010 Redwood Way', 'Las Vegas', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Evelyn', 'Green', 'F', '1990-10-31', '+1 202 555 0120', 'evelyn.green20@icloud.com', '2020 Mulberry Ct', 'Columbus', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Isaac', 'Peterson', 'M', '1995-01-07', '+234 801 234 5611', 'isaac.peterson51@gmail.com', '5151 Sequoia Pl', 'Plano', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lily', 'Collins', 'F', '1990-04-25', '+44 20 7946 0114', 'lily.collins34@gmail.com', '3434 Jade Pl', 'Buffalo', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Kayla', 'West', 'F', '1990-06-14', '+33 6 12 34 56 12', 'kayla.west92@yahoo.com', '9292 Citrus Blvd', 'Reno', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Mason', 'Harris', 'M', '1994-06-27', '+1 202 555 0111', 'mason.harris11@gmail.com', '1111 Sycamore Pl', 'Portland', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Anthony', 'Watson', 'M', '1982-11-11', '+234 801 234 5615', 'anthony.watson55@gmail.com', '5555 Tamarack Ave', 'Glendale', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Madison', 'Bennett', 'F', '1993-12-15', '+234 801 234 5620', 'madison.bennett60@yahoo.com', '6060 Willow Way', 'Providence', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jameson', 'Ford', 'M', '1983-07-20', '+33 6 12 34 56 05', 'jameson.ford85@gmail.com', '8585 Alder Ct', 'Winston-Salem', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Nova', 'Myers', 'F', '1990-10-22', '+33 6 12 34 56 04', 'nova.myers84@yahoo.com', '8484 Acacia Blvd', 'Irving', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Cameron', 'Craig', 'M', '1982-08-12', '+33 6 12 34 56 15', 'cameron.craig95@gmail.com', '9595 Cypress Ct', 'Cary', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ethan', 'Martinez', 'M', '1996-08-03', '+1 202 555 0109', 'ethan.martinez9@yahoo.com', '909 Poplar Ct', 'Atlanta', 'USA');

INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('James', 'Robinson', 'M', '1984-09-17', '+1 202 555 0105', 'james.robinson5@icloud.com', '505 Cedar Ln', 'Boston', 'USA');

INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Logan', 'Roberts', 'M', '1998-04-12', '+44 20 7946 0107', 'logan.roberts27@gmail.com', '2727 Fern Ave', 'Baltimore', 'UK');

INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Connor', 'Graham', 'M', '1991-04-20', '+33 6 12 34 56 07', 'connor.graham87@gmail.com', '8787 Aspen Ct', 'Modesto', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Jocelyn', 'Hicks', 'F', '1995-12-07', '+33 6 12 34 56 14', 'jocelyn.hicks94@icloud.com', '9494 Cocoa Ave', 'Orange', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Joshua', 'Perry', 'M', '1988-01-09', '+229 90 11 01 07', 'joshua.perry67@gmail.com', '6767 Hawthorn Blvd', 'Louisville', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Joseph', 'Hayes', 'M', '1994-04-13', '+33 6 12 34 56 03', 'joseph.hayes83@gmail.com', '8383 Redbud Ave', 'Paterson', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Hazel', 'Patterson', 'F', '1994-02-17', '+229 90 11 01 10', 'hazel.patterson70@icloud.com', '7070 Larch Ave', 'Anchorage', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ryan', 'Washington', 'M', '1984-02-22', '+229 90 11 01 13', 'ryan.washington73@outlook.com', '7373 Juniper Ct', 'Lincoln', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Sophia', 'Garcia', 'F', '1991-02-14', '+1 202 555 0108', 'sophia.garcia8@gmail.com', '808 Willow Dr', 'Dallas', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Penelope', 'Murphy', 'F', '1995-05-31', '+234 801 234 5602', 'penelope.murphy42@gmail.com', '4242 Olive Ln', 'Fresno', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Abigail', 'Adams', 'F', '1996-08-24', '+44 20 7946 0102', 'abigail.adams22@gmail.com', '2222 Alder Way', 'Indianapolis', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Mia', 'Clark', 'F', '1998-10-11', '+1 202 555 0112', 'mia.clark12@gmail.com', '1212 Aspen Ave', 'San Diego', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Sofia', 'Turner', 'F', '1995-12-01', '+44 20 7946 0108', 'sofia.turner28@icloud.com', '2828 Fir Ln', 'New Orleans', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Liam', 'Anderson', 'M', '1990-03-14', '+1 202 555 0101', 'liam.anderson1@gmail.com', '101 Maple Ave', 'Austin', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Carter', 'Bell', 'M', '1991-07-18', '+234 801 234 5601', 'carter.bell41@outlook.com', '4141 Oakdale St', 'Richmond', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Michael', 'Nelson', 'M', '1983-03-11', '+44 20 7946 0103', 'michael.nelson23@gmail.com', '2323 Beech Ave', 'St. Louis', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Charles', 'Wood', 'M', '1998-06-01', '+229 90 11 01 01', 'charles.wood61@gmail.com', '6161 Yew Rd', 'Corpus Christi', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Grace', 'Campbell', 'F', '1993-06-08', '+44 20 7946 0110', 'grace.campbell30@gmail.com', '3030 Hazel Dr', 'Raleigh', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Wyatt', 'Cooper', 'M', '1984-10-07', '+234 801 234 5605', 'wyatt.cooper45@gmail.com', '4545 Pine Cone Rd', 'Arlington', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Maya', 'Bryant', 'F', '1995-09-08', '+229 90 11 01 18', 'maya.bryant78@icloud.com', '7878 Oleander Ave', 'Springfield', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Daniel', 'Baker', 'M', '1993-02-18', '+44 20 7946 0101', 'daniel.baker21@yahoo.com', '2121 Palm Dr', 'Charlotte', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Nora', 'Butler', 'F', '1993-07-25', '+229 90 11 01 14', 'nora.butler74@gmail.com', '7474 Mesquite Ave', 'Greensboro', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Luke', 'Bailey', 'M', '1997-12-23', '+234 801 234 5603', 'luke.bailey43@gmail.com', '4343 Palm Ct', 'Anaheim', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Aria', 'Morris', 'F', '1994-09-09', '+44 20 7946 0116', 'aria.morris36@yahoo.com', '3636 Linden Ave', 'Oklahoma City', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Chloe', 'Evans', 'F', '1997-10-05', '+44 20 7946 0112', 'chloe.evans32@hotmail.com', '3232 Ironwood St', 'Milwaukee', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Christopher', 'Ross', 'M', '1983-10-27', '+229 90 11 01 03', 'christopher.ross63@gmail.com', '6363 Cedar Ct', 'Akron', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Nathan', 'Hughes', 'M', '1990-05-03', '+229 90 11 01 11', 'nathan.hughes71@gmail.com', '7171 Magnolia Blvd', 'Honolulu', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ellie', 'Diaz', 'F', '1997-01-28', '+33 6 12 34 56 02', 'ellie.diaz82@gmail.com', '8282 Quaker Ct', 'Des Moines', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Audrey', 'Torres', 'F', '1991-09-21', '+234 801 234 5610', 'audrey.torres50@gmail.com', '5050 Sage Ct', 'Chandler', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Gabriel', 'Cook', 'M', '1986-08-15', '+44 20 7946 0119', 'gabriel.cook39@gmail.com', '3939 Mimosa Dr', 'Tulsa', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lincoln', 'Kelly', 'M', '1996-02-29', '+234 801 234 5617', 'lincoln.kelly57@outlook.com', '5757 Tulip Dr', 'Fort Wayne', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lydia', 'Nichols', 'F', '1992-09-30', '+33 6 12 34 56 18', 'lydia.nichols98@gmail.com', '9898 Eucalyptus Dr', 'Spokane', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('David', 'Alexander', 'M', '1989-11-14', '+229 90 11 01 19', 'david.alexander79@gmail.com', '7979 Orchid St', 'Madison', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Violet', 'Richard', 'F', '1994-01-27', '+33 6 12 34 56 16', 'violet.richard96@hotmail.com', '9696 Ebony St', 'Tallahassee', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Amelia', 'Young', 'F', '1992-12-13', '+1 202 555 0116', 'amelia.young16@gmail.com', '1616 Juniper Rd', 'Cleveland', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Savannah', 'Jenkins', 'F', '1992-03-17', '+229 90 11 01 06', 'savannah.jenkins66@gmail.com', '6666 Gum Ave', 'Chesapeake', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Zoey', 'Morgan', 'F', '1993-11-02', '+44 20 7946 0120', 'zoey.morgan40@hotmail.com', '4040 Myrtle Ave', 'Hartford', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Victoria', 'Barnes', 'F', '1991-04-07', '+229 90 11 01 02', 'victoria.barnes62@icloud.com', '6262 Birch Ln', 'Lexington', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Naomi', 'Fields', 'F', '1996-07-19', '+33 6 12 34 56 20', 'naomi.fields100@yahoo.com', '10000 Hickory Pl', 'Gilbert', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Charlotte', 'Walker', 'F', '1997-03-21', '+1 202 555 0114', 'charlotte.walker14@gmail.com', '1414 Cottonwood Dr', 'Orlando', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Layla', 'Reed', 'F', '1999-03-27', '+44 20 7946 0118', 'layla.reed38@icloud.com', '3838 Maple Ct', 'Omaha', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Natalie', 'Howard', 'F', '1998-08-29', '+234 801 234 5608', 'natalie.howard48@hotmail.com', '4848 Redwood St', 'Newark', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Isaac', 'Reyes', 'M', '1988-03-16', '+33 6 12 34 56 13', 'isaac.reyes93@gmail.com', '9393 Clover Ct', 'Bridgeport', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ariana', 'Powell', 'F', '1999-09-14', '+229 90 11 01 08', 'ariana.powell68@yahoo.com', '6868 Heather Ct', 'New Haven', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ava', 'Davis', 'F', '1993-05-09', '+1 202 555 0106', 'ava.davis6@gmail.com', '606 Birch Ave', 'Miami', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Adam', 'Simmons', 'M', '1998-10-06', '+229 90 11 01 15', 'adam.simmons75@gmail.com', '7575 Myrtle Blvd', 'Shreveport', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lena', 'Woods', 'F', '1993-05-23', '+33 6 12 34 56 10', 'lena.woods90@gmail.com', '9090 Cactus Dr', 'Birmingham', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Henry', 'King', 'M', '1981-05-29', '+1 202 555 0117', 'henry.king17@outlook.com', '1717 Laurel Ave', 'Minneapolis', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jackson', 'Stewart', 'M', '1996-05-19', '+44 20 7946 0115', 'jackson.stewart35@gmail.com', '3535 Laurel Rd', 'Memphis', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jack', 'Phillips', 'M', '1989-09-03', '+44 20 7946 0109', 'jack.phillips29@yahoo.com', '2929 Ginkgo Blvd', 'Louisville', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jacob', 'Ferguson', 'M', '1999-05-05', '+33 6 12 34 56 17', 'jacob.ferguson97@outlook.com', '9797 Elmwood Ave', 'Mesquite', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Stella', 'Henderson', 'F', '1995-08-20', '+229 90 11 01 04', 'stella.henderson64@hotmail.com', '6464 Dogwood Ave', 'Stockton', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lucas', 'Hall', 'M', '1989-09-02', '+1 202 555 0115', 'lucas.hall15@yahoo.com', '1515 Hickory Ln', 'Nashville', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Eli', 'Gonzales', 'M', '1987-05-18', '+229 90 11 01 17', 'eli.gonzales77@gmail.com', '7777 Oak Ct', 'Grand Rapids', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Leah', 'Sullivan', 'F', '1998-02-05', '+33 6 12 34 56 08', 'leah.sullivan88@hotmail.com', '8888 Bayberry Ave', 'Columbia', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Gabriel', 'Cole', 'M', '1997-08-19', '+33 6 12 34 56 11', 'gabriel.cole91@gmail.com', '9191 Catalpa Ave', 'Grand Prairie', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('George', 'Mccoy', 'M', '1987-12-01', '+33 6 12 34 56 19', 'george.mccoy99@gmail.com', '9999 Fennel Ct', 'Baton Rouge', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Scarlett', 'Sanders', 'F', '1990-07-12', '+234 801 234 5618', 'scarlett.sanders58@gmail.com', '5858 Vine Ave', 'Boise', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Caleb', 'Long', 'M', '1986-12-24', '+229 90 11 01 09', 'caleb.long69@gmail.com', '6969 Koa Dr', 'Bakersfield', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Harper', 'Wright', 'F', '1999-07-07', '+1 202 555 0118', 'harper.wright18@gmail.com', '1818 Magnolia St', 'Tampa', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lillian', 'Richardson', 'F', '1996-06-17', '+234 801 234 5606', 'lillian.richardson46@icloud.com', '4646 Plum Ave', 'Aurora', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Hannah', 'Rivera', 'F', '1990-02-09', '+234 801 234 5604', 'hannah.rivera44@yahoo.com', '4444 Pecan Blvd', 'Toledo', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Dylan', 'Wallace', 'M', '1985-09-26', '+33 6 12 34 56 09', 'dylan.wallace89@outlook.com', '8989 Butternut St', 'Santa Clarita', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Elena', 'Hamilton', 'F', '1996-11-11', '+33 6 12 34 56 06', 'elena.hamilton86@icloud.com', '8686 Amaranth Dr', 'Chattanooga', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Thomas', 'Price', 'M', '1985-08-05', '+234 801 234 5619', 'thomas.price59@gmail.com', '5959 Walnut Ct', 'Virginia Beach', 'Nigeria');
--Insert into Person table(End)

--Create Patient table (insert 85 patients)
CREATE TABLE Patient(
	PatientId INT IDENTITY(1,1) PRIMARY KEY,
	BloodGroup NVARCHAR(10),
	Genotype NVARCHAR(150),
	Allergies NVARCHAR(500),
	EmergencyContact NVARCHAR(150),
	EmergencyPhone NVARCHAR(30),
	PersonId int NOT NULL,
	CONSTRAINT FK_Patient_Person
	Foreign key (PersonId) References Person(PersonId)
);

select * from Patient;

--Insert into Patient table(Start)
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AA', 'Mold', 'David Anderson', '+1 202 555 3496', 1);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AS', 'Sulfa drugs', 'Ada Abubakar', '+44 20 7946 7608', 2);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AS', 'None', 'Peter Miller', '+1 202 555 7971', 3);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'None', 'Samuel Adams', '+1 202 555 2397', 4);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'Dust mites', 'Zainab White', '+234 809 809 6602', 5);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'Dust mites', 'Sarah Brown', '+44 20 7946 5681', 6);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AS', 'Mold', 'Ada Okoro', '+234 805 708 8104', 7);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AC', 'Sulfa drugs', 'Fatima Nwosu', '+44 20 7946 7813', 8);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'None', 'Ngozi Johnson', '+234 804 872 7920', 9);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AA', 'Shellfish', 'Tunde Bello', '+234 803 719 7115', 10);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AC', 'Penicillin', 'Blessing Adams', '+44 20 7946 8468', 11);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AA', 'Pollen, Dust mites', 'Fatima Okoro', '+1 202 555 2384', 12);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'Dust mites', 'Fatima Obi', '+234 803 352 1923', 13);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AA', 'Penicillin, Peanuts', 'Sarah Adams', '+1 202 555 7381', 14);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'None', 'Michael Moore', '+44 20 7946 4349', 15);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'Latex', 'Paul Brown', '+234 805 737 5623', 16);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AS', 'Shellfish', 'Paul Miller', '+234 801 406 4070', 17);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AS', 'Shellfish', 'Ngozi Obi', '+1 202 555 8436', 18);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AA', 'None', 'Samuel Okoro', '+234 805 209 0908', 19);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O+', 'AA', 'Shellfish', 'Joseph Jackson', '+234 806 058 5978', 20);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AA', 'Pollen', 'Chidi Hassan', '+1 202 555 3391', 21);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AA', 'None', 'Grace Jackson', '+234 800 183 6873', 22);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AS', 'None', 'Fatima Abubakar', '+1 202 555 2168', 23);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AA', 'Dust mites', 'Tunde Moore', '+1 202 555 5526', 24);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AA', 'Dust mites', 'Zainab Jackson', '+44 20 7946 4020', 25);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O+', 'AA', 'Mold', 'David Miller', '+234 802 168 2062', 26);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O+', 'AA', 'Penicillin', 'Chidi Miller', '+1 202 555 4488', 27);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'Bee stings', 'Sarah Bello', '+44 20 7946 6850', 28);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AS', 'Pollen, Dust mites', 'Ruth Obi', '+44 20 7946 3926', 29);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AA', 'None', 'David Johnson', '+44 20 7946 5715', 30);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AS', 'Penicillin', 'Ada Hassan', '+234 803 039 3220', 31);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'SC', 'Sulfa drugs', 'Samuel Miller', '+1 202 555 1679', 32);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'Penicillin', 'Michael Obi', '+1 202 555 6078', 33);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'None', 'Zainab Jackson', '+44 20 7946 1380', 34);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AA', 'Mold', 'Victor Adams', '+1 202 555 3789', 35);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AC', 'Pollen', 'David Davis', '+1 202 555 4582', 36);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AA', 'Peanuts', 'Zainab Wilson', '+44 20 7946 4737', 37);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AC', 'Penicillin', 'Michael Johnson', '+234 806 729 0143', 38);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'None', 'Emeka Taylor', '+44 20 7946 1163', 39);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'None', 'Joseph Nwosu', '+1 202 555 9027', 40);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AA', 'None', 'Fatima Hassan', '+44 20 7946 7621', 41);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'Pollen, Dust mites', 'Halima Thomas', '+1 202 555 3378', 42);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AS', 'Penicillin', 'John Miller', '+44 20 7946 0324', 43);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AA', 'None', 'Esther Thomas', '+234 806 297 5460', 44);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AA', 'Shellfish', 'Ibrahim Hassan', '+44 20 7946 0479', 45);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'Eggs', 'David Nwosu', '+234 801 519 8851', 46);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AS', 'None', 'Joseph Taylor', '+234 808 515 8703', 47);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AA', 'None', 'Ngozi Williams', '+1 202 555 0701', 48);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AS', 'Aspirin', 'Samuel Johnson', '+1 202 555 1538', 49);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AS', 'Penicillin', 'Fatima Taylor', '+1 202 555 6048', 50);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AA', 'Mold', 'Mary Miller', '+1 202 555 3978', 51);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AS', 'None', 'Sarah Bello', '+234 808 623 9749', 52);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AA', 'None', 'Emeka Taylor', '+1 202 555 3445', 53);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'Aspirin', 'Samuel Taylor', '+234 803 928 0981', 54);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AA', 'Aspirin', 'Grace Nwosu', '+1 202 555 7513', 55);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AS', 'None', 'Victor Anderson', '+1 202 555 2189', 56);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AA', 'Pollen, Dust mites', 'Esther Anderson', '+44 20 7946 4724', 57);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AC', 'None', 'Victor Taylor', '+234 807 817 6756', 58);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'None', 'Fatima Hassan', '+44 20 7946 0451', 59);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AA', 'None', 'Michael Bello', '+1 202 555 5697', 60);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A-', 'AA', 'Shellfish', 'Ngozi Davis', '+234 807 320 6364', 61);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AS', 'Peanuts', 'Ngozi Taylor', '+234 806 324 0139', 62);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'SC', 'Bee stings', 'Ruth Wilson', '+234 800 439 2714', 63);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AA', 'Bee stings', 'Paul Nwosu', '+44 20 7946 3018', 64);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'None', 'Mary Hassan', '+1 202 555 9018', 65);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('A+', 'AS', 'None', 'Paul Anderson', '+1 202 555 3016', 66);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AS', 'Bee stings', 'Michael Moore', '+1 202 555 8807', 67);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O+', 'SS', 'Peanuts', 'Peter Bello', '+234 804 133 9037', 68);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'Pollen', 'Chidi Johnson', '+44 20 7946 5419', 69);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AS', 'Eggs', 'Chidi Davis', '+44 20 7946 4573', 70);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'Pollen, Dust mites', 'Ibrahim Thomas', '+1 202 555 0329', 71);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O+', 'AS', 'Pollen', 'Michael Abubakar', '+234 807 487 1016', 72);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'None', 'Victor Moore', '+234 802 372 0157', 73);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'None', 'Halima Thomas', '+1 202 555 3458', 74);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'AA', 'Bee stings', 'Tunde Obi', '+234 806 794 8708', 75);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AA', 'None', 'John White', '+1 202 555 7533', 76);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB-', 'AS', 'Peanuts', 'Halima Davis', '+44 20 7946 7589', 77);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B+', 'SC', 'Latex', 'Ada Hassan', '+234 808 438 9216', 78);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O+', 'AA', 'Pollen, Dust mites', 'Zainab Bello', '+1 202 555 9776', 79);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('O-', 'AS', 'None', 'Grace Johnson', '+44 20 7946 2496', 80);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AA', 'None', 'Blessing Okoro', '+44 20 7946 4245', 81);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AS', 'Shellfish', 'Joseph Williams', '+234 805 112 4552', 82);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AA', 'Pollen, Dust mites', 'Blessing Adams', '+1 202 555 9255', 83);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('AB+', 'AS', 'Shellfish', 'Esther Adeyemi', '+44 20 7946 2884', 84);
INSERT INTO Patient (BloodGroup, Genotype, Allergies, EmergencyContact, EmergencyPhone, PersonId) 
VALUES ('B-', 'AA', 'Dust mites', 'Joseph Jackson', '+44 20 7946 0225', 85);
--Insert into Patient table(end)
select * from Patient;

--Create Departments table(insert 20 departments
create table Department(
	DepartmentId int identity(1,1) primary key,
	Name nvarchar(100) not null,
	Description nvarchar(500),
	Location nvarchar(200)
);

INSERT INTO Department (Name, Description, Location) VALUES (N'Pharmacy', N'Dispenses medications, provides clinical pharmacy services, and manages hospital drug inventories.', N'Ground Floor, Block A');
INSERT INTO Department (Name, Description, Location) VALUES (N'Cardiology', N'Diagnoses and treats heart conditions, including cardiac catheterization and stress testing.', N'3rd Floor, Wing B');
INSERT INTO Department (Name, Description, Location) VALUES (N'Pediatrics', N'Provides medical care for infants, children, and adolescents.', N'1st Floor, Block C');
INSERT INTO Department (Name, Description, Location) VALUES (N'Radiology and imaging', N'Offers X-ray, CT, MRI, ultrasound, and other diagnostic imaging services.', N'Basement Level 1, Block A');
INSERT INTO Department (Name, Description, Location) VALUES (N'Oncology', N'Delivers cancer care including chemotherapy, radiation therapy coordination, and supportive services.', N'4th Floor, Wing D');
INSERT INTO Department (Name, Description, Location) VALUES (N'Laboratory services', N'Performs clinical tests on blood, tissue, and other specimens to support diagnosis and treatment.', N'Ground Floor, Block B');
INSERT INTO Department (Name, Description, Location) VALUES (N'Neonatal intensive care unit (NICU)', N'Specialized intensive care for premature and critically ill newborns.', N'2nd Floor, Wing B');
INSERT INTO Department (Name, Description, Location) VALUES (N'Behavioral health and psychiatry', N'Provides mental health assessment, crisis intervention, and inpatient/outpatient psychiatric care.', N'5th Floor, Block E');
INSERT INTO Department (Name, Description, Location) VALUES (N'Emergency department (ED)', N'24/7 acute care for patients presenting with urgent and life-threatening conditions.', N'Ground Floor, Block A');
INSERT INTO Department (Name, Description, Location) VALUES (N'Rehabilitation services', N'Physical, occupational, and speech therapy to help patients regain function after illness or injury.', N'2nd Floor, Block D');
INSERT INTO Department (Name, Description, Location) VALUES (N'Medical-surgical unit (med-surg)', N'Inpatient care for adult patients recovering from surgery or managing acute medical conditions.', N'3rd Floor, Block C');
INSERT INTO Department (Name, Description, Location) VALUES (N'Hospital administration and support services', N'Oversees hospital operations, human resources, finance, and support functions.', N'Administrative Wing, 1st Floor');
INSERT INTO Department (Name, Description, Location) VALUES (N'Operating room (OR) and perioperative services', N'Surgical suites and pre/post-operative care for elective and emergency procedures.', N'2nd Floor, Block B');
INSERT INTO Department (Name, Description, Location) VALUES (N'Case management and social services', N'Coordinates patient discharge planning, insurance authorizations, and community resources.', N'1st Floor, Block B');
INSERT INTO Department (Name, Description, Location) VALUES (N'Labor and delivery (L&D)', N'Care for mothers during labor, childbirth, and immediate postpartum recovery.', N'2nd Floor, Wing A');
INSERT INTO Department (Name, Description, Location) VALUES (N'Intensive care unit (ICU)', N'Critical care for patients with severe, life-threatening illnesses and injuries.', N'4th Floor, Wing A');
INSERT INTO Department (Name, Description, Location) VALUES (N'Telemetry and progressive care unit (PCU)', N'Intermediate care with continuous cardiac monitoring for step-down patients.', N'3rd Floor, Wing A');
INSERT INTO Department (Name, Description, Location) VALUES (N'Anesthesiology', N'Administers anesthesia and monitors patient safety before, during, and after surgical procedures.', N'2nd Floor, Block B');
INSERT INTO Department (Name, Description, Location) VALUES (N'Nutrition and dietary services', N'Plans and provides therapeutic meals and nutrition counseling for patients.', N'Ground Floor, Block D');
INSERT INTO Department (Name, Description, Location) VALUES (N'Health information management', N'Manages patient medical records, coding, and health data privacy compliance.', N'Administrative Wing, 2nd Floor');

select * from Department;
--Create Staff table(insert 15 staff)
Create Table Staff
(
	StaffId int identity(1,1) Primary key,
	EmploymentDate Date,
	Salary Decimal (18,2),
	DepartmentID int,
	PersonId int not null,
	Constraint FK_Staff_Persons
		Foreign key (StaffId) references Person(PersonId),
	Constraint FK_Staff_Departments
		Foreign key (DepartmentId) references Department(DepartmentId)
);

select * from Staff;

INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2012-12-21', 899008.78, 5, 86);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2008-12-25', 222252.56, 6, 87);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2016-06-15', 575432.31, 8, 88);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2010-07-12', 518038.13, 5, 89);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2015-06-28', 771402.35, 5, 90);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2026-02-20', 718830.68, 5, 91);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2022-10-06', 231658.25, 7, 92);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2011-11-18', 253489.51, 1, 93);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2020-07-03', 282241.88, 3, 94);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2021-06-18', 712501.70, 1, 95);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2012-11-21', 730625.08, 6, 96);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2022-12-28', 429758.11, 5, 97);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2025-04-05', 618609.75, 7, 98);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2020-04-12', 758533.29, 7, 99);
INSERT INTO Staff (EmploymentDate, Salary, DepartmentId, PersonId) 
VALUES ('2013-12-09', 421445.90, 8, 100);

--DOCTOR TABLE

create table Doctor(
	DoctorId int identity(1,1) primary key,
	Specialization nvarchar(150) not null,
	LicenseNumber nvarchar(100) not null unique,
	StaffId int,

	CONSTRAINT FK_Doctor_Staff
		FOREIGN KEY (StaffId)
		references Staff(StaffId)
);
drop table Doctor


--NURSE TABLE
create table Nurse(
	NurseId int identity(1,1) primary key,
	NursingLicense nvarchar(100) not null unique,
	Qualification nvarchar(100),
	StaffId int,

	CONSTRAINT FK_Nurse_Staff
		FOREIGN KEY (StaffId)
		REFERENCES Staff(StaffId)
);

--APPOINTMENT TABLE
CREATE TABLE Appointment
(
    AppointmentId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    AppointmentDate DATETIME2 NOT NULL,
    Reason NVARCHAR(500),
    Status NVARCHAR(50),
    Notes NVARCHAR(1000),

    CONSTRAINT FK_Appointment_Patient
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT FK_Appointment_Doctor
        FOREIGN KEY (DoctorId)
        REFERENCES Doctor(DoctorId)
);

select * from Appointment

CREATE TABLE Diagnose
(
    DiagnosisId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    DiagnosisDate DATE NOT NULL,
    Condition NVARCHAR(200) NOT NULL,
    Description NVARCHAR(1000),
    Notes NVARCHAR(1000),

    CONSTRAINT FK_Diagnose_Patient
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT FK_Diagnose_Doctor
        FOREIGN KEY (DoctorId)
        REFERENCES Doctor(DoctorId)
);


CREATE TABLE Treatment
(
    TreatmentId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    DiagnosisId INT,
    TreatmentDate DATE NOT NULL,
    TreatmentName NVARCHAR(200) NOT NULL,
    Description NVARCHAR(1000),
    Notes NVARCHAR(1000),
    Status NVARCHAR(50),

    CONSTRAINT FK_Treatment_Patient
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT FK_Treatments_Doctors
        FOREIGN KEY (DoctorId)
        REFERENCES Doctor(DoctorId),

    CONSTRAINT FK_Treatments_Diagnoses
        FOREIGN KEY (DiagnosisId)
        REFERENCES Diagnose(DiagnosisId)
);

CREATE TABLE LaboratoryTest
(
    LaboratoryTestId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    LaboratoryTechnicianId INT NOT NULL,
    TestName NVARCHAR(200) NOT NULL,
    TestDate DATETIME2 NOT NULL,
    Result NVARCHAR(2000),
    ReferenceRange NVARCHAR(500),
    Status NVARCHAR(50),

    CONSTRAINT FK_LaboratoryTest_Patient
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT FK_LaboratoryTest_Technician
        FOREIGN KEY (LaboratoryTechnicianId)
        REFERENCES LaboratoryTechnician(LaboratoryTechnicianId)
);


CREATE TABLE Medication
(
    MedicationId INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(200) NOT NULL,
    Description NVARCHAR(1000),
    DosageForm NVARCHAR(100),
    Price DECIMAL(18,2) NOT NULL,
    QuantityInStock INT NOT NULL DEFAULT 0,

    CONSTRAINT CK_Medication_Price
        CHECK (Price >= 0),

    CONSTRAINT CK_Medication_Stock
        CHECK (QuantityInStock >= 0)
);


CREATE TABLE Prescription
(
    PrescriptionId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    DoctorId INT NOT NULL,
    PrescriptionDate DATE NOT NULL,

    CONSTRAINT FK_Prescription_Patient
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT FK_Prescription_Doctor
        FOREIGN KEY (DoctorId)
        REFERENCES Doctor(DoctorId)
);


CREATE TABLE PrescriptionItem
(
    PrescriptionItemId INT IDENTITY(1,1) PRIMARY KEY,
    PrescriptionId INT NOT NULL,
    MedicationId INT NOT NULL,
    Dosage NVARCHAR(100),
    Frequency NVARCHAR(100),
    Duration INT,
    DurationUnit NVARCHAR(50),
    Instructions NVARCHAR(1000),

    CONSTRAINT FK_PrescriptionItem_Prescription
        FOREIGN KEY (PrescriptionId)
        REFERENCES Prescription(PrescriptionId),

    CONSTRAINT FK_PrescriptionItem_Medication
        FOREIGN KEY (MedicationId)
        REFERENCES Medication(MedicationId),

    CONSTRAINT CK_PrescriptionItems_Duration
        CHECK (Duration IS NULL OR Duration > 0)
);


CREATE TABLE MedicationDispensing
(
    MedicationDispensingId INT IDENTITY(1,1) PRIMARY KEY,
    PrescriptionId INT NOT NULL,
    PrescriptionItemId INT NOT NULL,
    PharmacistId INT NOT NULL,
    PatientId INT NOT NULL,
    DispensingDate DATETIME2 NOT NULL,
    Quantity INT NOT NULL,
    Status NVARCHAR(50),
    Notes NVARCHAR(1000),

    CONSTRAINT FK_Dispensings_Prescriptions
        FOREIGN KEY (PrescriptionId)
        REFERENCES Prescription(PrescriptionId),

    CONSTRAINT FK_Dispensings_PrescriptionItems
        FOREIGN KEY (PrescriptionItemId)
        REFERENCES PrescriptionItem(PrescriptionItemId),

    CONSTRAINT FK_Dispensings_Pharmacists
        FOREIGN KEY (PharmacistId)
        REFERENCES Pharmacist(PharmacistId),

    CONSTRAINT FK_Dispensings_Patients
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT CK_Dispensings_Quantity
        CHECK (Quantity > 0)
);


CREATE TABLE NurseAssignment
(
    NurseAssignmentId INT IDENTITY(1,1) PRIMARY KEY,
    NurseId INT NOT NULL,
    PatientId INT NOT NULL,
    AdmissionId INT,
    AssignmentDate DATETIME2 NOT NULL,
    EndDate DATETIME2,
    Shift NVARCHAR(50),
    Status NVARCHAR(50),
    Notes NVARCHAR(1000),

    CONSTRAINT FK_NurseAssignments_Nurses
        FOREIGN KEY (NurseId)
        REFERENCES Nurse(NurseId),

    CONSTRAINT FK_NurseAssignments_Patients
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT FK_NurseAssignments_Admissions
        FOREIGN KEY (AdmissionId)
        REFERENCES Admission(AdmissionId),

    CONSTRAINT CK_NurseAssignments_Dates
        CHECK (
            EndDate IS NULL
            OR EndDate >= AssignmentDate
        )
);


CREATE TABLE MedicalRecord
(
    MedicalRecordId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL UNIQUE,
    CreatedDate DATE NOT NULL,

    CONSTRAINT FK_MedicalRecords_Patients
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId)
);






CREATE TABLE Invoice
(
    InvoiceId INT IDENTITY(1,1) PRIMARY KEY,
    PatientId INT NOT NULL,
    InvoiceDate DATE NOT NULL,
    TotalAmount DECIMAL(18,2) NOT NULL DEFAULT 0,
    Status NVARCHAR(50),

    CONSTRAINT FK_Invoices_Patients
        FOREIGN KEY (PatientId)
        REFERENCES Patient(PatientId),

    CONSTRAINT CK_Invoices_TotalAmount
        CHECK (TotalAmount >= 0)
);


CREATE TABLE InvoiceItem
(
    InvoiceItemId INT IDENTITY(1,1) PRIMARY KEY,
    InvoiceId INT NOT NULL,
    Description NVARCHAR(500) NOT NULL,
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(18,2) NOT NULL,
    Amount AS (Quantity * UnitPrice) PERSISTED,

    CONSTRAINT FK_InvoiceItems_Invoices
        FOREIGN KEY (InvoiceId)
        REFERENCES Invoice(InvoiceId),

    CONSTRAINT CK_InvoiceItems_Quantity
        CHECK (Quantity > 0),

    CONSTRAINT CK_InvoiceItems_UnitPrice
        CHECK (UnitPrice >= 0)
);




CREATE TABLE Payment
(
    PaymentId INT IDENTITY(1,1) PRIMARY KEY,
    InvoiceId INT NOT NULL,
    Amount DECIMAL(18,2) NOT NULL,
    PaymentDate DATE NOT NULL,
    PaymentMethod NVARCHAR(50),

    CONSTRAINT FK_Payments_Invoices
        FOREIGN KEY (InvoiceId)
        REFERENCES Invoice(InvoiceId),

    CONSTRAINT CK_Payments_Amount
        CHECK (Amount > 0)
);



CREATE TABLE Users
(
    UserId INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(100) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(500) NOT NULL,
    Role NVARCHAR(50) NOT NULL,
    StaffId INT,
    IsActive BIT NOT NULL DEFAULT 1,

    CONSTRAINT FK_Users_Staff
        FOREIGN KEY (StaffId)
        REFERENCES Staff(StaffId),

    CONSTRAINT CK_Users_Role
        CHECK (
            Role IN
            (
                'STAFF',
                'DOCTOR',
                'NURSE',
                'PHARMACIST',
                'LABORATORY_TECHNICIAN'
            )
        )
);



create login mainhospital with password = '12345';
create user mainhospital for login mainhospital;



GRANT INSERT, DELETE, UPDATE ON Patient TO mainhospital;

ALTER ROLE db_datareader
ADD MEMBER mainhospital;

ALTER ROLE db_datawriter
ADD MEMBER mainhospital;

