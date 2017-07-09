package Alcohols.alcohol;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="tags")
	@OrderBy("name")
	private Set<CheapBeer> cheapBeers;

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public Set<CheapBeer> getCheapBeers() {
		return cheapBeers;
	}
	
	public Tag() {}

	public Tag(String name) {
		this.name = name;
	}

}
