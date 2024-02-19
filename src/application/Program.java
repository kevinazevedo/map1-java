package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Map<String, Integer> votes = new TreeMap<>();
		
		System.out.print("Enter file full path: ");
		String path = scan.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {		
			String line = br.readLine();		
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
			
				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				}
				else {
					votes.put(name, count);
				}

				line = br.readLine();
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("\nRESULTS:");
		for (String key : votes.keySet()) {
			System.out.println(key + ": " + votes.get(key));
		}
		
		scan.close();
	}
}
