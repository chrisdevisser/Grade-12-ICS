package u3a5_chrisdevisser_xml;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Chris DeVisser
 */
public class Main {
    /**
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        final String infile = "XMLCreate.xml";
        final String outfile = "XMLCreate-out.xml";

        try {
            createXML(infile);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(infile);

            encloseInSchoolBoard(doc, "WRDSB");
            createCourse(doc);
            createCourse(doc);

            changeElementText(doc, "teacher", "David Wilhelm");
            changeElementText(doc, "code", "ICS4U");
            changeElementText(doc, "description", "Computer Programming, Grade 12, University");

            outputXML(new StreamResult(new File(outfile)), doc);
            outputXML(new StreamResult(System.out), doc);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates the XML shown in the assignment.
     * @param filename The name of the XML file
     * @return Whether creation succeeded
     */
    static boolean createXML(String filename) {
        OutputStreamWriter fout = null;

        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(filename));
            fout = new OutputStreamWriter(os);

            //\r\n for spe-diddly-ecial Windows still needing them
            //not sure if Java, like C++, turns \n into \r\n on Windows; C# doesn't
            fout.write("<course>\r\n");
            fout.write("\t<code>ICS4C</code>\r\n");
            fout.write("\t<description> Computer Programming, Grade 12, College</description>\r\n");
            fout.write("\t<teacher>Teacher A </teacher>\r\n");
            fout.write("\t<fileType>Unmodified</fileType>\r\n");
            fout.write("</course>\r\n");

            fout.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to create XML file.");
            return false;
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception ex) {}
        }

        return true;
    }

    /**
     * Creates a new course inside the schoolBoard element.
     * @param doc The DOM document.
     */
    static void createCourse(Document doc) {
        Scanner in = new Scanner(System.in);
        Node parent = doc.getElementsByTagName("schoolBoard").item(0);

        System.out.println("Enter the course code: ");
        String code = in.nextLine();

        System.out.println("Enter the course description: ");
        String desc = in.nextLine();

        System.out.println("Enter the course teacher: ");
        String teacher = in.nextLine();

        System.out.println();
        Element course = doc.createElement("course");

        Element codeNode = doc.createElement("code");
        codeNode.setTextContent(code);
        course.appendChild(codeNode);

        Element descNode = doc.createElement("description");
        descNode.setTextContent(desc);
        course.appendChild(descNode);

        Element teacherNode = doc.createElement("teacher");
        teacherNode.setTextContent(teacher);
        course.appendChild(teacherNode);
        
        Element fileTypeNode = doc.createElement("fileType");
        fileTypeNode.setTextContent("Unmodified");
        course.appendChild(fileTypeNode);

        parent.appendChild(course);
    }

    /**
     * Wraps contents of DOM in schoolBoard element with name.
     * @param doc The DOM document
     * @param name The name of the school board
     */
    static void encloseInSchoolBoard(Document doc, String name) {
        Element newRoot = doc.createElement("schoolBoard");
        Node root = doc.getElementsByTagName("course").item(0);
        Element schoolBoardName = doc.createElement("name");

        //append old tree onto new root
        schoolBoardName.setTextContent(name);
        newRoot.appendChild(schoolBoardName);
        newRoot.appendChild(root);
        doc.appendChild(newRoot);
    }

    /**
     * Changes text in one element of the ICS4U element.
     * @param doc The DOM document
     * @param name The name of the element to change
     * @param text The new text
     */
    static void changeElementText(Document doc, String name, String text) {
        Node node = doc.getElementsByTagName(name).item(0);
        node.setTextContent(text);
    }

    /**
     * Displays an XML file.
     * @param stream The stream to display it to
     * @param doc The XML document
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    static void outputXML(StreamResult stream, Document doc) throws TransformerConfigurationException, TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        trans.transform(source, stream);
    }
}
