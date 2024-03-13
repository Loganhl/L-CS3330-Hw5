package pkg.Cooking.Strategy;

import pkg.PizzaTypes.AbstractPizza;

class ConventionalOvenCookingStrategy implements ICookingStrategy {
    
    public boolean cook(AbstractPizza pizza) {
        pizza.setCookingStrategy(this);
        pizza.setCookingPrice(8.0);
        pizza.updatePizzaPrice();
        return true;
    }
}


