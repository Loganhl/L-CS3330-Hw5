package pkg.Cooking;

import pkg.PizzaTypes.*;

public class PizzaCookingFactory {
    private static int orderIDCounter = 1;

    public AbstractPizza createPizza(PizzaType pizzaType) {
        AbstractPizza pizza = null;
        switch (pizzaType) {
            case MARGHERITA:
                pizza = new MargheritaPizza();
                break;
            case VEGETARIAN:
                pizza = new VegetarianPizza();
                break;
            case HAWAIIAN:
                pizza = new HawaiianPizza();
                break;
            case SUPREME:
                pizza = new SupremePizza();
                break;
        }
        if (pizza != null) {
            pizza.setPizzaOrderID(orderIDCounter++);
        }
        return pizza;
    }
}

