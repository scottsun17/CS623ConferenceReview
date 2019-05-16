package cs623.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs623.Dao.Implementation.Implementation;
import cs623.entity.Author;
import cs623.entity.Paper;

public class PaperReviewDriver {
	public static void main(String[] args) throws InterruptedException {
		Implementation imp = new Implementation();
		Scanner sc = new Scanner(System.in);
		
		//Questoin 1
		System.out.println("Question 1: Find Paper and Author Information by Author ID - tchifney1@buzzfeed.com");
		Thread.sleep(800);
		imp.findPaperByAuthor("tchifney1@buzzfeed.com");
		
		//Question 2
		System.out.println("Question 2: Find all reviews by Paper ID - PaperID: 2");
		Thread.sleep(800);
		imp.findReviewByPaperID(2);
		
		//Question 3
		System.out.println("\nQuestion 3: Total Number of Paper Submitted to the Database");
		Thread.sleep(800);
		imp.countAllPaper();
		
		/*
		 * Question 4 - new paper submission
		 * 
		 * New paper submission requires authorID and ReviewerID, bother are foreign keys reference to Author and Reviewer
		 * Tables. Before we adding the paper, we need to check if the author of the new paper is already in the database 
		 * system.
		 * If author find, we finish adding paper
		 * If author not found, we add a new author to the author table
		 * 
		 * Reviewer is assigned to the new paper. we can assign anyone. Here we assign rderuggiero25@sun.com for easy demo
		 */
		System.out.println("\n\nQuestion 4: Create a new paper submission");
		Thread.sleep(800);
		Paper p = new Paper();
		System.out.println("Please input the Title of the Paper");
		p.setTitle(sc.nextLine());
		
		System.out.println("Please input the abstract of the Paper");
		p.setAbsrract(sc.nextLine());
		
		System.out.println("Please input the name of File");
		p.setFileName(sc.nextLine());
		
		System.out.println("Please input the name of the Author ID (Email Address)");
		p.setAuthorId(sc.nextLine());
		
		//Checking if we already have the autho in our database
		if(imp.findAuthorById(p.getAuthorId()) == null) {
			System.out.println("Author not found, you must add the New Author first");
			Author a = new Author();
			System.out.println("Please input Author's First Name");
			a.setFirstName(sc.nextLine());

			System.out.println("Please input Author's Last Name");
			a.setLastName(sc.nextLine());
			
			a.setEmailAddr(p.getAuthorId());
			imp.addAuthor(a);
		}
		//Assigning reviewer to the paper
		System.out.println("Reviewer rderuggiero25@sun.com has been assigned to your paper");
		p.setReviewerId("rderuggiero25@sun.com");

		imp.addPaper(p);

		/*
		 * Question 5 Deleting an author from the table.
		 * 
		 * Since there are foreign keys reference to author table, we cannot just simple delete the author
		 * Here we show two example:
		 * 	1. an author without any foreign key references to 
		 *  2. an author that is referenced in another table
		 *  
		 * If there is not foreign table reference to a particular author, we delete successfully
		 * If there is foreign table reference to the author, we see exception handling msg 
		 * 				SQLIntegrityConstraintViolationException 
		 */
		System.out.println("\n\nQuestion 5: Delete the first author in the Database by Author ID");
		List<Author> list = new ArrayList<Author>();
		list = imp.findAllAuthor();
		System.out.println("The first author in the database is below: \n" 
					+ "Author Name: \t" + list.get(0).getFirstName() + " " + list.get(0).getLastName()
					+ "Author Email Address: \t" + list.get(0).getEmailAddr() + "\n"
					+ "Processing to Delete....");
		System.out.print("Deleting");
		for (int i = 0; i < 3; i++) {
			Thread.sleep(800);
			System.out.print(".");
		}
		imp.deleteAuthorById(list.get(0).getEmailAddr());
		
		System.out.println("\n\nLet try again, delete another author that are referenced from another table");
		list = imp.findAllAuthor();
		System.out.println("The first author in the database is below: \n" 
					+ "Author Name: \t" + list.get(0).getFirstName() + " " + list.get(0).getLastName()
					+ "Author Email Address: \t" + list.get(0).getEmailAddr() + "\n"
					+ "Processing to Delete....");
		System.out.print("Deleting");
		for (int i = 0; i < 3; i++) {
			Thread.sleep(800);
			System.out.print(".");
		}
		imp.deleteAuthorById(list.get(0).getEmailAddr());
		sc.close();
	}
}
