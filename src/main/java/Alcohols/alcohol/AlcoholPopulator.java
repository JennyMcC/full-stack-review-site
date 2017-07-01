package Alcohols.alcohol;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlcoholPopulator implements CommandLineRunner {

	@Resource
	private BrandRepo brandRepo;
	@Resource
	private CheapBeerRepo cheapBeerRepo;

	@Override
	public void run(String... args) throws Exception {

		Brand anheuserBusch = new Brand("AnheuserBusch");
		Brand millerCoors = new Brand("MillerCoors");
		brandRepo.save(anheuserBusch);
		brandRepo.save(millerCoors);

		CheapBeer budLight = new CheapBeer(anheuserBusch, "Bud Light", "America's take on 'beer'",
				"If you like beer that tastes like it's full of sugar, then look no further! Bud Light is the beer for you. Bud Light is great if you're looking to buddy-up with the drunkest of uncles at the upcoming Fouth of July cookout. It also works well if you're looking for that hellish hangover feeling from college, but you feel like you're 'above' buying 40's now.",
				"/images/budlight2.jpg");
		CheapBeer naturalLight = new CheapBeer(anheuserBusch, "Natural Light", "Beer-like water",
				"Speaking of college, Natural Light is a staple at beer pong tournaments across the land. Its smooth, watery taste will make this useless beverage go down with ease so you can drink endlessly until it's finally time to order pizza. Natural Light has been called 'Better than Beast Ice.'",
				"/images/beerpong.jpg");
		CheapBeer rollingRock = new CheapBeer(anheuserBusch, "Rolling Rock", "Green bottles hide weakness",
				"When asked, 'How often do you drink Rolling Rock?' the most common response is, 'When it's free.' Rolling Rock has been called 'The cheap beer you forgot about'. The biggest upside to Rolling Rock is it's packaging. It seems to be overwhelmingly sold in bottles so you can feel fancy while still getting that watered down beer taste.",
				"/images/rollingrock.jpg");
		CheapBeer keystone = new CheapBeer(millerCoors, "Keystone", "Just, why?", "I'm not sure why one would choose to buy a beer that tastes like you're drinking it out of an old shoe when there are countless other beers you could opt to buy. If there are NOT other beers you can buy, I would suggest taking a night off. Maybe try drinking water for once?", "/images/shoebeer.jpg");
		CheapBeer icehouse = new CheapBeer(millerCoors, "Icehouse", "Yuck.",
				"I went to my first kegger at 15 where they had a keg of Icehouse. It very nearly scarred me for life. Luckily, I grew to love beer in other forms but I have never again drank Icehouse. What I'm saying is, Icehouse was brewed to make kids barf. It's fine. It's possible that as an adult I would feel differently about it, but I am unwilling to find out.",
				"/images/bitterbeerface.jpg");

		cheapBeerRepo.save(budLight);
		cheapBeerRepo.save(naturalLight);
		cheapBeerRepo.save(rollingRock);
		cheapBeerRepo.save(keystone);
		cheapBeerRepo.save(icehouse);

	}
}
