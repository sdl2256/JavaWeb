package com.sundl.xstream;

/**
 * Created by SDL on 2015/5/29.
 * <p/>
 * XStream doesn't care about the visibility of the fields.
 * No getters or setters are needed.
 * Also, XStream does not limit you to having a default constructor.
 */
public class Person {
    private String firstname;
    private String lastname;
    private PhoneNumber phone;
    private PhoneNumber fax;

    public Person(String joe, String walnes) {
        this.firstname = joe;
        this.lastname = walnes;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public void setFax(PhoneNumber fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone=" + phone +
                ", fax=" + fax +
                '}';
    }
}
