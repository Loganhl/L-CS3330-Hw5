package pkg;

import pkg.Cooking.CookingStyleType;
import pkg.Cooking.PizzaOrder;
import pkg.PizzaTypes.PizzaType;

public class main {

	public static void main(String[] args) {
		/**
		 * Instantiate a pizzaOrder
		 */
		PizzaOrder order = new PizzaOrder();
		
		/**
		 * Add pizzas to cart
		 */
		order.addPizzaToCart(PizzaType.MARGHERITA);
		order.addPizzaToCart(PizzaType.HAWAIIAN);
		order.addPizzaToCart(PizzaType.SUPREME);
		order.addPizzaToCart(PizzaType.VEGETARIAN);
		
		/**
		 * Sets the cooking strategies for the pizzas in the cart
		 */
		order.selectCookingStrategyByPizzaOrderID(0, CookingStyleType.BRICK_OVEN);
		order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.MICROWAVE);
		order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);
		order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.MICROWAVE);
		
		/**
		 * Prints pizza order cart
		 */
		order.printPizzaOrderCart(0);
	
		/**
		 * attempting to checkout, and throwing an Exception if something occurs
		 */
		try {
			double totalBill = order.checkout();
			System.out.println("Total Bill: $" + totalBill);
		} catch (Exception e) {
			System.err.println("Error: There are uncooked pizzas.");
			e.printStackTrace();
		}

	}

}
