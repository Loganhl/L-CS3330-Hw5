package pkg.Cooking.Strategy;

import pkg.PizzaTypes.AbstractPizza;

class MicrowaveCookingStrategy implements ICookingStrategy {
    
    public boolean cook(AbstractPizza pizza) {
        if (pizza != null) {
            pizza.setCookingStrategy(this);
            pizza.setCookingPrice(1.0);
            pizza.updatePizzaPrice();
            return true;
        }
        return false;
    }
}

