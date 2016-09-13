package com.kyo.model;

import java.io.Serializable;

/**
 * Created by ASUS on 9/13/2016.
 */
public class SUBCATEGORY implements Serializable {
    private int SUBCAT_ID;
    private String SUBCAT_NAME;
    private String SUBCAT_DES;
    private int SUBCAT_CAT_ID;

    public int getSUBCAT_ID() {
        return SUBCAT_ID;
    }

    public void setSUBCAT_ID(int SUBCAT_ID) {
        this.SUBCAT_ID = SUBCAT_ID;
    }

    public String getSUBCAT_NAME() {
        return SUBCAT_NAME;
    }

    public void setSUBCAT_NAME(String SUBCAT_NAME) {
        this.SUBCAT_NAME = SUBCAT_NAME;
    }

    public String getSUBCAT_DES() {
        return SUBCAT_DES;
    }

    public void setSUBCAT_DES(String SUBCAT_DES) {
        this.SUBCAT_DES = SUBCAT_DES;
    }

    public int getSUBCAT_CAT_ID() {
        return SUBCAT_CAT_ID;
    }

    public void setSUBCAT_CAT_ID(int SUBCAT_CAT_ID) {
        this.SUBCAT_CAT_ID = SUBCAT_CAT_ID;
    }
}
