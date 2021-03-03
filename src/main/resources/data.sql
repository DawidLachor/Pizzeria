insert into cake(name, price) values ('cienkie', 5.30), ('standard', 3.50), ('grube', 7.00);
insert into topping(name, price) values ('ser', 2.50), ('pepperoni', 3.50), ('pieczarki', 2.00), ('szynka', 3.00);
insert into size(name, multiplier) values ('25 cm', 1), ('35 cm', 1.5), ('50 cm', 2);
insert into sauce(name, price) values ('pomidorowy łagodny', 5), ('czosnkowy', 3.50), ('pomidorowy ostry', 5.20);
insert into pizza(name, description, standard, cake_id, size_id) values ('Pyszna domowa pizza', 'Przepis na łatwe do wyrobienia, miękkie i elastyczne ciasto na pizzę.' ||
                                                                                                'Prosty sposób przygotowania - pizzę pieczemy w blaszkach / tortownicach. '
                                                                                                , true, 2, 3),
                                                                        ('Kwestia Smaku', 'Ciasto na pizzę jest bardzo proste do przygotowania i składa się z ' ||
                                                                                          'mąki, wody, drożdży, cukru, soli oraz oliwy. '
                                                                                          , true, 1, 2);
insert into connection_from_pizza(dual, pizza_id, topping_id) values (true, 1, 1), (true, 1, 3), (true, 1, 4), (true, 2, 1), (true, 2, 2), (true, 2, 3);
insert into pizza_sauce(pizza_id, sauce_id) values (1, 3), (2, 1), (2, 2);