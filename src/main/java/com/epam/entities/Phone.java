package com.epam.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by 
 * Almas_Doskozhin on 5/10/2016.
 */
@Entity
@Table(name = "PHONE")
public class Phone implements java.io.Serializable{
    private Integer id;
    private String number;
    private PhoneType phoneType;
    private User user;

    public Phone(String number, PhoneType phoneType) {
        super();
        this.number = number;
        this.phoneType = phoneType;
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



    @Column(name = "NUMBER", unique = true, nullable = false, length = 20)
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "PHONE_TYPE", unique = true, nullable = false, length = 20)
    public PhoneType getPhoneType() {
        return this.phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_REF")
    @Fetch(FetchMode.JOIN)
    public User getUser() {
        return user;
    }

    public void setAccount(User user) {
        this.user = user;
    }
}
