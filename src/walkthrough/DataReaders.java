package walkthrough;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();
	}
	
	public static void readCSV() {
		String filename = "C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Java\\SeleniumTesting\\UserAccounts.csv";
		List <String[]> records = utilities.CSV.get(filename);
		
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		String[][] data = utilities.Excel.get("C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Java\\SeleniumTesting\\UserLogins.xls");
		
		for (String[] record : data) {
			System.out.println("\nNEW RECORD:");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
	
}
