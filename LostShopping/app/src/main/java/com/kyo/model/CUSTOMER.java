package com.kyo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ASUS on 9/7/2016.
 */
public class CUSTOMER implements Serializable {
    private String CUS_ACCOUNT;
    private String CUS_ADDRESS;
    private String CUS_CITY;
    private String CUS_COUNTRY;
    private String CUS_EMAIL;
    private String CUS_FIRSTNAME;
    private int CUS_ID;
    private String CUS_LASTNAME;
    private String CUS_PASS;
    private String CUS_PHONE;
    private Date CUS_REGISTRATION_DATE;

    public String getCUS_ACCOUNT() {
        return CUS_ACCOUNT;
    }

    public void setCUS_ACCOUNT(String CUS_ACCOUNT) {
        this.CUS_ACCOUNT = CUS_ACCOUNT;
    }

    public String getCUS_ADDRESS() {
        return CUS_ADDRESS;
    }

    public void setCUS_ADDRESS(String CUS_ADDRESS) {
        this.CUS_ADDRESS = CUS_ADDRESS;
    }

    public String getCUS_CITY() {
        return CUS_CITY;
    }

    public void setCUS_CITY(String CUS_CITY) {
        this.CUS_CITY = CUS_CITY;
    }

    public String getCUS_COUNTRY() {
        return CUS_COUNTRY;
    }

    public void setCUS_COUNTRY(String CUS_COUNTRY) {
        this.CUS_COUNTRY = CUS_COUNTRY;
    }

    public String getCUS_EMAIL() {
        return CUS_EMAIL;
    }

    public void setCUS_EMAIL(String CUS_EMAIL) {
        this.CUS_EMAIL = CUS_EMAIL;
    }

    public String getCUS_FIRSTNAME() {
        return CUS_FIRSTNAME;
    }

    public void setCUS_FIRSTNAME(String CUS_FIRSTNAME) {
        this.CUS_FIRSTNAME = CUS_FIRSTNAME;
    }

    public int getCUS_ID() {
        return CUS_ID;
    }

    public void setCUS_ID(int CUS_ID) {
        this.CUS_ID = CUS_ID;
    }

    public String getCUS_LASTNAME() {
        return CUS_LASTNAME;
    }

    public void setCUS_LASTNAME(String CUS_LASTNAME) {
        this.CUS_LASTNAME = CUS_LASTNAME;
    }

    public String getCUS_PASS() {
        return CUS_PASS;
    }

    public void setCUS_PASS(String CUS_PASS) {
        this.CUS_PASS = CUS_PASS;
    }

    public String getCUS_PHONE() {
        return CUS_PHONE;
    }

    public void setCUS_PHONE(String CUS_PHONE) {
        this.CUS_PHONE = CUS_PHONE;
    }

    public Date getCUS_REGISTRATION_DATE() {
        return CUS_REGISTRATION_DATE;
    }

    public void setCUS_REGISTRATION_DATE(Date CUS_REGISTRATION_DATE) {
        this.CUS_REGISTRATION_DATE = CUS_REGISTRATION_DATE;
    }
}
