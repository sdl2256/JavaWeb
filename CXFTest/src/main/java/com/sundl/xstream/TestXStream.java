package com.sundl.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * Created by SDL on 2015/5/29.
 */
public class TestXStream {
    public static void main(String[] args) {
        XStream xStream = new XStream();
    /*
        // does not require XPP3 library
        XStream xstream = new XStream(new DomDriver());
        // does not require XPP3 library starting with Java 6
        XStream xstream = new XStream(new StaxDriver());
    */
        // Without it XStream would work fine,
        // but the XML element names would contain the fully qualified name
        // of each class (including package) which would bulk up the XML a bit.

        xStream.alias("person", Person.class);

        Person joe = new Person("Joe", "Walnes");

        joe.setPhone(new PhoneNumber(123, "1234-456"));

        joe.setFax(new PhoneNumber(123, "9999-999"));

        String xml = xStream.toXML(joe);

        System.out.println(xml);

        Person newJoe = (Person) xStream.fromXML(xml);

        System.out.println(newJoe);
    }
}
