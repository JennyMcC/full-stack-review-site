package Alcohols.alcohol;

import org.springframework.data.repository.CrudRepository;

public interface TagRepo extends CrudRepository<Tag, Long> {
	
	Tag findByName(String name);

}
