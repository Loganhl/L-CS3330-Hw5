package pkg.PizzaTypes;

class HawaiianPizza extends AbstractPizza{
	/**
	 * Constructs a Hawaiian pizza with the toppings and default price
	 */
	public HawaiianPizza() {
		toppingList.add(Toppings.CANADIAN_BACON);
		toppingList.add(Toppings.CHEESE);
		toppingList.add(Toppings.PINEAPPLE);
		priceWithoutToppings = 3.00;
		updatePizzaPrice();
	}
	
	/**
	 * Copy constructor for Hawaiian pizza
	 * 
	 * @param pizza Where attributes are copied from
	 */
	public HawaiianPizza(HawaiianPizza pizza) {
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
