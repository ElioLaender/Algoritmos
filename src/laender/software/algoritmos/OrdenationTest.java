package laender.software.algoritmos;

public class OrdenationTest {
	
	  public static void main(String[] args) {
		  Product[] products = {
				    new Product("Lamborghini", 1000000),
				    new Product("Jipe", 46000),
				    new Product("Brasília", 16000),
				    new Product("Smart", 46000),
				    new Product("Fusca", 17000)
				};
	    
		  selectionSort(products, products.length);
		  insertSort(products, products.length);
	 }
	  
	 private static void selectionSort(Product[] products, int numberOfElements) {
		 
		 System.out.println("--SELECTION SORT--");
		 
		 for (int current = 0; current < numberOfElements; current++) {
			  
			  int smaller = minorSearch(products, current, numberOfElements - 1);
			  
			  Product currentProduct = products[current];
			  Product smallerProduct = products[smaller];
			  
			  products[current] = smallerProduct;
			  products[smaller] = currentProduct;
		  }
		  
		  
		 showProducts(products);
	 }
	 
	 private static void showProducts(Product[] products) {
		 for (Product product : products) {
	            System.out.println(product.getName() + " costs " + product.getPrice());
		  }
		 System.out.println("\n");
	 }
	  
	 // Utilizado como regra de ordenação para o selectionSort
	 private static int minorSearch(Product[] products, int start, int end) throws IllegalArgumentException {
		 
	     if (start > end) {
			 throw new IllegalArgumentException("Initial value cannot be greater than the final");
		 }
		 
		 int cheaperThan = start;
		 for (int current = start; current <= end; current++) {
			 if (products[current].getPrice() < products[cheaperThan].getPrice()) {
			     cheaperThan = current;
			 }
		 }
		
		 return cheaperThan;
	}
	 
	 private static void insertSort(Product[] products, int numberOfElements) {
		
		 System.out.println("--INSERTION SORT--");
		 
		 for (int current = 0; current < numberOfElements; current++) {
			 
			 int analyze = current;
			 
			 while (analyze > 0 && products[analyze].getPrice() < products[analyze - 1].getPrice()) { 
				 Product productAnalyze = products[analyze];
				 Product productAnalyzePrevious = products[analyze - 1];
				 products[analyze] = productAnalyzePrevious;
				 products[analyze - 1] = productAnalyze;
				 analyze--;
			 }
		 }
		 
		 showProducts(products);
	 }
}
