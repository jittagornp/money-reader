package com.pamarin.commons.moneyreader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.pamarin.commons.moneyreader.ThaiNumberReader;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jittagornp <http://jittagornp.me>
 */
public class ThaiNumberReaderTest {

    private ThaiNumberReader reader;

    @Before
    public void before() {
        reader = new ThaiNumberReader();
    }

    @Test(expected = NullPointerException.class)
    public void shouldBeThrowNullPointerExcception_WhenInputIsNull() {
        Integer input = null;
        String output = reader.read(input);

    }

    @Test
    public void shouldBeศูนย์_whenInputIs0() {

        Integer input = 0;
        String output = reader.read(input);
        String expected = "ศูนย์";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่ง_whenInputIs1() {

        Integer input = 1;
        String output = reader.read(input);
        String expected = "หนึ่ง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBesห้า_whenInputIs5() {

        Integer input = 5;
        String output = reader.read(input);
        String expected = "ห้า";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบ_whenInputIs10() {

        Integer input = 10;
        String output = reader.read(input);
        String expected = "สิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeยี่สิบ_whenInputIs20() {

        Integer input = 20;
        String output = reader.read(input);
        String expected = "ยี่สิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeยี่สิบสี่_whenInputIs24() {

        Integer input = 24;
        String output = reader.read(input);
        String expected = "ยี่สิบสี่";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบเอ็ด_whenInputIs11() {

        Integer input = 11;
        String output = reader.read(input);
        String expected = "สิบเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งร้อยสิบเอ็ด_whenInputIs111() {

        Integer input = 111;
        String output = reader.read(input);
        String expected = "หนึ่งร้อยสิบเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งพันเอ็ด_whenInputIs1001() {

        Integer input = 1001;
        String output = reader.read(input);
        String expected = "หนึ่งพันเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสามหมื่นหนึ่งพันหกร้อยเอ็ด_whenInputIs31601() {

        Integer input = 31601;
        String output = reader.read(input);
        String expected = "สามหมื่นหนึ่งพันหกร้อยเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งพันสิบเอ็ด_whenInputIs1011() {

        Integer input = 1011;
        String output = reader.read(input);
        String expected = "หนึ่งพันสิบเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบสอง_whenInputIs12() {

        Integer input = 12;
        String output = reader.read(input);
        String expected = "สิบสอง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบห้า_whenInputIs15() {

        Integer input = 15;
        String output = reader.read(input);
        String expected = "สิบห้า";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสามสิบ_whenInputIs30() {

        Integer input = 30;
        String output = reader.read(input);
        String expected = "สามสิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeเจ็ดสิบ_whenInputIs70() {

        Integer input = 70;
        String output = reader.read(input);
        String expected = "เจ็ดสิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสามสิบห้า_whenInputIs35() {

        Integer input = 35;
        String output = reader.read(input);
        String expected = "สามสิบห้า";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeแปดสิบสอง_whenInputIs82() {

        Integer input = 82;
        String output = reader.read(input);
        String expected = "แปดสิบสอง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งร้อยแปดสิบสอง_whenInputIs182() {

        Integer input = 182;
        String output = reader.read(input);
        String expected = "หนึ่งร้อยแปดสิบสอง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งแสนแปดหมื่นสองพันหกร้อยเก้าสิบห้า_whenInputIs182695() {

        Integer input = 182695;
        String output = reader.read(input);
        String expected = "หนึ่งแสนแปดหมื่นสองพันหกร้อยเก้าสิบห้า";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งล้าน_whenInputIs1000000() {

        Integer input = 1000000;
        String output = reader.read(input);
        String expected = "หนึ่งล้าน";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งล้านเอ็ด_whenInputIs1000001() {

        Integer input = 1000001;
        String output = reader.read(input);
        String expected = "หนึ่งล้านเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งล้านสอง_whenInputIs1000002() {

        Integer input = 1000002;
        String output = reader.read(input);
        String expected = "หนึ่งล้านสอง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งล้านสิบเอ็ด_whenInputIs1000011() {

        Integer input = 1000011;
        String output = reader.read(input);
        String expected = "หนึ่งล้านสิบเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งล้านเจ็ดแสนสามหมื่นสามพันสี่ร้อยยี่สิบเอ็ด_whenInputIs1733421() {

        Integer input = 1733421;
        String output = reader.read(input);
        String expected = "หนึ่งล้านเจ็ดแสนสามหมื่นสามพันสี่ร้อยยี่สิบเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบเอ็ดล้านสามสิบสาม_whenInputIs11000033() {

        Integer input = 11000033;
        String output = reader.read(input);
        String expected = "สิบเอ็ดล้านสามสิบสาม";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeยี่สิบเอ็ดล้านสามสิบสาม_whenInputIs21000033() {

        Integer input = 21000033;
        String output = reader.read(input);
        String expected = "ยี่สิบเอ็ดล้านสามสิบสาม";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeยี่สิบเอ็ดล้านเอ็ด_whenInputIs21000001() {

        Integer input = 21000001;
        String output = reader.read(input);
        String expected = "ยี่สิบเอ็ดล้านเอ็ด";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสามร้อยห้าสิบล้าน_whenInputIs350000000() {

        Integer input = 350000000;
        String output = reader.read(input);
        String expected = "สามร้อยห้าสิบล้าน";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeห้าพันห้าร้อยล้าน_whenInputIs5500000000() {

        BigInteger input = BigInteger.valueOf(5500000000L);
        String output = reader.read(input);
        String expected = "ห้าพันห้าร้อยล้าน";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสองแสนหนึ่งร้อยล้านแปดพันสองร้อยสิบสี่_whenInputIs200100008214() {

        BigInteger input = BigInteger.valueOf(200100008214L);
        String output = reader.read(input);
        String expected = "สองแสนหนึ่งร้อยล้านแปดพันสองร้อยสิบสี่";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งล้านล้าน_whenInputIs1000000000000() {

        BigInteger input = BigInteger.valueOf(1000000000000L);
        String output = reader.read(input);
        String expected = "หนึ่งล้านล้าน";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งล้านล้านหนึ่งล้าน_whenInputIs1000001000000() {

        BigInteger input = BigInteger.valueOf(1000001000000L);
        String output = reader.read(input);
        String expected = "หนึ่งล้านล้านหนึ่งล้าน";

        assertEquals(expected, output);
    }

}
