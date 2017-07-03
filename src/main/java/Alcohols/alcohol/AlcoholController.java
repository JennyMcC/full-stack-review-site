package Alcohols.alcohol;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlcoholController {

	@Resource
	private BrandRepo brandRepo;
	@Resource
	private CheapBeerRepo cheapBeerRepo;

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

}
