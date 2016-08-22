package daabzor.currencies;

import java.io.IOException;
import java.util.Scanner;



public class MainForex {

	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int checkInput = 0;
		String budget;
		String transaction;
		String currency;
		
		do {
			System.out.println("Enter your budget(PLN): ");
			budget = in.nextLine().trim();
				
				if (StringChecking.isValidBudget(budget) == false) {
					checkInput = 1;
					System.out.println("Wrong input");
				}
				if (StringChecking.isValidBudget(budget) == true) {
					checkInput = 0;
				}
		} while (checkInput == 1); 
		
		do {
			System.out.println("Do you want to buy or sell curency?");
			transaction = in.nextLine().trim();
				
				if (StringChecking.isValidTransaction(transaction) == false) {
					checkInput = 1;
					System.out.println("Wrong input");
				}
				if (StringChecking.isValidTransaction(transaction) == true) {
					checkInput = 0;
				}
		} while (checkInput == 1);
		
		 do {
			System.out.println("Enter currency you want to " + transaction + " (eg. '1000 USD')");
			currency = in.nextLine().trim();
				
				if (StringChecking.isValidStringCurrency(currency) == false) {
					checkInput = 1;
					System.out.println("Wrong input");
				}
				if (StringChecking.isValidStringCurrency(currency) == true) {
					checkInput = 0;

					String[] currencyName = splittedString(currency);
//									
					if (StringChecking.isValidCurrencyName(currencyName[1].toUpperCase()) == false) {
						checkInput = 1;
						System.out.println("Wrong currency name");
						System.out.println("Avalieble currencies: ");
						StringChecking.printEnum();
						System.out.println();
					}
				}		
		} while (checkInput == 1); 
			checkInput = 0;
		
		
		Currencies change = new Currencies(transaction, stringConvertionToInt(budget), currency);
		change.setCurrency();
		change.setRatio();
		change.result();
	
	}
	
	private static String[] splittedString(String s) {
		String[] splittedString = s.split(" ");
		return splittedString;
	}
	
	private static int stringConvertionToInt(String s) {
		int budget;
		return budget = Integer.parseInt(s);
	}

}
