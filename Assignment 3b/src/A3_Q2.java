//-------------------------
//Assignment 3
//Written by: Mark Benedict Agluba, 40294956
//For COMP 248 S - Fall 2024
//-------------------------

//Java program that will manage an inventory of 5 products. Each products has a name, price, and quantity in stock.
//The program can update, display, and search for such product.
import java.util.Scanner;
import java.util.Arrays;
public class A3_Q2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Inventory Management System");
		String[] productName = new String[5];
		double[] productPrices = new double[5];
		int[] productQuantity = new int[5];
		System.out.println("Enter details for 5 products (price, quantity, name): ");
		for(int i = 0; i < productPrices.length; i++) {
			System.out.println("Product " + (i+1));
			System.out.println("Enter details for 5 products (price, quantity, name): ");
			String userInput = input.nextLine();
			String[] userInputArr = userInput.split(" ");
			productName[i] = nameCheck(userInputArr);
			productPrices[i] = Integer.parseInt(userInputArr[0]);
			productQuantity[i] = Integer.parseInt(userInputArr[1]);
		}
		System.out.println();
		boolean exitProgram = false;
		while (exitProgram != true) {
			System.out.println("Inventory Management Menu: ");
			System.out.println("1. Display information of all products");
			System.out.println("2. Update the quantity of a product");
			System.out.println("3. Search for a product by name");
			System.out.println("4. Find the product with the lowest quantity");
			System.out.println("5. Find the product with the highest price");
			System.out.println("6. Exit");

		}
	}

	private static String nameCheck(String[] userInput) {
		String productName = "";
		if( userInput.length == 4) {
			productName = String.join(" ", Arrays.copyOfRange(userInput, 2, userInput.length));
		} else {
			productName = userInput[userInput.length -1];
		}

		return productName;
	}

}
