# CS623 - From ER Design To Implementation - Paper Review Database - JAVA Application

## Application Preview
The Application connects to database and provides methods to perfrom CRUD operation against the Database.
The database contains five tables:
```
author
paper
review - referential integrity constraint
reviewer - referential integrity constraint
topic - referential integrity constraint
```

## Application Design
The application is built based on the MVC design pattern: Model View and Control

![alt text](https://raw.githubusercontent.com/scottsun17/CS623ConferenceReview/master/img/tree.PNG)


## Mehods Overview
**Question 1: Get paper and author details by author ID**

This method involve two tables: author and paper.

User can get all paper submitted by the same author. We set up paper table to contain a foreign key that refers to author table(emailAddr)

The method returns all tuples contains that authorId in the relation, as well as call for 'getAuthorbyId' method to get author information from author table

**Question 2: get reviews for a paper by paperId**

This method involve one table: review

review table has a foreign key PaperID. We use this key to retrieve all tuples

![alt text](https://raw.githubusercontent.com/scottsun17/CS623ConferenceReview/master/img/page.PNG)

**Question 3: get count of all paper submitted**

The method `countAllPaper` calls for method `findAllPaper` and get a list of all paper in the database. Then it uses method list.size to count all paper in the ArrayList.

**Question 4: Submit a new Paper**
This method allows user to submit a new paper. What happens here is that the new paper submitted may come from a new author too. Thus the method call for a test of `authorId` submitted by the user. If the `authorId` is not found. The method calls for another method, `addAuthor`, to add the new author to the database first.

![alt text](https://raw.githubusercontent.com/scottsun17/CS623ConferenceReview/master/img/cmd2.PNG)

**Question 5: Delete the first author in the table**
This question call for the consideration of referential integrity constraint. author table attribute `emailAddr` is referenced as a foreign key in paper relation. Thus if an author that is referenced by paper table, the delete operation will faill and return the following message:

```
java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails (`paperreview`.`paper`, CONSTRAINT `paper_ibfk_1` FOREIGN KEY (`authorId`) REFERENCES `author` (`emailAddr`))
```

Our method is executed twice here to perform the two situation:

1. Author `emailAddr` is not referenced in other table. The delete operation is completed
2. Author `emailAddr` is referenced in paper table as `authorId`. SQLIntegrityConstraintViolationException is trigered and return error message.

![alt text](https://github.com/scottsun17/CS623ConferenceReview/blob/master/img/cmd3.PNG)

## How to run the application
1. download the sql script
2. download the java source code
3. build the database in according to the sql script
4. import the java source code to your choice of IDE, run the code
