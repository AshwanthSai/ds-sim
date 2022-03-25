import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  

public class XMLParse {  
public static void main(String argv[]) {  
    try   
        {  
        //creating a constructor of file class and parsing an XML file  
        File file = new File("ds-system.xml");  

        //an instance of factory that gives a document builder  
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  

        //an instance of builder to parse the specified xml file  
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(file);  

        doc.getDocumentElement().normalize();  
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
        NodeList nodeList = doc.getElementsByTagName("servers");  

        // nodeList is not iterable, so we are using for loop  
        for (int itr = 0; itr < nodeList.getLength(); itr++)   {  
            Node node = nodeList.item(itr);  
            System.out.println("\nNode Name :" + node.getNodeName());  
            if (node.getNodeType() == Node.ELEMENT_NODE)   {  
                Element eElement = (Element) node;  
                System.out.println("Server Type "+ eElement.getElementsByTagName("type").item(0).getTextContent()); 
                System.out.println("Limit "+ eElement.getElementsByTagName("limit").item(0).getTextContent());  
                System.out.println("BootupTime"+ eElement.getElementsByTagName("bootupTime").item(0).getTextContent());  
                System.out.println("HourlyRate: "+ eElement.getElementsByTagName("hourlyRate").item(0).getTextContent());  
                System.out.println("Cores: "+ eElement.getElementsByTagName("cores").item(0).getTextContent());  
                System.out.println("memory: "+ eElement.getElementsByTagName("memory").item(0).getTextContent()); 
                System.out.println("disk: "+ eElement.getElementsByTagName("disk").item(0).getTextContent()); 
            }  
        }  
    }   
    catch (Exception e)   {  
        e.printStackTrace();  
    }  
    }  
} 