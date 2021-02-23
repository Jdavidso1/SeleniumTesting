package walkthrough;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readCSV();
	}
	
	public static void readCSV() {
		String filename = "C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Java\\SeleniumTesting\\UserAccounts.csv";
		List <String[]> records = utilities.CSV.get(filename);
		
		// Iterating through the list
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
}
