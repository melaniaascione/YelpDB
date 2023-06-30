package it.polito.tdp.yelp.model;

import java.util.Objects;
import java.util.Set;

public class Business {

	private String businessId ;
	private String fullAddress ;
	private Boolean active ;
	private String categories ;
	private String city ;
	private Integer reviewCount ;
	private String businessName ;
	private String neighborhoods ; // sempre vuoto
	
	private Double latitude ;
	private Double longitude ;
	
	// private LatLng coordinates ;
	
	private String state ;
	private Double stars ;
	
	private Set<Review> reviews ;  // oppure List<>
	

	public Business(String businessId, String fullAddress, Boolean active, String categories, String city,
			Integer reviewCount, String businessName, String neighborhoods, Double latitude, Double longitude,
			String state, Double stars) {
		super();
		this.businessId = businessId;
		this.fullAddress = fullAddress;
		this.active = active;
		this.categories = categories;
		this.city = city;
		this.reviewCount = reviewCount;
		this.businessName = businessName;
		this.neighborhoods = neighborhoods;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
		this.stars = stars;
		this.reviews = null ;  // lazy initialization
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getNeighborhoods() {
		return neighborhoods;
	}

	public void setNeighborhoods(String neighborhoods) {
		this.neighborhoods = neighborhoods;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getStars() {
		return stars;
	}

	public void setStars(Double stars) {
		this.stars = stars;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(businessId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Business other = (Business) obj;
		return Objects.equals(businessId, other.businessId);
	}
	
	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", fullAddress=" + fullAddress + ", active=" + active
				+ ", categories=" + categories + ", city=" + city + ", reviewCount=" + reviewCount + ", businessName="
				+ businessName + ", neighborhoods=" + neighborhoods + ", latitude=" + latitude + ", longitude="
				+ longitude + ", state=" + state + ", stars=" + stars + ", reviews=" + reviews + "]";
	}
	
	
	
}
