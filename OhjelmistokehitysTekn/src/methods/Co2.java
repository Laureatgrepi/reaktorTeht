package methods;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import file_content.Co2xmlalustus;

public class Co2 {

	public static NodeList co2AllCountries = Co2xmlalustus.co2XmlAlustus();

	public static void co2All() {

		for (int i = 0; i < co2AllCountries.getLength(); i++) {
			System.out.println(co2AllCountries.item(i).getTextContent());
		}

	}

	public static void co2Country(String country) {

		for (int i = 0; i < co2AllCountries.getLength(); i++) {
			Node nNode = co2AllCountries.item(i);
			Element eElement = (Element) nNode;
			String countryName = eElement.getElementsByTagName("field").item(0).getTextContent();
			if (country.equalsIgnoreCase(countryName)) {
				print1Co2Country(co2AllCountries.item(i));
			}

		}

	}

	public static Node co2ByCountryAndYear(String country, String year) {
		Node result = null;

		for (int i = 0; i < co2AllCountries.getLength(); i++) {
			Node nNode = co2AllCountries.item(i);
			Element eElement = (Element) nNode;
			String countryName = eElement.getElementsByTagName("field").item(0).getTextContent();
			String countryYear = eElement.getElementsByTagName("field").item(2).getTextContent();

			if (country.equalsIgnoreCase(countryName) && year.equalsIgnoreCase(countryYear)) {

				result = co2AllCountries.item(i);
				break;
			}

		}
		return result;

	}

	public static void print1Co2Country(Node node) {

		Element eElement = (Element) node;

		System.out.println("Country or Area : " + eElement.getElementsByTagName("field").item(0).getTextContent());
		System.out.println("Item : " + eElement.getElementsByTagName("field").item(1).getTextContent());
		System.out.println("Year : " + eElement.getElementsByTagName("field").item(2).getTextContent());
		System.out.println("Value : " + eElement.getElementsByTagName("field").item(3).getTextContent());

		System.out.println();

	}

	public static boolean checkForFalseCountry(String country) {
		boolean status = false;

		for (int i = 0; i < co2AllCountries.getLength(); i++) {
			Node nNode = co2AllCountries.item(i);
			Element eElement = (Element) nNode;
			String countryName = eElement.getElementsByTagName("field").item(0).getTextContent();
			if (country.equalsIgnoreCase(countryName)) {
				status = true;
				break;
			}

		}

		if (status) {
			return true;
		} else {
			return false;
		}
	}

}