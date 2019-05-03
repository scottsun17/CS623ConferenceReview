#Creating Database CONFERENCE_REVIEW
CREATE DATABASE CONFERENCE_REVIEW ;
USE CONFERENCE_REVIEW;

#Creating Author Table with emailAddr as PK
CREATE TABLE Author (
	emailAddr VARCHAR(255) PRIMARY KEY,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL
);

#Creating Paper with id as PK
CREATE TABLE Paper (
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	absrract TEXT,
	fileName VARCHAR(255) NOT NULL
);

#Creating Reviewer Table with emailAddr as PK
CREATE TABLE Reviewer (
	emailAddr VARCHAR(255) PRIMARY KEY,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	authorFeedBack TEXT,
	commiteeFeedBack TEXT,
	phoneNum VARCHAR(13) NOT NULL,
	affiliation VARCHAR(255) NOT NULL
);

#Creating Topic Table with id as PK
CREATE TABLE Topic (
	id INT PRIMARY KEY AUTO_INCREMENT,
	topicName VARCHAR(255) NOT NULL
);

#Creating weak entity Review Table with id as PK
CREATE TABLE Review (
	id INT PRIMARY KEY AUTO_INCREMENT,
	recommendation TEXT,
	meritScore TINYINT NOT NULL,
	readabilityScore TINYINT NOT NULL,
	relevanceScore TINYINT NOT NULL,
	originalityScore TINYINT NOT NULL,
	paperid INT NOT NULL,
	reviewerid VARCHAR(255) NOT NULL,
	FOREIGN KEY (paperid) REFERENCES Paper (id),
	FOREIGN KEY (reviewerid) REFERENCES Reviewer (emailAddr)
);

#Create Submit Relation between Author and Paper tables
CREATE TABLE Author_Submit_Paper(
	authorid VARCHAR(255) NOT Null,
	paperid INT NOT Null,
	FOREIGN KEY (authorid) REFERENCES Author (emailAddr),
	FOREIGN KEY (paperid) REFERENCES Paper (id),
	UNIQUE(paperid),
	UNIQUE(authorid)
);

#Create Submit Relation between Paper and Reviewer
CREATE TABLE Paper_Assigned_Reviewer(
	reviewerid VARCHAR(255) NOT Null,
	paperid INT NOT Null,
	FOREIGN KEY (reviewerid) REFERENCES Reviewer (emailAddr),
	FOREIGN KEY (paperid) REFERENCES Paper (id)
);

#Create Has Relation between Reviewer and Topic
CREATE TABLE Reviewer_Has_Topic(
	reviewerid VARCHAR(255) NOT Null,
	topicid INT NOT Null,
	FOREIGN KEY (reviewerid) REFERENCES Reviewer (emailAddr),
	FOREIGN KEY (topicid) REFERENCES Topic (id),
	UNIQUE(topicid)
);

#Create Submit Relation between Reviewer and Review
CREATE TABLE Reviewer_Submit_Review(
	reviewerid VARCHAR(255) NOT Null,
	reviewid INT NOT Null,
	FOREIGN KEY (reviewerid) REFERENCES Reviewer (emailAddr),
	FOREIGN KEY (reviewid) REFERENCES Review (id),
	UNIQUE(reviewid)
);
