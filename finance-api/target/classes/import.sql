INSERT INTO CATEGORY (ID, DESCRIPTION) VALUES (1000, 'Serviço');
INSERT INTO CATEGORY (ID, DESCRIPTION) VALUES (1001, 'Mercado');
INSERT INTO CATEGORY (ID, DESCRIPTION) VALUES (1002, 'Lazer');

INSERT INTO KITTY (ID, NAME, DESCRIPTION, GOAL, FK_CATEGORY, QUANTITY_AVAILABLE) VALUES (1000, 'Mercado do mês', 'Vaquinha referente a alimentação do mês no mrcado', 689, 1000,3);
INSERT INTO KITTY (ID, NAME, DESCRIPTION, GOAL, FK_CATEGORY, QUANTITY_AVAILABLE) VALUES (1001, 'Moto', 'Vaquinha referente a compra de uma moto', 2123, 1000, 3);

INSERT INTO SPENT (ID, NAME, VALUE, FK_CATEGORY, CREATED_AT) VALUES (1001, 'Alimentação', 32, 1000, CURRENT_TIMESTAMP);
INSERT INTO SPENT (ID, NAME, VALUE, FK_CATEGORY, CREATED_AT) VALUES (1002, 'Cinema', 65, 1001, CURRENT_TIMESTAMP);
INSERT INTO SPENT (ID, NAME, VALUE, FK_CATEGORY, CREATED_AT) VALUES (1003, 'Roupa', 243, 1001, CURRENT_TIMESTAMP);