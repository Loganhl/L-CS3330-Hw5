package pkg.PizzaTypes;

class HawaiianPizza extends AbstractPizza{
	//adding toppings and setting default price
	public HawaiianPizza() {
		toppingList.add(Toppings.CANADIAN_BACON);
		toppingList.add(Toppings.CHEESE);
		toppingList.add(Toppings.PINEAPPLE);
		priceWithoutToppings = 3.00;
		updatePizzaPrice();
	}
	
	//copy constructor
	public HawaiianPizza(HawaiianPizza pizza) {
		super(pizza);
	}
	
	
	@Override
	//adding the toppings onto the price
	protected double addToppingsToPrice(double priceWithoutToppings) {
		double total = priceWithoutToppings;
		for (Toppings topping : toppingList) {
			total += topping.getPrice();
		}
		return total;
	}
	
	@Override
	//updating the price
	public double updatePizzaPrice() {
		totalPrice = addToppingsToPrice(priceWithoutToppings);
		return totalPrice;
	}
	
}
