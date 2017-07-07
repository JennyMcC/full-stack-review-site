package Alcohols.alcohol;

import static java.util.Arrays.asList;

import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class AlcoholPopulator implements CommandLineRunner {

	@Resource
	private BrandRepo brandRepo;
	@Resource
	private CheapBeerRepo cheapBeerRepo;
	@Resource
	private TagRepo tagRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Tag watery = new Tag("watery");
		Tag niceBottles = new Tag("nice bottles");
		Tag light = new Tag("light");
		tagRepo.save(watery);
		tagRepo.save(niceBottles);
		tagRepo.save(light);
		
//		Set<Tag> tags = new HashSet<>(asList(watery, niceBottles, light));
//		Set<Tag> wateryOnly = new HashSet<>();
		
		Brand anheuserBusch = new Brand("AnheuserBusch");
		Brand millerCoors = new Brand("MillerCoors");
		brandRepo.save(anheuserBusch);
		brandRepo.save(millerCoors);

		CheapBeer budLight = new CheapBeer(anheuserBusch, "Bud Light", "America's Take on 'Beer'",
				"If you like beer that tastes like it's full of sugar, then look no further! Bud Light is the beer for you. Bud Light is great if you're looking to buddy-up with the drunkest of uncles at the upcoming Fouth of July cookout. It also works well if you're looking for that hellish hangover feeling from college, but you feel like you're 'above' buying 40's now.",
				"/images/budlight2.jpg", light);
		CheapBeer naturalLight = new CheapBeer(anheuserBusch, "Natural Light", "Beer-like Water",
				"Speaking of college, Natural Light is a staple at beer pong tournaments across the land. Its smooth, watery taste will make this useless beverage go down with ease so you can drink endlessly until it's finally time to order pizza. Natural Light has been called 'Better than Beast Ice.'",
				"/images/beerpong.jpg", watery, light);
		CheapBeer rollingRock = new CheapBeer(anheuserBusch, "Rolling Rock", "The Green Bottles Hide Weakness",
				"When asked, 'How often do you drink Rolling Rock?' the most common response is, 'When it's free.' Rolling Rock has been called 'The cheap beer you forgot about'. The biggest upside to Rolling Rock is it's packaging. It seems to be overwhelmingly sold in bottles so you can feel fancy while still getting that watered down beer taste.",
				"/images/rollingrock.jpg", niceBottles, watery);
		CheapBeer keystone = new CheapBeer(millerCoors, "Keystone", "The Drink of Despiration",
				"I'm not sure why one would choose to buy a beer that tastes like you're drinking it out of an old shoe when there are countless other beers you could opt to buy. If there are NOT other beers you can buy, I would suggest taking a night off. Maybe try drinking water for once and calling your mother to brag about your one night of decent life choices.",
				"/images/shoebeer.jpg", watery);
		CheapBeer icehouse = new CheapBeer(millerCoors, "Icehouse", "Save Yourself",
				"I went to my first college party at 16 where they had a keg of Icehouse. It very nearly scarred me for life. Luckily, I grew to love beer in other forms but I have never again drank Icehouse. What I'm saying is, Icehouse was brewed to make kids barf. It's an excellent tool for teaching kids the harsh realities of drinking disgusting beer. It's possible that as an adult I would feel differently about the taste, but I am unwilling to find out.",
				"/images/bitterbeerface.jpg", watery);
		CheapBeer highLife = new CheapBeer(millerCoors, "High Life", "The Andre of Beers",
				"I would be remiss if I did not talk about the so-called 'Champagne of Beers'. The beauty of this one is the marketing campaign. Who wouldn't want to try it with a title like that? The answer should be, YOU. Have you ever suffered through an actual champagne hangover? Just imagine what fresh hell a 'Champagne of Beers' hangover will bring.",
				"/images/highlife.jpg", niceBottles);

		cheapBeerRepo.save(budLight);
		cheapBeerRepo.save(naturalLight);
		cheapBeerRepo.save(rollingRock);
		cheapBeerRepo.save(keystone);
		cheapBeerRepo.save(icehouse);
		cheapBeerRepo.save(highLife);

	}
}
