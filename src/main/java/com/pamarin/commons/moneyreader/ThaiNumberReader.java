/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.commons.moneyreader;

import java.math.BigDecimal;

/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/20
 */
public class ThaiNumberReader implements NumberReader {

    //1 ล้าน
    private final BigDecimal MILLION = BigDecimal.TEN.pow(6);

    @Override
    public String read(Integer number) {
        return read(number == null ? null : new BigDecimal(number));
    }

    @Override
    public String read(BigDecimal number) {
        if (number == null) {
            throw new NullPointerException("required number.");
        }

        //อ่านค่า Level ล้าน, ล้านล้าน ขึ้นไป    
        return new AbstractThaiNumberReader() {

            @Override
            protected BigDecimal getBaseValue() {
                return MILLION;
            }

            @Override
            protected String asString(KeyPair keyPair) {

                if (keyPair.getLevel() == 0 && keyPair.getNumber() == 1) {
                    return "เอ็ด";
                }

                return readText(BigDecimal.valueOf(keyPair.getNumber()))
                        + buildLevelText(keyPair.getLevel());
            }
        }.read(number);
    }

    private String buildLevelText(int level) {
        String text = "";
        for (int i = 0; i < level; i++) {
            text = text + "ล้าน";
        }
        return text;
    }

    //อ่านค่า Level หน่วย ถึง แสน
    private String readText(BigDecimal number) {
        return new AbstractThaiNumberReader() {

            @Override
            protected BigDecimal getBaseValue() {
                return BigDecimal.TEN;
            }

            @Override
            protected String asString(KeyPair keyPair) {

                if (keyPair.getLevel() == 0 && keyPair.getNumber() == 1) {
                    return "เอ็ด";
                }

                if (keyPair.getLevel() == 1 && keyPair.getNumber() == 1) {
                    return getLevelText(keyPair.getLevel());
                }

                if (keyPair.getLevel() == 1 && keyPair.getNumber() == 2) {
                    return "ยี่" + getLevelText(keyPair.getLevel());
                }

                return getNumberText(keyPair.getNumber())
                        + getLevelText(keyPair.getLevel());
            }
        }.read(number);
    }
}
