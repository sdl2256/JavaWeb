package com.sundl.xstream.Jettison;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * Created by SDL on 2015/5/29.
 */
public class WriteTest {
    public static void main(String[] args) {

        Product product = new Product("Banana", "123", 23.00);
        XStream xstream = new XStream(new JettisonMappedXmlDriver());

        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("product", Product.class);

        System.out.println(xstream.toXML(product));
    }

}
