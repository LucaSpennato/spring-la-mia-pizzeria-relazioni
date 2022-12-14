package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Ingredient;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.IngredientService;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	private IngredientService is;
	@Autowired
	private PizzaService ps;
	
	@GetMapping
	public String getIngredientPage(Model model) {
		
		List<Ingredient> i = is.findAll();
		List<Pizza> p = ps.findAll();
		
		model.addAttribute("ingr",i);
		model.addAttribute("pizzas",p);
		
		return "many/ingredients";
	}
	
	
	@GetMapping("/create")
	public String getIngrCreate(Model model) {
		
		Ingredient i = new Ingredient();
		List<Pizza> pizzas = ps.findAll();
		
		model.addAttribute("ing", i);
		model.addAttribute("pizzas",pizzas);
		
		return "many/createIngr";
	}
	
	@PostMapping("/store")
	public String storeIngredient(@Valid Ingredient Ingredient) {
		
		List<Pizza> pizzas = Ingredient.getPizzas();
		
		for (Pizza p : pizzas) {
			
			p.getIngredients().add(Ingredient);
			
		}
		
		is.save(Ingredient);
		
		return "redirect:/ingredient";
	}
	
	
}
