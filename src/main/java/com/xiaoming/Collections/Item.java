package com.xiaoming.Collections;

import java.util.Objects;

public class Item implements Comparable {

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }


    public Item() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.description, this.partNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Item other = (Item) obj;
        return Objects.equals(other.getDescription(), this.description) && other.getPartNumber() == this.partNumber;
    }

    @Override
    public String toString() {
        return "[description:" + this.getDescription() + "partNumber:" + this.getPartNumber() + "]";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Item){
            int diff=Integer.compare(partNumber,((Item) o).getPartNumber());
            return diff!=0?diff:description.compareTo(((Item) o).getDescription());
        }
        return 0;
    }
}
