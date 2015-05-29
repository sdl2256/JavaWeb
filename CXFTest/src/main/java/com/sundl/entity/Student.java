package com.sundl.entity;

import javax.xml.bind.annotation.*;

/**
 * Created by SDL on 2015/5/29.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "student")
@XmlType(propOrder = {})
public class Student {
    @XmlAttribute
    private Integer id;

    @XmlElement
    private String name;

    @XmlElement(name = "role")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
