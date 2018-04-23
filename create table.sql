CREATE TABLE `Customer` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`Name` VARCHAR(255) NOT NULL,
	`Tel` VARCHAR(255) NOT NULL,
	`Address` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Order` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`CustomerID` INT NOT NULL,
	`StageID` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Stages` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`StageStr` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Menu` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`MenuStr` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Material` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`MaterialStr` VARCHAR(255) NOT NULL,
	`UnitPrice` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Food` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Dish` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`MenuID` INT NOT NULL,
	`FoodID` INT NOT NULL,
	`Price` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `contains` (
	`OrderID` BINARY NOT NULL AUTO_INCREMENT,
	`DishID` BINARY NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`OrderID`,`DishID`)
);

CREATE TABLE `needs` (
	`FoodID` BINARY NOT NULL AUTO_INCREMENT,
	`MaterialID` BINARY NOT NULL AUTO_INCREMENT,
	`MaterialAmount` INT NOT NULL,
	PRIMARY KEY (`FoodID`,`MaterialID`)
);

ALTER TABLE `Order` ADD CONSTRAINT `Order_fk0` FOREIGN KEY (`CustomerID`) REFERENCES `Customer`(`ID`);

ALTER TABLE `Order` ADD CONSTRAINT `Order_fk1` FOREIGN KEY (`StageID`) REFERENCES `Stages`(`ID`);

ALTER TABLE `Dish` ADD CONSTRAINT `Dish_fk0` FOREIGN KEY (`MenuID`) REFERENCES `Menu`(`ID`);

ALTER TABLE `Dish` ADD CONSTRAINT `Dish_fk1` FOREIGN KEY (`FoodID`) REFERENCES `Food`(`ID`);

ALTER TABLE `contains` ADD CONSTRAINT `contains_fk0` FOREIGN KEY (`OrderID`) REFERENCES `Order`(`ID`);

ALTER TABLE `contains` ADD CONSTRAINT `contains_fk1` FOREIGN KEY (`DishID`) REFERENCES `Dish`(`ID`);

ALTER TABLE `needs` ADD CONSTRAINT `needs_fk0` FOREIGN KEY (`FoodID`) REFERENCES `Food`(`ID`);

ALTER TABLE `needs` ADD CONSTRAINT `needs_fk1` FOREIGN KEY (`MaterialID`) REFERENCES `Material`(`ID`);