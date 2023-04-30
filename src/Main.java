import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.print("Write book id: ");
            Scanner scan = new Scanner(System.in);
            String bookId = scan.nextLine();

            System.out.println("Searching for book with id '"+ bookId +"'...");
            System.out.print("\n");

            NodeList nodeList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node myNode = nodeList.item(temp);
                if (myNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemant = (Element) myNode;
                    if (elemant.getAttribute("id").equals(bookId)){
                        System.out.println("Book id -> "
                                + elemant.getAttribute("id"));
                        System.out.println("Author -> "
                                + elemant
                                .getElementsByTagName("author")
                                .item(0)
                                .getTextContent());
                        System.out.println("Title -> "
                                + elemant
                                .getElementsByTagName("title")
                                .item(0)
                                .getTextContent());
                        System.out.println("Genre -> "
                                + elemant
                                .getElementsByTagName("genre")
                                .item(0)
                                .getTextContent());
                        System.out.println("Price -> "
                                + elemant
                                .getElementsByTagName("price")
                                .item(0)
                                .getTextContent());
                        System.out.println("Publish Date -> "
                                + elemant
                                .getElementsByTagName("publish_date")
                                .item(0)
                                .getTextContent());
                        System.out.println("Description -> "
                                + elemant
                                .getElementsByTagName("description")
                                .item(0)
                                .getTextContent());
                        return;
                    }
                }
            }
            System.out.println("Book with id '"+ bookId +"' Not Found");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}