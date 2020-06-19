
CREATE TABLE item (
    id NUMBER,
    name VARCHAR2(50) NOT NULL,
    quantity NUMBER NOT NULL,
    price NUMBER NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO item VALUES (1, 'longsword', 5, 150);
INSERT INTO item VALUES (2, 'axe', 7, 70);
INSERT INTO item VALUES (3, 'shield', 2, 50);
INSERT INTO item VALUES (4, 'dagger', 10,45);
