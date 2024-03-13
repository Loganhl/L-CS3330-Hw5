package pkg.PizzaTypes;

class MargheritaPizza extends AbstractPizza{
	public MargheritaPizza() {
		/**
		 * Constructs a Margherita pizza with the toppings and default price
		 */
		toppingList.add(Toppings.TOMATO);
		toppingList.add(Toppings.CHEESE);
		priceWithoutToppings = 2.50;
		updatePizzaPrice();
	}

	/**
	 * Copy constructor for Margherita pizza
	 * 
	 * @param pizza Where attributes are copied from
	 */
	public MargheritaPizza(MargheritaPizza pizza) {
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
