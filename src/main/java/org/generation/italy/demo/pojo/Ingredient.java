package org.generation.italy.demo.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Table
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	@NotEmpty(message = "Name is required")
	@Size(min=4, max=20)
	private String name;
	
	@Column
	@ManyToMany(mappedBy = "ingridients")
	private List<Pizza> pizzas;

	public Ingredient() {}
	
	public Ingredient(String name) {
		setName(name);
	}
	public Ingredient(String name, List<Pizza> pizza) {
		setName(name);
		setPizzas(pizza);
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	@Override
	public String toString() {
		return getId() + " - " 
				+ getName() + " - "
				+ getPizzas();
	}
	
}
