package daabzor.currencies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

abstract class Website {
	
	private String transaction;
	private String currencyName;
	
	Website(String transaction, String currencyName) {
	this.transaction = transaction;
	this.currencyName = currencyName;
	}
	
	String getTransaction() {
		return transaction;
	}
	
	String getCurrencyName() {
		return currencyName;
	}
	
	void saveToTxT(String url, String fileName) throws IOException {
		String inputLine;
		URL xml = new URL(url);
	    BufferedReader inXml = new BufferedReader(new InputStreamReader(xml.openStream()));
	    FileWriter save = new FileWriter(fileName);
		BufferedWriter out = new BufferedWriter(save);

	    while ((inputLine = inXml.readLine()) != null) {
	    	out.write(inputLine.trim() + "\n");
	    }
	    out.close();
	}
	
	String getRatio(List<String> arrayCurrency, String transaction, String currencyName) throws IOException {
		String error = "Wrong currency";
		String result = null;
		Integer check = 0;
		
		if (transaction.equalsIgnoreCase("buy")) {
			check = 2;
		}
		if (transaction.equalsIgnoreCase("sell")) {
			check = 1;
		}
		
		for (int i = 0; i < arrayCurrency.size(); i++) {
			String currency = arrayCurrency.get(i);
			if (currency.equalsIgnoreCase(currencyName)) {
				result = arrayCurrency.get(i + check);
			} 
		}
		if (result != null) {
			return result;
		} else {
			return error;
		}
	}	
}
