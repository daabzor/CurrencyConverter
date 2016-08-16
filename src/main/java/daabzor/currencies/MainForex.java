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
		
		
		while (check == false){
			System.out.println("Enter budget (PLN)");
			if(in.hasNextInt()){
			budget = in.nextInt();
			
			} else {
				System.out.println("Wrong input");
				in.next();
				continue;
			}
			check = true;
			
		}
		
		check = false;
		
		while (check == false){
			System.out.println("Enter transaction (SELL/BUY)");
			transaction = in.next().toLowerCase().trim();
			
			check = StringChecking.isValidTransaction(transaction);
			if(check == false){
				System.out.println("Wrong input");
				continue;
			}
			check = true;
			
		}
		
		check = false;
		
		while (check == false) {
			
			System.out.println("Enter currency you want to " + transaction + " (eg. 100 USD)");
			in.nextLine();
			currency = in.nextLine().trim();
			
			check = StringChecking.isValidStringCurrency(currency);

			if(check == false) {
				System.out.println("Wrong input");
				continue;
				
			}
			check = true;
		}
		
		Currencies a = new Currencies(transaction, budget, currency);
		a.setCurrency();
		a.setRatio();
		a.result();
	
	}

}
