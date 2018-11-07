import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This program demonstrates how to read in comma-separated data
 * and how to format output.
 * 
 * @author Michael Ida
 *
 */
public class FileReaderOutputFormatter {

	public static void main(String[] args) {

		String csvfile = "demo.csv";
		String line = "";
		String csvDelimeter = ",";
		
		try {
			// print table header row
			System.out.printf("%-24s%8s\n", "NAME", "BALANCE");
			for (int i = 0; i < 32; i++) {
				System.out.print("=");
			}
			System.out.print("\n");
			
			// read in csv file line by line
			FileReader fr = new FileReader(csvfile);
			BufferedReader br = new BufferedReader(fr);
			while ( (line = br.readLine()) != null) {
				// split each line into an arrao of strings around
				// each comma
				String[] lineSplit = line.split(csvDelimeter);
				
				// the first entry in each row is a name
				String name = lineSplit[0];
				// the second entry is outstanding balance
				// (note the conversion from string to double)
				double balance = Double.parseDouble(lineSplit[1]);
				
				// print formatted output
				System.out.printf("%-24s%8.2f\n", name, balance);
			}
		} catch (IOException e) {
			System.out.println("I/O Error");
			e.printStackTrace();
		}
	}
}
