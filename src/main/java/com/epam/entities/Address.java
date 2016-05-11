package com.epam.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Almas_Doskozhin
 * on 5/10/2016.
 */
@Embeddable
public class Address implements java.io.Serializable{
    private String street;
    private String house;
    private String flat;

    public Address() {
        super();
    }

    @Column(name = "STREET", unique = true, nullable = false, length = 20)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "HOUSE", unique = true, nullable = false, length = 20)
    public String getHouse() {
        return this.house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Column(name = "FLAT", unique = true, nullable = false, length = 20)
    public String getFlat() {
        return this.flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return com.google.common.base.Objects.equal(street, address.street) &&
                com.google.common.base.Objects.equal(house, address.house) &&
                com.google.common.base.Objects.equal(flat, address.flat);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(street, house, flat);
    }
}
