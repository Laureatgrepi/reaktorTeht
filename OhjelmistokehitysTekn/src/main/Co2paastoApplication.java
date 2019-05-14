package main;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import file_content.StopProgram;
import methods.Co2;
import methods.Co2_vakiluku;
import methods.Vakiluku;

public class Co2paastoApplication {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String country = "";
		String year = "";
		String result = "";
		boolean stop = true;

		while (stop) {

			System.out.println("CO2-EMISSIONS (..stop program by typing 'stop' at any time)");
			System.out.println("\nEnter country or area");

			country = input.nextLine();
			if (StopProgram.stopProgram(country)) {
				break;
			}
			if (Co2.checkForFalseCountry(country) == false) {
				System.out.println(country + " is unavailable or doesn't exist");
				while (Co2.checkForFalseCountry(country) == false) {
					System.out.println("\nEnter country or area");
					country = input.nextLine();
					if (StopProgram.stopProgram(country)) {
						break;
					}
				}
			}

			System.out
					.println("\nEnter the year you want to see OR type 'all' if you want all of the available years \n"
							+ "(OBS! Available years are 1960 - 2018)");
			year = input.nextLine();

			if (StopProgram.stopProgram(year)) {
				break;
			}
			if (year.equalsIgnoreCase("all")) {
				Co2.co2Country(country);
			} else if (1959 > Integer.parseInt(year) || 2018 < Integer.parseInt(year)) {
				System.out.println(year + " is out of range");
				while (1960 > Integer.parseInt(year) || 2018 < Integer.parseInt(year)) {
					System.out.println("\nEnter a year");
					year = input.nextLine();
					if (StopProgram.stopProgram(country)) {
						break;
					}
				}
			}
			if (year.equalsIgnoreCase("all") == false) {
				Co2.print1Co2Country(Co2.co2ByCountryAndYear(country, year));

				System.out.println("Do you want to know how much it was per capita? \n" + " (OBS! type 'yes' or 'no')");

				result = input.nextLine();
				if (StopProgram.stopProgram(result)) {
					break;
				} else if (result.equalsIgnoreCase("yes")) {
					float vakilukuResult = Co2_vakiluku.co2PerCapita(country, year);

					if (vakilukuResult == 0) {
						System.out.println("\n The current Co2-emissions are unknown \n \n "
								+ "----------------------------------------------------------");
					} else {
						NumberFormat formatter = new DecimalFormat("0.00000000000");
						String string = formatter.format(vakilukuResult);
						int lkm = Vakiluku.vakilukuByCountryAndYear(country, year);

						System.out.println("\n In " + year + " the population of " + country + " was " + lkm
								+ " and Co2-emissions per capita in " + country + " was: " + string + " (kt) \n \n "
								+ "---------------------------------------------------------------");
					}

				} else {
					System.out.println("--------------------------------------------------------------");
				}

			}

		}

	}

}
