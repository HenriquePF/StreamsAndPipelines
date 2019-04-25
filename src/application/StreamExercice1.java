package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class StreamExercice1 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Product> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			//			 List converted to Stream
			double avg = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size();
			// This is a product list, with map we only take the price;
			// Reduce is used to sum up all the prices;
			// Then used size() to divide and get the average price.
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			// Comparator created to sort the products in alphabetically order
			
			
			System.out.print("Average price: " + String.format("%.2f", avg));
			List<String> names = list.stream().filter(p -> p.getPrice() < avg).map(p -> p.getName()).sorted(comp.reversed()).collect(Collectors.toList());
			// Starts the same, a list converted to stream;
			// Filter used to check if any product is under the avg price;
			// Map used to get the name of the product;
			// Stream ordered by sorted method using Comparator(default method reversed);
			// Collect > collectors to transform the stream to list.
			
			
			
			names.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
