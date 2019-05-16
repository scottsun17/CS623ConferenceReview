package cs623.Dao.Implementation;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;




import cs623.entity.Author;
import cs623.entity.Paper;
import cs623.entity.Review;
import cs623.entity.Reviewer;
import cs623.utils.BaseDao;
import cs623.utils.JDBCUtil;

public class Implementation extends BaseDao{

	//1. establish connection to the Database
	Connection conn = JDBCUtil.getConnection();
	
	//2. Instantiate Object array and sql String for database
	Object[] paramsValue =null;
	String sql = null;
	
	/**
	 * Find all paper data
	 * @return a list of Paper objects
	 */
	public List<Paper> findAllPaper() {
		sql = "select * from Paper";
		List<Paper> list = super.query(sql, null, Paper.class);		
		return (list != null && list.size() != 0) ? list : null;
	}
	
	/**
	 * Find all Author data
	 * @return a list of Author objects
	 */
	public List<Author> findAllAuthor(){
		sql = "select * from Author";
		List<Author> list = super.query(sql, null, Author.class);
		return (list != null && list.size() != 0) ? list : null;
	}
	
	/**
	 * Find Author information by author's email Address
	 * @param emailAddr Author's email Address
	 * @return	Author object
	 */
	public Author findAuthorById(String emailAddr){
		sql = "select * from Author where emailAddr = ?";
		paramsValue = new Object[] {emailAddr};
		List<Author> list = super.query(sql, paramsValue, Author.class);
		return (list != null && list.size() != 0) ? list.get(0) : null;
	}
	
	/**
	 * Find a paper by Paper ID
	 * @param id	
	 * @return Paper object
	 */
	public Paper findPaperById(int id){
		sql = "select * from Paper where id = ?";
		paramsValue = new Object[] {id};
		List<Paper> list = super.query(sql, paramsValue, Paper.class);
		return (list != null && list.size() != 0) ? list.get(0) : null;
	}
	
	/**
	 * Print out all paper and information by author's Email Address
	 * @param authorid Author's email address
	 */
	public void findPaperByAuthor(String authorid){
		sql = "select * from paper where authorid = ?";
		paramsValue = new Object[] {authorid};
		List<Paper> list = super.query(sql, paramsValue, Paper.class);
		
		Author author = new Author();
		Paper paper = new Paper();
		author = findAuthorById(authorid);
		
		if(list != null && list.size() != 0) {

			//loop through the list to find all paper published by the author
			for(int i = 0; i < list.size(); i++){
				int id = list.get(i).getId();
				paper = findPaperById(id);
				System.out.println(
						"Paper ID: \t" + paper.getId() + "\n" +
						"Title: \t\t" + paper.getTitle() + "\n" +
						"Abstract: \t" + paper.getAbsrract()  + "\n" +
						"Author Email: \t" + author.getEmailAddr() + "\n" +
						"Author Name: \t" + author.getFirstName() + " " + author.getLastName() + "\n\n");
			}
		} else {
			System.out.println("No Paper found for this Author");
		}
	}
	
	/**
	 * Find a review by review ID
	 * @param id review ID
	 * @return Review Object
	 */
	public Review findReviewById(int id) {
		sql = "select * from Review where id = ?";
		paramsValue = new Object[] {id};
		List<Review> list = super.query(sql, paramsValue, Review.class);
		return (list != null && list.size() != 0) ? list.get(0) : null;
	}
	
	public Reviewer findReviewerById(String emailAddr){
		sql = "select * from reviewer where emailAddr = ?";
		paramsValue = new Object[] {emailAddr};
		List<Reviewer> list = super.query(sql, paramsValue, Reviewer.class);
		return (list != null && list.size() != 0) ? list.get(0) : null;

	}
	
	/**
	 * Find and print review by Associated PaperID
	 * @param paperid
	 */
	public void findReviewByPaperID(int paperid){
		sql = "select * from Review where paperid = ?";
		paramsValue = new Object[] {paperid};
		List<Review> list = super.query(sql, paramsValue, Review.class);
		
		if(list != null && list.size() > 0){
			System.out.println("Review Information for Paper ID " + paperid +":");
			Review r = null;
			for(int i = 0; i < list.size(); i++){
				r = list.get(i);
				System.out.println(
						"Review ID: \t" + r.getId() + "\n" +
						"Reviewer ID: \t" + r.getReviewerId() + "\n" +
						"Merit Score: \t" + r.getMeritScore()  + "\n" +
						"Readability Score: \t" + r.getReadabilityScore() + '\n' +
						"Relevance Score: \t" + r.getRelevanceScore() + "\n" +
						"Originality Score: \t" + r.getOriginalityScore() + "\n" +
						"Recoomendation:\t" + r.getRecommendation() + "\n"
				);
			}
		} else {
			System.out.println("No Review found for Paper ID: " + paperid);
		}
	}
	
	/**
	 * Get a count of all papers in the database
	 */
	public void countAllPaper(){
		List<Paper> list = findAllPaper();
		System.out.println("Total Paper Count: " + list.size());
	}
	
	/**
	 * Adding a new Author to the database
	 */
	public void addAuthor(Author a){
		sql = "INSERT INTO author (firstName, lastName, emailAddr) VALUES (?,?,?)";
		List<String> list = new ArrayList<String>();
		list.add(a.getFirstName());
		list.add(a.getLastName());
		list.add(a.getEmailAddr());
				
		paramsValue = list.toArray();
		super.update(sql, paramsValue);
		
		System.out.println("You have added a new author");
	}
	
	/**
	 * Adding a new paper to the database
	 * Author ID is checked when inputing author information. If author not found, prompt to add a new author
	 * Reviewer is automatically assigned to the paper added
	 */
	public void addPaper(Paper p){
		
		sql = "INSERT INTO paper (title, absrract, fileName, authorId, reviewerId) VALUES (?,?,?,?,?)";
		List<String> list = new ArrayList<String>();
		
		list.add(p.getTitle());
		list.add(p.getAbsrract());
		list.add(p.getFileName());
		list.add(p.getAuthorId());
		list.add(p.getReviewerId());
				
		paramsValue = list.toArray();

		super.update(sql, paramsValue);
		System.out.println("You have added a new Paper");
	}
	
	/**
	 * delete an author from the database
	 * @param emailAddr
	 */
	public void deleteAuthorById(String emailAddr){
		sql = "delete from author where emailAddr = ?";
		paramsValue = new Object[] {emailAddr};
		super.update(sql, paramsValue);
		System.out.println("No foreign key reference to Author: " + emailAddr);
		System.out.println("You have successfully deleted Author: " + emailAddr);
	
	}
}
