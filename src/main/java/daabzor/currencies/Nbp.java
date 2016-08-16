package daabzor.currencies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Nbp extends Website implements Parsable {
	
	private final String fileName = "nbp.txt";
	private final String dirUrl = "http://www.nbp.pl/kursy/xml/dir.txt";
	private String completeUrl;
	private String ratio;
	
	
	public Nbp(String transaction, String currencyName) {
	super(transaction, currencyName);
	}

	public void setUrl() throws IOException {
		String line;
		String urlPart;
		URL url;
		List<String> part = new ArrayList<String>();
		
		url = new URL(dirUrl);
	    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	   
	    while ((line = in.readLine()) != null) {
	    	if (line.matches("c.*")) {
	    		part.add(line);
	    	}
	    }
	    urlPart = part.get(part.size() - 1).toString();
	    in.close();	
		
		completeUrl = "http://www.nbp.pl/kursy/xml/" + urlPart + ".xml";
	}
	
	public String getUrl(){
		return completeUrl;
	}

	public String getFileName() {
		return this.fileName;
	}
	
	public List<String> getParsedFile() throws IOException {
		List<String> ratio = new ArrayList<String>();
		String str;
		
		FileReader fr = new FileReader(getFileName());
		BufferedReader br = new BufferedReader(fr);
	
		while ((str = br.readLine()) != null) {
			if (str.matches("<kod_waluty>.*</kod_waluty>")) {
				ratio.add(str.replace("<kod_waluty>", "").replace("</kod_waluty>", ""));
			}
			if (str.matches("<kurs_kupna>.*</kurs_kupna>")) {
				ratio.add(str.replace("<kurs_kupna>", "").replace("</kurs_kupna>", ""));
			}
			if (str.matches("<kurs_sprzedazy>.*</kurs_sprzedazy>")) {
				ratio.add(str.replace("<kurs_sprzedazy>", "").replace("</kurs_sprzedazy>", ""));
			}
		}
		br.close();	
		return ratio;
	}
		
	public void setRatio() throws IOException {
		setUrl();
		saveToTxT(getUrl(), getFileName());
		ratio = getRatio(getParsedFile(), getTransaction(), getCurrencyName());
	}
	
	public String getRatio(){
		return ratio;
	}
	
}
