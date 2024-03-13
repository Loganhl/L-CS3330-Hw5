package pkg.Cooking.Strategy;

import pkg.PizzaTypes.AbstractPizza;

public class BrickOvenCookingStrategy implements ICookingStrategy{
	
	public boolean cook (AbstractPizza pizza) {
		pizza.setCookingStrategy(this);
		pizza.setCookingPrice(10.0);
		pizza.updatePizzaPrice();
		return true;
	}

}
