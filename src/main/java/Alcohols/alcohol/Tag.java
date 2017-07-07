package Alcohols.alcohol;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ManyToMany(mappedBy="tags")
	private Set<CheapBeer> cheapBeers;

	public long getId() {
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
