package pkg.PizzaTypes;

class SupremePizza extends AbstractPizza {
	public SupremePizza() {
		/**
		 * Constructs a Supreme pizza with the toppings and default price
		 */
        toppingList.add(Toppings.TOMATO);
        toppingList.add(Toppings.CHEESE);
        toppingList.add(Toppings.BELL_PEPPER);
        toppingList.add(Toppings.ITALIAN_SAUSAGE);
        toppingList.add(Toppings.PEPPERONI);
        toppingList.add(Toppings.BLACK_OLIVE);
        toppingList.add(Toppings.MUSHROOM);
        priceWithoutToppings = 3.50;
        updatePizzaPrice();
	}
	
	/**
	 * Copy constructor for Supreme pizza
	 * 
	 * @param pizza Where attributes are copied from
	 */
	public SupremePizza(SupremePizza pizza) {
		super(pizza);
	}
	
	
	/**
	 * Calculates the price of pizza with the toppigns
	 * 
	 * @param priceWithoutToppings The default price of the pizza with no toppings.
	 * @return The total price after toppings are added
	 */
	@Override
	protected double addToppingsToPrice(double priceWithoutToppings) {
		double total = priceWithoutToppings;
		for (Toppings topping : toppingList) {
			total += topping.getPrice();
		}
		return total;
	}
	
	
	/**
	 * Updates the price of the pizza
	 * 
	 * @return The updated total price.
	 */
	@Override
	public double updatePizzaPrice() {
		totalPrice = addToppingsToPrice(priceWithoutToppings);
		return totalPrice;
	}
}
