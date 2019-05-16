package cs623.entity;

public class Reviewer {
	private String emailAddr;
	private String firstName;
	private String lastName;
	private String authorFeedBack;
	private String commiteeFeedBack;
	private String phoneNum;
	private String affiliation;
	private int topicId;

	public String getEmailAddr() {
		return emailAddr;
	}
	
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAuthorFeedBack() {
		return authorFeedBack;
	}
	
	public void setAuthorFeedBack(String authorFeedBack) {
		this.authorFeedBack = authorFeedBack;
	}
	
	public String getCommiteeFeedBack() {
		return commiteeFeedBack;
	}
	
	public void setCommiteeFeedBack(String commiteeFeedBack) {
		this.commiteeFeedBack = commiteeFeedBack;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getAffiliation() {
		return affiliation;
	}
	
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	
	public int getTopicId() {
		return topicId;
	}
	
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
}

