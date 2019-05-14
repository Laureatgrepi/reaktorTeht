package methods;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import file_content.VakilukuXmlAlustus;

public class Vakiluku {

	public static NodeList vakilukuAllCountries = VakilukuXmlAlustus.vakilukuAll();

	public static void vakilukuAll() {

		for (int i = 0; i < vakilukuAllCountries.getLength(); i++) {
			System.out.println(vakilukuAllCountries.item(i).getTextContent());
		}
	}

	public static void vakilukuByCountry(String country) {
		for (int i = 0; i < vakilukuAllCountries.getLength(); i++) {
			Node nNode = vakilukuAllCountries.item(i);
			Element eElement = (Element) nNode;
			String countryName = eElement.getElementsByTagName("field").item(0).getTextContent();
			if (country.equalsIgnoreCase(countryName)) {
				System.out.println(
						"Country or Area : " + eElement.getElementsByTagName("field").item(0).getTextContent());
				System.out.println("Item : " + eElement.getElementsByTagName("field").item(1).getTextContent());
				System.out.println("Year : " + eElement.getElementsByTagName("field").item(2).getTextContent());
				System.out.println("Value : " + eElement.getElementsByTagName("field").item(3).getTextContent());
				System.out.println();
			}

		}
	}

	public static int vakilukuByCountryAndYear(String country, String year) {

		int resultVakiluku = 0;
				
		for (int i = 0; i < vakilukuAllCountries.getLength(); i++) {
			Node nNode = vakilukuAllCountries.item(i);
			Element eElement = (Element) nNode;
			String countryName = eElement.getElementsByTagName("field").item(0).getTextContent();
			String countryYear = eElement.getElementsByTagName("field").item(2).getTextContent();

			if (country.equalsIgnoreCase(countryName) && year.equalsIgnoreCase(countryYear)) {
				String result = eElement.getElementsByTagName("field").item(3).getTextContent();
				resultVakiluku = Integer.parseInt(result);
				break;
				
			}
			
			
		}
		return resultVakiluku;

		

	}
	

}
