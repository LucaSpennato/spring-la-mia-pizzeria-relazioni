package org.generation.italy.demo;

import java.time.LocalDate;
import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promozione;
import org.generation.italy.demo.service.DrinkService;
import org.generation.italy.demo.service.PizzaService;
import org.generation.italy.demo.service.PromoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	@Autowired
	private PizzaService P;
	@Autowired
	private DrinkService d;
	@Autowired
	private PromoServ ps;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("Margherita", "pizzapazza" , 5);
		Pizza p2 = new Pizza("Qualcosa", "descrizione carina" , 6);
		Pizza p3 = new Pizza("FourSeason", "descrizione carina il ritorno" , 7);
		Pizza p4 = new Pizza("FourSeason", "descrizione carina il ritorno" , 7);
		
		P.save(p1);
		P.save(p2);
		P.save(p3);
		P.save(p4);
		
		// Drinks 
		
		Drink d1 = new Drink("biretta", null, 3);
		Drink d2 = new Drink("cochina?", null, 3);
		Drink d3 = new Drink("qualcosa", null, 5);
		
		d.save(d1);
		d.save(d2);
		d.save(d3);
		
		// Promo
		
		Promozione pz1 = new Promozione("Promo1", LocalDate.parse("2222-11-11"), LocalDate.parse("2222-12-12"), p1);
		Promozione pz2 = new Promozione("Promo2", LocalDate.parse("2222-11-11"), LocalDate.parse("2222-12-12"), p1);
		Promozione pz3 = new Promozione("Promo3", LocalDate.parse("2222-11-11"), LocalDate.parse("2222-12-12"), p3);
		
		
		ps.save(pz1);
		ps.save(pz2);
		ps.save(pz3);
		
		System.err.println(pz1);
		
//		ps.delete(pz3);
		
		System.out.println("EAGER, NO NEED FOR SERV------------------------------------------");
		
		List<Pizza> pizzas = P.findAll();
		
		for (Pizza pizza : pizzas) {
			
			System.out.println(pizza);
			
			for (Promozione pz : pizza.getPromotions()) {
				
				System.err.println("\n" + pz);
				
			}
			
		}
		
		System.out.println("Lazy but with serv method-------------------------------------------");
		
		List<Pizza> pizzasPromo = P.findAllPromotions();
		
		for (Pizza pizza : pizzasPromo) {
			
			System.out.println(pizza);
			
			for (Promozione pz : pizza.getPromotions()) {
				
				System.err.println("\n" + pz);
				
			}
			
		}
		
		
	}

}
