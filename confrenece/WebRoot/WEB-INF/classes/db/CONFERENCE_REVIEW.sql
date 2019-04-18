
#Creating Database CONFERENCE_REVIEW
CREATE DATABASE CONFERENCE_REVIEW ;
USE CONFERENCE_REVIEW;

#Creating Author Table with EmailAddr as PK
CREATE TABLE Author (
	EmailAddr VARCHAR(255) PRIMARY KEY,
	FirstName VARCHAR(255) NOT NULL,
	LastName VARCHAR(255) NOT NULL
);

#Creating Paper with id as PK
CREATE TABLE Paper (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	Title VARCHAR(255) NOT NULL,
	Absrract TEXT,
	FileName VARCHAR(255) NOT NULL
);

#Creating Reviewer Table with EmailAddr as PK
CREATE TABLE Reviewer (
	EmailAddr VARCHAR(255) PRIMARY KEY,
	FirstName VARCHAR(255) NOT NULL,
	LastName VARCHAR(255) NOT NULL,
	AuthorFeedBack TEXT,
	CommiteeFeedBack TEXT,
	PhoneNum VARCHAR(13) NOT NULL,
	Affiliation VARCHAR(255) NOT NULL
);

#Creating Topic Table with id as PK
CREATE TABLE Topic (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	TopicName VARCHAR(255) NOT NULL
);

#Creating weak entity Review Table with id as PK
CREATE TABLE Review (
	Id INT PRIMARY KEY AUTO_INCREMENT,
	Recommendation TEXT,
	MeritScore TINYINT NOT NULL,
	ReadabilityScore TINYINT NOT NULL,
	RelevanceScore TINYINT NOT NULL,	
	OriginalityScore TINYINT NOT NULL,
	PaperId INT NOT NULL,
	ReviewerId VARCHAR(255) NOT NULL,
	FOREIGN KEY (PaperId) REFERENCES Paper (Id),
	FOREIGN KEY (ReviewerId) REFERENCES Reviewer (EmailAddr)
);

#Create Submit Relation between Author and Paper tables
CREATE TABLE Author_Submit_Paper(
	AuthorId VARCHAR(255) NOT Null,
	PaperId INT NOT Null,
	FOREIGN KEY (AuthorId) REFERENCES Author (EmailAddr),
	FOREIGN KEY (PaperId) REFERENCES Paper (Id),
	UNIQUE(PaperId),
	UNIQUE(AuthorId)
);

#Create Submit Relation between Paper and Reviewer
CREATE TABLE Paper_Assigned_Reviewer(
	ReviewerId VARCHAR(255) NOT Null,
	PaperId INT NOT Null,
	FOREIGN KEY (ReviewerId) REFERENCES Reviewer (EmailAddr),
	FOREIGN KEY (PaperId) REFERENCES Paper (Id)
);

#Create Has Relation between Reviewer and Topic
CREATE TABLE Reviewer_Has_Topic(
	ReviewerId VARCHAR(255) NOT Null,
	TopicId INT NOT Null,
	FOREIGN KEY (ReviewerId) REFERENCES Reviewer (EmailAddr),
	FOREIGN KEY (TopicId) REFERENCES Topic (Id),
	UNIQUE(TopicId)
);

#Create Submit Relation between Reviewer and Review
CREATE TABLE Reviewer_Submit_Review(
	ReviewerId VARCHAR(255) NOT Null,
	ReviewId INT NOT Null,
	FOREIGN KEY (ReviewerId) REFERENCES Reviewer (EmailAddr),
	FOREIGN KEY (ReviewId) REFERENCES Review (Id),
	UNIQUE(ReviewId)
);