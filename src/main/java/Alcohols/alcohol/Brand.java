package Alcohols.alcohol;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Brand {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="brand")
	
	@OrderBy("name")
	private Set<CheapBeer> beers;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Set<CheapBeer> getBeers() {
		return beers;
	}
	
	private Brand() {
	}
	
	public Brand(String name) {
		this.name = name;
	}
	
	
}
