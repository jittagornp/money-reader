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

    private static final String NUMBER[] = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
    private static final String LEVEL[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน"};

    @Override
    public String read(Integer number) {
        return read(number == null ? null : new BigDecimal(number));
    }

    @Override
    public String read(BigDecimal number) {
        if (number == null) {
            throw new NullPointerException("required number.");
        }

        BigDecimal million = BigDecimal.valueOf(Math.pow(10L, 6));
        int top = number.divide(million).intValue();
        if (top > 0) {
            String text = readMillionText(top) + "ล้าน";
            int result = number.subtract(million.multiply(BigDecimal.valueOf(top))).intValue();
            if (result > 0) {
                if (result == 1) {
                    text = text + "เอ็ด";
                } else {
                    text = text + readMillionText(result);
                }
            }

            return text;
        }

        return readMillionText(number.intValue());
    }

    private String readMillionText(int number) {
        if (number < 10) {
            return NUMBER[number];
        }

        StringBuilder result = new StringBuilder();
        do {
            Output output = readText(number);
            result.append(output.toString());
            number = (int) (number % output.getValue());
        } while (number > 0);

        return result.toString();
    }

    private Output readText(int number) {
        int result = number;
        int level = 0;
        while ((result = result / 10) > 0) {
            number = result;
            level = level + 1;
        }

        return new Output(number, level);
    }

    private static class Output {

        private final int number;

        private final int level;

        public Output(int number, int level) {
            this.number = number;
            this.level = level;
        }

        public int getNumber() {
            return number;
        }

        public int getLevel() {
            return level;
        }

        public double getValue() {
            return number * Math.pow(10L, level);
        }

        @Override
        public String toString() {

            if (level == 0 && number == 1) {
                return "เอ็ด";
            }

            if (level == 1 && number == 1) {
                return LEVEL[level];
            }

            if (level == 1 && number == 2) {
                return "ยี่" + LEVEL[level];
            }

            return NUMBER[number] + LEVEL[level];
        }

    }

}
