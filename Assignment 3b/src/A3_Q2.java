//-------------------------
//Assignment 3
//Written by: Mark Benedict Agluba, 40294956
//For COMP 248 S - Fall 2024
//-------------------------

//Java program that will manage an inventory of 5 products. Each products has a name, price, and quantity in stock.
//The program can update, display, and search for each product.
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
			productPrices[i] =Double.parseDouble(userInputArr[0]);
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
			System.out.print("Enter your choice: ");
			int userInput = input.nextInt();
			if (userInput ==1) {
				System.out.println("Product List: ");
				for(int i = 0; i < productQuantity.length; i++) {
					System.out.println("\t"+"Product " + (i+1) + ":");
					System.out.println("\t"+"Name: "+ productName[i]);
					System.out.println("\t"+"Price: $"+String.format("%.1f", productPrices[i]));
					System.out.println("\t"+"Quantity: "+ productQuantity[i]);
					System.out.println();
					System.out.println("-------------------------------------");
				}
			} else if(userInput == 2) {
				System.out.print("Enter the product number (1-5) to update quantity: ");
				int numProduct = input.nextInt();
				System.out.print("Enter new quantity for "+ productName[numProduct -1]+ ": ");
				int qtyProduct = input.nextInt();
				productQuantity[numProduct -1] = qtyProduct;
				System.out.println("Quantity updated successfully!");
				System.out.println();
			} else if (userInput == 3){
				input.nextLine();
				System.out.print("Enter the name of the product to search for: ");
				String nameSearch = input.nextLine();
				int productLoc = -1;
				for (int i = 0; i < productName.length; i++) {
					if(productName[i].equalsIgnoreCase(nameSearch)) {
						productLoc = i;
						break;
					}
				}
				if(productLoc != -1) {
					System.out.println("Product Found: ");
					System.out.println("\t"+ "Name: " + productName[productLoc]);
					System.out.println("\t"+"Price: " + "$"+ String.format("%.1f", productPrices[productLoc]));
					System.out.println("\t"+"Quantity: " + productQuantity[productLoc]);
					System.out.println();
				} else {
					System.out.println("Product Not Found!");
				}
			} else if (userInput == 4) {
				int lowQtyIndex = searchLowestIndex(productQuantity);
				if( lowQtyIndex != -1) {
					System.out.println("Product with the Lowest Quantity:");
					System.out.println("\t"+"Name: " + productName[lowQtyIndex]);
					System.out.println("\t"+"Price: " + "$"+ String.format("%.1f", productPrices[lowQtyIndex]));
					System.out.println("\t"+"Quantity: " + productQuantity[lowQtyIndex]);
					System.out.println();
				} else {
					System.out.println("The inventory is empty!");
				}
			} else if (userInput == 5) {
				int highValueIndex = searchHighestIndex(productPrices);
				if(highValueIndex != -1) {
					System.out.println("Product with the Highest Price: ");
					System.out.println("\t"+"Name: "+ productName[highValueIndex]);
					System.out.println("\t"+"Price: "+"$"+String.format("%.1f", productPrices[highValueIndex]));
					System.out.println("\t"+"Quantity: " + productQuantity[highValueIndex]);
					System.out.println();
				} else {
					System.out.println("The inventory is empty!");
				}
			}else if (userInput == 6) {
				System.out.println("Thank you for using the Inventory Management System! Goodbye!");
				exitProgram =true;
			} else {
				System.out.println("Invalid input! Please try again!");
			}
		}
		input.close();
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

	private static int searchHighestIndex(double[] numArray) {
		if (numArray.length == 0) {
			return -1;
		}
		int maxIndex = 0;
		for(int i = 0; i < numArray.length;i++) {
			if(numArray[i] > numArray[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private static int searchLowestIndex(int[] numArray) {
		if (numArray.length == 0) {
			return -1;
		}
		int minIndex = 0;
		for(int i = 0; i < numArray.length;i++) {
			if(numArray[i] < numArray[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

}
