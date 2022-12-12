package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.PizzaService;
import org.generation.italy.demo.service.PromoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promozioni")
public class PromozioneController {

	@Autowired
	private PizzaService pizzaServ;
	
	@Autowired
	private PromoServ promoServ;
	
	
	@GetMapping
	public String getPizzaWithPromo(Model model) {
		
		List<Pizza> pizzas = pizzaServ.findAll();
		 
		model.addAttribute("pizzas", pizzas);
		
		return "pizzapromo";
	}
}
