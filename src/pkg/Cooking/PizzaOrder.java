package pkg.Cooking;

import java.util.List;
import pkg.Cooking.Strategy.*;
import java.util.ArrayList;
import pkg.PizzaTypes.*;

/**
 * Class to manage pizza orders.
 */
public class PizzaOrder {
    private PizzaCookingFactory pizzaFactory;
    private ICookingStrategy cookingStrategy;
    private List<AbstractPizza> pizzaOrderList;
 
    // Constructor
    
    /**
     * Constructs a PizzaOrder object with a default pizza cooking factory and an empty pizza order list.
     */
    public PizzaOrder() {
        this.pizzaFactory = new PizzaCookingFactory();
        this.pizzaOrderList = new ArrayList<>();
    }
    
    /**
     * Prints the toppings of the pizza order with the given ID.
     * 
     * @param orderID The ID of the pizza order.
     */
    public void printListOfToppingsByPizzaOrderID(int orderID) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            System.out.println("Toppings for Pizza Order ID " + orderID + ":");
            for (Toppings topping : pizza.getToppingList()) {
                System.out.println(topping);
            }
        } else {
            System.out.println("Pizza order with ID " + orderID + " not found.");
        }
    }
    
    /**
     * Prints the details of the pizza order.
     * 
     * @param orderID The ID of the pizza order.
     */
    public void printPizzaOrderCart(int orderID) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            System.out.println(pizza);
        } else {
            System.out.println("Pizza order with ID " + orderID + " not found.");
        }
    }
    
    /**
     * Retrieves the pizza with the given order ID.
     * 
     * @param orderID The ID of the pizza order.
     * @return The pizza with the specified order ID, or null if not found.
     */
    public AbstractPizza getPizzaByOrderID(int orderID) {
        for (AbstractPizza pizza : pizzaOrderList) {
            if (pizza.getPizzaOrderID() == orderID) {
                return pizza;
            }
        }
        return null;
    }
    
    /**
     * Adds a new pizza to the pizza order list.
     * 
     * @param pizzaType The type of pizza to add.
     * @return True if the pizza was successfully added, false otherwise.
     */
    public boolean addPizzaToCart(PizzaType pizzaType) {
        AbstractPizza newPizza = pizzaFactory.createPizza(pizzaType);
        if (newPizza != null) {
            return pizzaOrderList.add(newPizza);
        }
        return false;
    }
    
    /**
     * Adds a new topping to the pizza with the specified order ID.
     * 
     * @param orderID The ID of the pizza order.
     * @param topping The topping to add.
     * @return True if the topping was successfully added, false otherwise.
     */
    public boolean addNewToppingToPizza(int orderID, Toppings topping) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null && !pizza.getToppingList().contains(topping)) {
            pizza.getToppingList().add(topping);
            pizza.updatePizzaPrice();
            return true;
        }
        return false;
    }
    
    /**
     * Removes a topping from the pizza with order ID.
     * 
     * @param orderID The ID of the pizza order.
     * @param topping The topping to remove.
     * @return True if the topping was successfully removed, false otherwise.
     */
    public boolean removeToppingFromPizza(int orderID, Toppings topping) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null && pizza.getToppingList().contains(topping)) {
            pizza.getToppingList().remove(topping);
            pizza.updatePizzaPrice();
            return true;
        }
        return false;
    }

    /**
     * Checks if there are any un-cooked pizzas in the order.
     * 
     * @return True if there are un-cooked pizzas, false otherwise.
     */
    public boolean isThereAnyUncookedPizza() {
        for (AbstractPizza pizza : pizzaOrderList) {
            if (pizza.getCookingStrategy() == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the total price of the pizza order.
     * 
     * @return The total price of the  order.
     * @throws Exception if there are un-cooked pizzas.
     */
    public double checkout() throws Exception {
        if (isThereAnyUncookedPizza()) {
            throw new Exception("There are uncooked pizzas in the order. Cannot proceed with checkout.");
        }

        double totalCartPrice = 0.0;
        for (AbstractPizza pizza : pizzaOrderList) {
            totalCartPrice += pizza.getTotalPrice();
        }
        return totalCartPrice;
    }

    /**
     * Selects a cooking strategy for the order.
     * 
     * @param orderID The ID of the pizza order.
     * @param cookingStrategyType The type of cooking strategy to select.
     * @return True if the cooking strategy was successfully selected, false if not.
     */
    public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            switch (cookingStrategyType) {
                case BRICK_OVEN:
                    cookingStrategy = new BrickOvenCookingStrategy();
                    break;
                case CONVENTIONAL_OVEN:
                    cookingStrategy = new ConventionalOvenCookingStrategy();
                    break;
                case MICROWAVE:
                    cookingStrategy = new MicrowaveCookingStrategy();
                    break;
            }
            return cookingStrategy.cook(pizza);
        }
        return false;
    }
}
