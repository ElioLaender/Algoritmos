package laender.software.algoritmos;

public class TestsLowerPrice {
	
	public static void main(String[] args) {
		
		Product[] products = {
		    new Product("Lamborghini", 1000000),
		    new Product("Jipe", 46000),
		    new Product("Brasília", 16000),
		    new Product("Smart", 46000),
		    new Product("Fusca", 17000)
		};
		
		int cheaperThan = minorSearch(products, 0, (products.length - 1));
		
		System.out.println("The cheapest car is "+products[cheaperThan].getName()+" and costs " + products[cheaperThan].getPrice());
	}
	
	private static int minorSearch(Product[] products, int start, int end) throws IllegalArgumentException {
		
		if (start > end) {
			throw new IllegalArgumentException("Initial value cannot be greater than the final");
		}
		
		int cheaperThan = 0;
		for (int current = start; current < end; current++) {
			if (products[current].getPrice() < products[cheaperThan].getPrice()) {
			    cheaperThan = current;
			}
		}
		
		return cheaperThan;
	}
}
