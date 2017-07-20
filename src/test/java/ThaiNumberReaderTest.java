/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pamarin.commons.moneyreader.NumberReader;
import com.pamarin.commons.moneyreader.ThaiNumberReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        String output = reader.reader(input);

    }

    @Test
    public void shouldBeศูนย์_whenInputIs0() {

        Integer input = 0;
        String output = reader.reader(input);
        String expected = "ศูนย์";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่ง_whenInputIs1() {

        Integer input = 1;
        String output = reader.reader(input);
        String expected = "หนึ่ง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBesห้า_whenInputIs5() {

        Integer input = 5;
        String output = reader.reader(input);
        String expected = "ห้า";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบ_whenInputIs10() {

        Integer input = 10;
        String output = reader.reader(input);
        String expected = "สิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeยี่สิบ_whenInputIs20() {

        Integer input = 20;
        String output = reader.reader(input);
        String expected = "ยี่สิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeยี่สิบสี่_whenInputIs24() {

        Integer input = 24;
        String output = reader.reader(input);
        String expected = "ยี่สิบสี่";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบหนึ่ง_whenInputIs11() {

        Integer input = 11;
        String output = reader.reader(input);
        String expected = "สิบหนึ่ง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบสอง_whenInputIs12() {

        Integer input = 12;
        String output = reader.reader(input);
        String expected = "สิบสอง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสิบห้า_whenInputIs15() {

        Integer input = 15;
        String output = reader.reader(input);
        String expected = "สิบห้า";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสามสิบ_whenInputIs30() {

        Integer input = 30;
        String output = reader.reader(input);
        String expected = "สามสิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeเจ็ดสิบ_whenInputIs70() {

        Integer input = 70;
        String output = reader.reader(input);
        String expected = "เจ็ดสิบ";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeสามสิบห้า_whenInputIs35() {

        Integer input = 35;
        String output = reader.reader(input);
        String expected = "สามสิบห้า";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeแปดสิบสอง_whenInputIs82() {

        Integer input = 82;
        String output = reader.reader(input);
        String expected = "แปดสิบสอง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งร้อยแปดสิบสอง_whenInputIs182() {

        Integer input = 182;
        String output = reader.reader(input);
        String expected = "หนึ่งร้อยแปดสิบสอง";

        assertEquals(expected, output);
    }

    @Test
    public void shouldBeหนึ่งแสนแปดหมื่นสองพันหกร้อยเก้าสิบห้า_whenInputIs182695() {

        Integer input = 182695;
        String output = reader.reader(input);
        String expected = "หนึ่งแสนแปดหมื่นสองพันหกร้อยเก้าสิบห้า";

        assertEquals(expected, output);
    }
}
