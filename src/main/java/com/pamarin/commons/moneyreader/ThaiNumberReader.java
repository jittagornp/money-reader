/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.commons.moneyreader;

/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/20
 */
public class ThaiNumberReader implements NumberReader {

    private final String NUMBER[] = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
    private final String LEVEL[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน"};

    @Override
    public String read(Integer number) {
        if (number == null) {
            throw new NullPointerException("required number.");
        }

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

    private Output readText(Integer number) {
        int result = number;
        int level = 0;
        while ((result = result / 10) > 0) {
            number = result;
            level = level + 1;
        }

        Output output = new Output();
        output.setNumber(number);
        output.setLevel(level);
        output.setNumberText(NUMBER[number]);
        output.setLevelText(LEVEL[level]);
        return output;
    }

    private static class Output {

        private Integer number;

        private Integer level;

        private String numberText;

        private String levelText;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public String getNumberText() {
            return numberText;
        }

        public void setNumberText(String numberText) {
            this.numberText = numberText;
        }

        public String getLevelText() {
            return levelText;
        }

        public void setLevelText(String levelText) {
            this.levelText = levelText;
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
                return levelText;
            }

            if (level == 1 && number == 2) {
                return "ยี่" + levelText;
            }

            return numberText + levelText;
        }

    }

}
