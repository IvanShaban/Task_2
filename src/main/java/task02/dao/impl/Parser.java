package task02.dao.impl;

import task02.entity.Appliance;
import task02.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Parser {
    private static final String FILE_NAME = "D:\\Учеба\\EPAM\\jwd-task01-template_v2\\src\\main\\resources\\appliances.xml";

    public List<Appliance> parse(Criteria criteria) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler(criteria);
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            File file = new File(FILE_NAME);
            parser.parse(file, handler);
            return handler.getResult();
        } catch (SAXException e) {
            System.out.println("Sax parsing error" + e);
        } catch (IOException e) {
            System.out.println("IO parser error" + e);
        } catch (Exception e) {
            System.out.println("Open sax parser error" + e);
        }
        return null;
    }
}
