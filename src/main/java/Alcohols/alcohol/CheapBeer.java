package Alcohols.alcohol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class CheapBeer {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String tagline;
	private String imageURL;

	@Lob
	String review;

	@ManyToOne
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTagline() {
		return tagline;
	}

	public String getReview() {
		return review;
	}

	public String getImageURL() {
		return imageURL;
	}

	private CheapBeer() {
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public CheapBeer(Brand brand, String name, String tagline, String review, String imageURL) {
		this.brand = brand;
		this.name = name;
		this.tagline = tagline;
		this.review = review;
		this.imageURL = imageURL;
	}

}
