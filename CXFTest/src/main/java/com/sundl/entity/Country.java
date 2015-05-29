package com.sundl.entity;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by SDL on 2015/5/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "country")
@XmlType(propOrder = {"name", "provinceList"})
public class Country {
    @XmlElement(name = "country_name")
    private String name;

    @XmlElementWrapper(name = "provinces")
    @XmlElement(name = "province")
    private List<Province> provinceList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", provinceList=" + provinceList +
                '}';
    }
}
