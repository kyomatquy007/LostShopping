package com.kyo.model;

import java.io.Serializable;

/**
 * Created by ASUS on 9/13/2016.
 */
public class CATEGORY implements Serializable {
    private int CAT_ID;
    private String CAT_NAME;
    private String CAT_DES;

    public int getCAT_ID() {
        return CAT_ID;
    }

    public void setCAT_ID(int CAT_ID) {
        this.CAT_ID = CAT_ID;
    }

    public String getCAT_NAME() {
        return CAT_NAME;
    }

    public void setCAT_NAME(String CAT_NAME) {
        this.CAT_NAME = CAT_NAME;
    }

    public String getCAT_DES() {
        return CAT_DES;
    }

    public void setCAT_DES(String CAT_DES) {
        this.CAT_DES = CAT_DES;
    }
}
