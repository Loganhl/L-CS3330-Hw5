package pkg.PizzaTypes;

public class MargheritaPizza extends AbstractPizza{
	public MargheritaPizza() {
		//adding toppings to pizza and adding default price
		toppingList.add(Toppings.TOMATO);
		toppingList.add(Toppings.CHEESE);
		priceWithoutToppings = 2.50;
		updatePizzaPrice();
	}

	//copy constructor
	public MargheritaPizza(MargheritaPizza pizza) {
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
