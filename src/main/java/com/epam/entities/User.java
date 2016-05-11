package com.epam.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by 
 * Almas_Doskozhin on 5/10/2016.
 */
@Entity
public class User extends Account implements java.io.Serializable{
    private String firstName;
    private String lastName;
    private Set<Phone> phones;

    public User(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

   @Column(name = "FIRST_NAME", unique = true, nullable = false, length = 20)
    public String getNumber() {
        return this.firstName;
    }

    public void setNumber(String number) {
        this.firstName = number;
    }

    @Column(name = "LAST_NAME", unique = true, nullable = false, length = 20)
    public String getPhoneType() {
        return this.lastName;
    }

    public void setPhoneType(String phoneType) {
        this.lastName = phoneType;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "ACCOUNT_REF", insertable = false, updatable = false)
    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
