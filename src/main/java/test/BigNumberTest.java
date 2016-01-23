package main.java.test;

import main.java.bignumbers.BigNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class BigNumberTest extends Assert{

    private BigNumber bigNumber;
    private BigNumber bigNumber2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addTest_TC01() {
        bigNumber = new BigNumber("300");
        bigNumber2 = new BigNumber("400");

        assertEquals("700", bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC02() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("700");

        assertEquals("1400", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC03() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("300");

        assertEquals("1000", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC04() {
        bigNumber = new BigNumber("7000000000000");
        bigNumber2 = new BigNumber("30773730000000");

        assertEquals("37773730000000", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void addTest_TC05() {
        bigNumber = new BigNumber("70002400000000");
        bigNumber2 = new BigNumber("30773730000000");

        assertEquals("100776130000000", this.bigNumber.add(bigNumber2).getValue());
    }

    @Test
    public void substractTest_TC01() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("100");

        assertEquals("600", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    public void substractTest_TC02() {
        bigNumber = new BigNumber("720");
        bigNumber2 = new BigNumber("100");

        assertEquals("620", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    public void substractTest_TC03() {
        bigNumber = new BigNumber("37773730000000");
        bigNumber2 = new BigNumber("7000000000000");

        assertEquals("30773730000000", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    @Ignore
    public void substractTest_TC04() {
        bigNumber = new BigNumber("100");
        bigNumber2 = new BigNumber("90");

        assertEquals("10", this.bigNumber.substract(bigNumber2).getValue());
    }

    @Test
    public void substractTest_TC05() {
        bigNumber = new BigNumber("100");
        bigNumber2 = new BigNumber("90");

        Map.Entry<Byte, Byte> entry = bigNumber.substractDigits((byte) 3, (byte) 5, (byte) 0);
        assertEquals(2, entry.getKey().byteValue());
        assertEquals(1, entry.getValue().byteValue());
    }
}
