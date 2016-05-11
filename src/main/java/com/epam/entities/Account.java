package com.epam.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by Almas_Doskozhin
 * on 5/10/2016.
 */
@Entity
@Table(name = "ACOUNT", catalog = "epam", uniqueConstraints = {
        @UniqueConstraint(columnNames = "PASSWORD"),
        @UniqueConstraint(columnNames = "EMAIL")})
public class Account implements java.io.Serializable {

    private Integer id;
    private String email;
    private String password;
    private Address address;

    public Account() {
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "EMAIL", unique = true, nullable = false, length = 10)
    public String getNumber() {
        return this.email;
    }

    public void setNumber(String number) {
        this.email = number;
    }

    @Column(name = "PASSWORD", unique = true, nullable = false, length = 20)
    public String getPhoneType() {
        return this.password;
    }

    public void setPhoneType(String phoneType) {
        this.password = phoneType;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return com.google.common.base.Objects.equal(id, account.id) &&
                com.google.common.base.Objects.equal(email, account.email) &&
                com.google.common.base.Objects.equal(password, account.password) &&
                com.google.common.base.Objects.equal(address, account.address);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(id, email, password, address);
    }
}
