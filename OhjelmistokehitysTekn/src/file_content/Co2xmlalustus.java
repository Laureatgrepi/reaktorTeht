package file_content;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;

public class Co2xmlalustus {
	public static NodeList co2XmlAlustus() {
		try {

			 File fXmlFile = new File("C:\\Users\\laure\\Desktop\\Koulutyöt\\himassa_ws\\OhjelmistokehitysTekn\\src\\xml_files\\co2-paasto.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				
				
				
				NodeList nList = doc.getElementsByTagName("record");
				return nList;
				
				

			
		 }catch (Exception e) {
				return null;
				
		 }	
	}
	

}
