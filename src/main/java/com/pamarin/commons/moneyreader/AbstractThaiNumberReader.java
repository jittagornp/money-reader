/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.commons.moneyreader;

import java.math.BigDecimal;

/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/21
 */
public abstract class AbstractThaiNumberReader {

    private final String NUMBER[] = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
    private final String LEVEL[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน"};

    protected abstract String asString(KeyPair keyPair);

    protected abstract BigDecimal getBaseValue();

    protected String getNumberText(int number) {
        return NUMBER[number];
    }

    protected String getLevelText(int level) {
        return LEVEL[level];
    }

    private BigDecimal getLatestValue(KeyPair keyPair) {
        return new BigDecimal(keyPair.getNumber())
                .multiply(getBaseValue().pow(keyPair.getLevel()));
    }

    private boolean isMoreThanZero(BigDecimal number) {
        return number.compareTo(BigDecimal.ZERO) > 0;
    }

    private boolean isLessThanTen(BigDecimal number) {
        return number.compareTo(BigDecimal.TEN) < 0;
    }

    public String read(BigDecimal number) {
        if (isLessThanTen(number)) {
            return getNumberText(number.intValue());
        }

        StringBuilder result = new StringBuilder();
        do {
            KeyPair keyPair = map(number);
            result.append(asString(keyPair));
            number = number.remainder(getLatestValue(keyPair));//number % latestValue
        } while (isMoreThanZero(number));

        return result.toString();
    }

    private KeyPair map(BigDecimal number) {
        BigDecimal result = number;
        int level = 0;
        //result = result / 10^x > 0
        while (isMoreThanZero(result = removeDecimal(result.divide(getBaseValue())))) {
            number = result;
            level = level + 1;
        }

        return new KeyPair(number.intValue(), level);
    }

    private BigDecimal removeDecimal(BigDecimal number) {
        return number.setScale(0, BigDecimal.ROUND_DOWN);
    }
}
