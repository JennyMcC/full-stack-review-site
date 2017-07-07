package Alcohols.alcohol;

import static java.util.Collections.emptySet;

import java.util.Collections;
import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlcoholController {

	@Resource
	private BrandRepo brandRepo;
	@Resource
	private CheapBeerRepo cheapBeerRepo;
	@Resource
	private TagRepo tagRepo;

	@RequestMapping("/alcohol")
	public String fetchBrand(Model model) {
		model.addAttribute("brand", brandRepo.findAll());
		return "alcohol";
	}

	@RequestMapping("/brand")
	public String fetchSingleBrand(@RequestParam("id") long id, Model model) {
		model.addAttribute(brandRepo.findOne(id));
		return "brand";
	}

	@RequestMapping("/cheapBeer")
	public String fetchCheapBeer(@RequestParam("id") long id, Model model) {
		model.addAttribute(cheapBeerRepo.findOne(id));
		return "cheapBeer";
	}
	
	@RequestMapping("/tags")
	public String showTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}
	
	@RequestMapping("/tags/delete")
	public String deleteTag(@RequestParam long tagId, @RequestParam long cheapBeerId) {
		Tag toDelete = tagRepo.findOne(tagId);
		for(CheapBeer cheapBeer: toDelete.getCheapBeers()) {
			cheapBeer.remove(toDelete);
			cheapBeerRepo.save(cheapBeer);
		}
		tagRepo.delete(toDelete);
		return "redirect:/cheapBeer?id=" + cheapBeerId;
	}
	
	@RequestMapping("/tags/add/{id}")
	public String addTag(@RequestParam long id) {
		Tag toSave = tagRepo.findOne(id);
		for(CheapBeer cheapBeer: toSave.getCheapBeers()) {
			cheapBeer.add(toSave);
			cheapBeerRepo.save(cheapBeer);
		}
		tagRepo.save(toSave);
		return "redirect:/cheapBeer";
	}
	

}
