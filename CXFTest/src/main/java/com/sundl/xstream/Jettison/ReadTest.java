package com.sundl.xstream.Jettison;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * Created by SDL on 2015/5/29.
 */
public class ReadTest {
    public static void main(String[] args) {
        String json = "{\"product\":{\"name\":\"Banana\",\"id\":\"123\""
                + ",\"price\":\"23.0\"}}";

        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.alias("product", Product.class);
        Product product = (Product) xstream.fromXML(json);
        System.out.println(product);

    }
}
