package utils;

import model.FilterRozetka;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToObject {
    public FilterRozetka convert() {
        try {
            File file = new File("src/main/resources/filterRozetka.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(FilterRozetka.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (FilterRozetka) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;

    }
}
