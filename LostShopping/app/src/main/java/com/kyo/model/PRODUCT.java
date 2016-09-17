package com.kyo.model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by ASUS on 9/12/2016.
 */
public class PRODUCT implements Serializable {

    private String PRO_COLOR;
    private float PRO_DEPTH;
    private String PRO_DES;
    private float PRO_DIAMETER;
    private float PRO_DISCOUNT_AVAILABLE;
    private float PRO_DISCOUNT_PERCENT;
    private int PRO_ID;
    private String PRO_IMAGE;
    private float PRO_LENGTH;
    private String PRO_NAME;
    private float PRO_SALE_UNIT_PRICE;
    private int PRO_SUBCAT_ID;
    private int PRO_SUP_ID;
    private float PRO_SUP_QUANTITY;
    private float PRO_SUP_UNIT_PRICE;
    private float PRO_UNIT_WEIGHT;
    private float PRO_WIDTH;
    private Bitmap BitMapOfImage;

    public Bitmap getBitMapOfImage() {
        return BitMapOfImage;
    }

    public void setBitMapOfImage(Bitmap bitMapOfImage) {
        BitMapOfImage = bitMapOfImage;
    }

    public String getPRO_IMAGE() {
        return PRO_IMAGE;
    }

    public void setPRO_IMAGE(String PRO_IMAGE) {
        this.PRO_IMAGE = PRO_IMAGE;
    }

    public String getPRO_COLOR() {
        return PRO_COLOR;
    }

    public void setPRO_COLOR(String PRO_COLOR) {
        this.PRO_COLOR = PRO_COLOR;
    }

    public float getPRO_DEPTH() {
        return PRO_DEPTH;
    }

    public void setPRO_DEPTH(float PRO_DEPTH) {
        this.PRO_DEPTH = PRO_DEPTH;
    }

    public String getPRO_DES() {
        return PRO_DES;
    }

    public void setPRO_DES(String PRO_DES) {
        this.PRO_DES = PRO_DES;
    }

    public float getPRO_DIAMETER() {
        return PRO_DIAMETER;
    }

    public void setPRO_DIAMETER(float PRO_DIAMETER) {
        this.PRO_DIAMETER = PRO_DIAMETER;
    }

    public float getPRO_DISCOUNT_AVAILABLE() {
        return PRO_DISCOUNT_AVAILABLE;
    }

    public void setPRO_DISCOUNT_AVAILABLE(float PRO_DISCOUNT_AVAILABLE) {
        this.PRO_DISCOUNT_AVAILABLE = PRO_DISCOUNT_AVAILABLE;
    }

    public float getPRO_DISCOUNT_PERCENT() {
        return PRO_DISCOUNT_PERCENT;
    }

    public void setPRO_DISCOUNT_PERCENT(float PRO_DISCOUNT_PERCENT) {
        this.PRO_DISCOUNT_PERCENT = PRO_DISCOUNT_PERCENT;
    }

    public int getPRO_ID() {
        return PRO_ID;
    }

    public void setPRO_ID(int PRO_ID) {
        this.PRO_ID = PRO_ID;
    }

    public float getPRO_LENGTH() {
        return PRO_LENGTH;
    }

    public void setPRO_LENGTH(float PRO_LENGTH) {
        this.PRO_LENGTH = PRO_LENGTH;
    }

    public String getPRO_NAME() {
        return PRO_NAME;
    }

    public void setPRO_NAME(String PRO_NAME) {
        this.PRO_NAME = PRO_NAME;
    }

    public float getPRO_SALE_UNIT_PRICE() {
        return PRO_SALE_UNIT_PRICE;
    }

    public void setPRO_SALE_UNIT_PRICE(float PRO_SALE_UNIT_PRICE) {
        this.PRO_SALE_UNIT_PRICE = PRO_SALE_UNIT_PRICE;
    }

    public int getPRO_SUBCAT_ID() {
        return PRO_SUBCAT_ID;
    }

    public void setPRO_SUBCAT_ID(int PRO_SUBCAT_ID) {
        this.PRO_SUBCAT_ID = PRO_SUBCAT_ID;
    }

    public int getPRO_SUP_ID() {
        return PRO_SUP_ID;
    }

    public void setPRO_SUP_ID(int PRO_SUP_ID) {
        this.PRO_SUP_ID = PRO_SUP_ID;
    }

    public float getPRO_SUP_QUANTITY() {
        return PRO_SUP_QUANTITY;
    }

    public void setPRO_SUP_QUANTITY(float PRO_SUP_QUANTITY) {
        this.PRO_SUP_QUANTITY = PRO_SUP_QUANTITY;
    }

    public float getPRO_SUP_UNIT_PRICE() {
        return PRO_SUP_UNIT_PRICE;
    }

    public void setPRO_SUP_UNIT_PRICE(float PRO_SUP_UNIT_PRICE) {
        this.PRO_SUP_UNIT_PRICE = PRO_SUP_UNIT_PRICE;
    }

    public float getPRO_UNIT_WEIGHT() {
        return PRO_UNIT_WEIGHT;
    }

    public void setPRO_UNIT_WEIGHT(float PRO_UNIT_WEIGHT) {
        this.PRO_UNIT_WEIGHT = PRO_UNIT_WEIGHT;
    }

    public float getPRO_WIDTH() {
        return PRO_WIDTH;
    }

    public void setPRO_WIDTH(float PRO_WIDTH) {
        this.PRO_WIDTH = PRO_WIDTH;
    }
}
