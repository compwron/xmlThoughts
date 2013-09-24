package src;

import generated.Notice;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class Sample {
    public Sample(Notice notice) throws JAXBException, SAXException {


        JAXBContext jaxbContext = JAXBContext.newInstance("generated");

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("jaxbJarGeneration//sample_xsd.xsd"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(schema);


        marshaller.marshal(notice, new DefaultHandler());
    }


}
