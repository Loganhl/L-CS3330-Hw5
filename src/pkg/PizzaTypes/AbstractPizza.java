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
	
	/**
	 * constructs the abstract pizza object with default values
	 * 
	 */
	public AbstractPizza(AbstractPizza pizza) {
        this.toppingList = new ArrayList<>(pizza.toppingList);
        this.priceWithoutToppings = pizza.priceWithoutToppings;
        this.totalPrice = pizza.totalPrice;
        this.pizzaOrderID = pizza.pizzaOrderID;
        this.cookingStrategy = pizza.cookingStrategy;
        this.cookingPrice = pizza.cookingPrice;
    }
	
	public abstract double updatePizzaPrice();
	
	protected abstract double addToppingsToPrice(double priceWithoutToppings);
	
	//getter and setter methods
	public List<Toppings> getToppingList() {
		return toppingList;
	}
	
	public void setToppingList(List<Toppings> toppingList) {
        this.toppingList = toppingList;
    }

    public double getPriceWithoutToppings() {
        return priceWithoutToppings;
    }

    public void setPriceWithoutToppings(double priceWithoutToppings) {
        this.priceWithoutToppings = priceWithoutToppings;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPizzaOrderID() {
        return pizzaOrderID;
    }

    public void setPizzaOrderID(int pizzaOrderID) {
        this.pizzaOrderID = pizzaOrderID;
    }
    
    public ICookingStrategy getCookingStrategy() {
    	return cookingStrategy;
    }
	
	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}
	
	public double getCookingPrice() {
		return cookingPrice;
	}
	
	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}
	
	@Override
    public String toString() {
        return "Pizza Type: " + getClass().getSimpleName() + "\n" +
                "Pizza Order ID: " + pizzaOrderID + "\n" +
                "Topping List: " + toppingList + "\n" +
                "Price without Toppings: $" + priceWithoutToppings + "\n" +
                "Total Price: $" + totalPrice + "\n" +
                "Cooking Strategy: " + cookingStrategy.getClass().getSimpleName() + "\n" +
                "Cooking Price: $" + cookingPrice;
    }
}


