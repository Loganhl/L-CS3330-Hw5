package pkg.PizzaTypes;
import java.util.ArrayList;
import java.util.List;

import pkg.Cooking.Strategy.ICookingStrategy;

public abstract class AbstractPizza {
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCounter;
	protected ICookingStrategy cookingStrategy;
	protected double cookingPrice;
	
	
	public AbstractPizza() {
		toppingList = new ArrayList<>();
		
	}
	
	protected void addDefaultToppings() {
		
	}
	
	protected void setDefaultPriceWithoutToppings() {
		
	}
	
	public abstract double updatePizzaPrice();
	
	public abstract double addToppingsToPrice(double priceWithoutToppings);
	
	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
		
	}
	
	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}
}


