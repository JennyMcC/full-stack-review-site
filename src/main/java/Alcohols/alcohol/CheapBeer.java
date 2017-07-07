package Alcohols.alcohol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany
	private Set<Tag> tags;

	public Brand getBrand() {
		return brand;
	}
	
	public Set<Tag> getTags() {
		return tags;
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

	@SuppressWarnings("unused")
	private CheapBeer() {
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public CheapBeer(Brand brand, String name, String tagline, String review, String imageURL, Tag...tags) {
		this.brand = brand;
		this.name = name;
		this.tagline = tagline;
		this.review = review;
		this.imageURL = imageURL;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}
	
	public void remove(Tag tag) {
		tags.remove(tag);
	}
	
	public void add(Tag tag) {
		tags.add(tag);
	}

}
