package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filter")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilterRozetka {
    private String itemName;
    private int sumLimit;

    public String getItemName() {
        return itemName;
    }

    public int getSumLimit() {
        return sumLimit;
    }

    @Override
    public String toString() {
        return "filterRozetka{" +
                "itemName='" + itemName + '\'' +
                ", sumLimit=" + sumLimit +
                '}';
    }
}
