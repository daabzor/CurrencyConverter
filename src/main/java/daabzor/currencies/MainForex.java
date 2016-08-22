package daabzor.currencies;

import java.io.IOException;
import java.util.Scanner;

public class MainForex {

	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean check = false;
		int budget = 0;
		String transaction = null;
		String currency = null;
		
		
		while (check == false) {
			check = true;
			System.out.println("Enter budget (PLN)");
			if (in.hasNextInt()) {
			budget = in.nextInt();
			
			} else {
				System.err.println("Wrong input \n");
				in.next();
				continue;
			}
			check = true;
		}
		check = false;
		
		while (check == false) {
			check = true;
			System.out.println("Enter transaction (SELL/BUY)");
			transaction = in.next().toLowerCase().trim();
			
			check = StringChecking.isValidTransaction(transaction);
			if (check == false) {
				System.err.println("\n Wrong input \n");
				continue;
			}
			check = true;	
		}
		in.nextLine();
		check = false;
		
		while (check == false) {
			
			System.out.println("Enter currency you want to " + transaction + " (eg. 100 USD)");
			
			currency = in.nextLine().trim();
			
			check = StringChecking.isValidStringCurrency(currency);

			if (check == false) {
				System.err.println("Wrong input \n");
				continue;
			}
			
				String[] name = splittedString(currency);
				check = StringChecking.isValidCurrencyName(name[1].toUpperCase());				
			
			
			if (check == false) {
				System.err.println("Wrong currency name \n");
				System.err.println("Avalieble currencies:");
				StringChecking.printEnum();
				System.out.println();
				System.out.println();
				continue;
			}
			check = true;
			
		}
		
		Currencies change = new Currencies(transaction, budget, currency);
		change.setCurrency();
		change.setRatio();
		change.result();
	
	}
	
	private static String[] splittedString(String s) {
		String[] splittedString = s.split(" ");
		return splittedString;
	}

}
