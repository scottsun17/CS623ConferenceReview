package cs623.entity;

public class Review {
	private int id;
	private String recommendation;
	private int meritScore;
	private int readabilityScore;
	private int relevanceScore;
	private int originalityScore;
	private int paperId;
	private String reviewerId;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRecommendation() {
		return recommendation;
	}
	
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	
	public int getMeritScore() {
		return meritScore;
	}
	
	public void setMeritScore(int meritScore) {
		this.meritScore = meritScore;
	}
	
	public int getReadabilityScore() {
		return readabilityScore;
	}
	
	public void setReadabilityScore(int readabilityScore) {
		this.readabilityScore = readabilityScore;
	}
	
	public int getRelevanceScore() {
		return relevanceScore;
	}
	
	public void setRelevanceScore(int relevanceScore) {
		this.relevanceScore = relevanceScore;
	}
	
	public int getOriginalityScore() {
		return originalityScore;
	}
	
	public void setOriginalityScore(int originalityScore) {
		this.originalityScore = originalityScore;
	}
	
	public int getPaperId() {
		return paperId;
	}
	
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	
	public String getReviewerId() {
		return reviewerId;
	}
	
	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
}
