package com.pers.gfc.chapter3.po;

import java.io.Serializable;

/**
 * 性别枚举
 *
 * @author guofucheng
 * @date 2020/10/10
 */
public enum SexEnum2 implements Serializable {
    SEX_MALE(1,"男"),//男
    SEX_FEMALE(2,"女"),//女
    SEX_UNKNOWN(3,"未知"); //未知
    private final int id;
    private final String text;

    SexEnum2(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public static String index(Integer index) {
        switch (index) {
            case 1:
                return SexEnum2.SEX_MALE.toString();
            case 2:
                return SexEnum2.SEX_FEMALE.toString();
            default:
                return SexEnum2.SEX_UNKNOWN.toString();
        }
    }

    public static SexEnum2 entity(Integer index) {
        switch (index) {
            case 1:
                return SexEnum2.SEX_MALE;
            case 2:
                return SexEnum2.SEX_FEMALE;
            default:
                return SexEnum2.SEX_UNKNOWN;
        }
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
