/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.commons.moneyreader;

import java.math.BigInteger;

/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/20
 */
public class ThaiNumberReader implements NumberReader {

    //1 ล้าน
    private final BigInteger MILLION = BigInteger.TEN.pow(6);

    @Override
    public String read(Integer number) {
        return read(number == null ? null : BigInteger.valueOf(number));
    }

    @Override
    public String read(BigInteger number) {
        if (number == null) {
            throw new NullPointerException("required number.");
        }

        //อ่านค่า Level ล้าน, ล้านล้าน ขึ้นไป    
        return new AbstractThaiNumberReader() {

            @Override
            protected BigInteger getBaseValue() {
                return MILLION;
            }

            @Override
            protected String asString(KeyPair keyPair) {

                if (isOne(keyPair)) {
                    return "เอ็ด";
                }

                return toText(BigInteger.valueOf(keyPair.getNumber()))
                        + buildLevelText(keyPair.getLevel());
            }
        }.read(number);
    }

    private String buildLevelText(int level) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < level; i++) {
            text.append("ล้าน");
        }
        return text.toString();
    }

    //อ่านค่า Level หน่วย ถึง แสน
    private String toText(BigInteger number) {
        return new AbstractThaiNumberReader() {

            @Override
            protected BigInteger getBaseValue() {
                return BigInteger.TEN;
            }

            @Override
            protected String asString(KeyPair keyPair) {

                if (isOne(keyPair)) {
                    return "เอ็ด";
                }

                if (isTen(keyPair)) {
                    return "สิบ";
                }

                if (isTwenty(keyPair)) {
                    return "ยี่สิบ";
                }

                return getNumberText(keyPair.getNumber())
                        + getLevelText(keyPair.getLevel());
            }
        }.read(number);
    }

    private boolean isOne(KeyPair keyPair) {
        return keyPair.getLevel() == 0
                && keyPair.getNumber() == 1;
    }

    private boolean isTen(KeyPair keyPair) {
        return keyPair.getLevel() == 1
                && keyPair.getNumber() == 1;
    }

    private boolean isTwenty(KeyPair keyPair) {
        return keyPair.getLevel() == 1
                && keyPair.getNumber() == 2;
    }
}
