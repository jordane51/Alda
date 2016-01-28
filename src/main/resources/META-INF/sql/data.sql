insert into alda.User(id, email, password, dateInscription) 
values(10, 'hello@toto.com', '2014-03-21', date('2014-03-21'));
insert into alda.Listing(price, surface, location, email, dateCreation, userId)
values('170K', '50m2', 'Bordeaux', 'hello@toto.com', date('2014-03-21'), 10);