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
	
	//constructor
	public AbstractPizza(AbstractPizza pizza) {
        this.toppingList = new ArrayList<>(pizza.toppingList);
        this.priceWithoutToppings = pizza.priceWithoutToppings;
        this.totalPrice = pizza.totalPrice;
        this.pizzaOrderID = pizza.pizzaOrderID;
        this.cookingStrategy = pizza.cookingStrategy;
        this.cookingPrice = pizza.cookingPrice;
    }
	
	protected void addDefaultToppings() {
		
	}
	
	protected void setDefaultPriceWithoutToppings() {
		
	}
	
	public abstract double updatePizzaPrice();
	
	protected abstract double addToppingsToPrice(double priceWithoutToppings);
	
	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
		
	}
	
	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}
}


