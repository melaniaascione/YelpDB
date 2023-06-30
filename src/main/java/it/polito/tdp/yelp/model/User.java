package it.polito.tdp.yelp.model;

import java.util.Objects;

public class User {
	
	private String userId;
	private Integer votesFunny ;
	private Integer votesUseful ;
	private Integer votesCool ;
	private String name ;
	private Double averageStars ;
	private Integer reviewCount ;
	
	public User(String userId, Integer votesFunny, Integer votesUseful, Integer votesCool, String name,
			Double averageStars, Integer reviewCount) {
		super();
		this.userId = userId;
		this.votesFunny = votesFunny;
		this.votesUseful = votesUseful;
		this.votesCool = votesCool;
		this.name = name;
		this.averageStars = averageStars;
		this.reviewCount = reviewCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getVotesFunny() {
		return votesFunny;
	}

	public void setVotesFunny(Integer votesFunny) {
		this.votesFunny = votesFunny;
	}

	public Integer getVotesUseful() {
		return votesUseful;
	}

	public void setVotesUseful(Integer votesUseful) {
		this.votesUseful = votesUseful;
	}

	public Integer getVotesCool() {
		return votesCool;
	}

	public void setVotesCool(Integer votesCool) {
		this.votesCool = votesCool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAverageStars() {
		return averageStars;
	}

	public void setAverageStars(Double averageStars) {
		this.averageStars = averageStars;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}
	
}
