package daabzor.currencies;

import java.io.IOException;
import java.util.List;

public interface Parsable {
	/*
	 * This method set an url which have to be download
	 */
	void setUrl() throws IOException;
	
	String getUrl();
	
	
	/*
	 * Name of file which have to be save
	 */	
	String getFileName();
	
	
	
	/*
	 * This method return ArrayList where [i] = should be name of currency, [i+1] = currency buy rate, [i+2] = currency sell rate
	 */
	List<String> getParsedFile() throws IOException;

	
}
