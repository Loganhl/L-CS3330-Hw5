package pkg.PizzaTypes;

class SupremePizza extends AbstractPizza {
	public SupremePizza() {
		//adding toppings and setting default price
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
	
	//copy constructor
	public SupremePizza(SupremePizza pizza) {
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
