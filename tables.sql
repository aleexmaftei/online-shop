--DROP TABLE alcoholProducts;
--DROP TABLE gamingConsoleProducts;
--DROP TABLE nonAlcoholProducts;
--DROP TABLE productLabel;

CREATE TABLE productLabel (
	price DOUBLE(5, 3) NOT NULL,
	name VARCHAR(255) NOT NULL,
    originCountry VARCHAR(255) NOT NULL,
	ingredients VARCHAR(255) DEFAULT NULL,
    productType VARCHAR(255) NOT NULL,
	uniqueID VARCHAR(255) NOT NULL,
	PRIMARY KEY (uniqueID)
);

CREATE TABLE alcoholProducts (
    alcoholPercentage INT(4) NOT NULL,
    alcoholType VARCHAR(255) NOT NULL,
    uniqueID VARCHAR(255) NOT NULL,
    FOREIGN KEY (uniqueID) REFERENCES productLabel(uniqueID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE gamingConsoleProducts (
    productionYear VARCHAR(255) NOT NULL,
    consoleName VARCHAR(255) NOT NULL,
    uniqueID VARCHAR(255) NOT NULL,
    FOREIGN KEY (uniqueID) REFERENCES productLabel(uniqueID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE nonAlcoholProducts (
    type VARCHAR(255) NOT NULL,
    uniqueID VARCHAR(255) NOT NULL,
    FOREIGN KEY (uniqueID) REFERENCES productLabel(uniqueID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);