package methods;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Co2_vakiluku {

	public static float co2PerCapita(String country, String year) {

		Node co2Node = Co2.co2ByCountryAndYear(country, year);
		float co2PerYearPerCountry = 0;
		Element co2Element = (Element) co2Node;
		String co2 = co2Element.getElementsByTagName("field").item(3).getTextContent();
		if(co2.length() == 0){
			return 0;
		}else {
			co2PerYearPerCountry = Float.parseFloat(co2);
			
		}
		
		
		
		
		float vakiluku = Vakiluku.vakilukuByCountryAndYear(country, year);
		
		float co2PerCapita = co2PerYearPerCountry / vakiluku;
		return co2PerCapita;	
	}

}
